package com.agriculture.project.service.impl;

import com.agriculture.project.controller.request.*;
import com.agriculture.project.model.Authority;
import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Product;
import com.agriculture.project.model.User;
import com.agriculture.project.model.dto.UserInfoDto;
import com.agriculture.project.model.value.Role;
import com.agriculture.project.repository.FarmRepository;
import com.agriculture.project.repository.ProductRepository;
import com.agriculture.project.repository.UserRepository;
import com.agriculture.project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FarmRepository farmRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean assignFarm(FarmsUsersRequest farmsUsersRequest) {
        Optional<User> userOp = userRepository.findById(farmsUsersRequest.getUserId());
        Optional<Farm> farmOp = farmRepository.findById(farmsUsersRequest.getFarmId());
        if(userOp.isPresent() && farmOp.isPresent()){
            User u = userOp.get();
            Farm f = farmOp.get();
            Set<User> users = f.getUsers();
            if(!users.contains(u)){
                users.add(u);
                f.setUsers(users);
                u.getFarms().add(f);
                farmRepository.save(f);
                userRepository.save(u);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean revokeFarm(FarmsUsersRequest farmsUsersRequest) {
        Optional<User> userOp = userRepository.findById(farmsUsersRequest.getUserId());
        Optional<Farm> farmOp = farmRepository.findById(farmsUsersRequest.getFarmId());

        if(userOp.isPresent() && farmOp.isPresent()){
            User u = userOp.get();
            Farm f = farmOp.get();
            if(f.getUsers().contains(u)){
                f.getUsers().remove(u);
                u.getFarms().remove(f);
                farmRepository.save(f);
                userRepository.save(u);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean assignProduct(ProductsUsersRequest productsUsersRequest) {
        Optional<User> userOp = userRepository.findById(productsUsersRequest.getUserId());
        Optional<Product> productOp = productRepository.findById(productsUsersRequest.getProductId());
        if(userOp.isPresent() && productOp.isPresent()){
            User u = userOp.get();
            Product p = productOp.get();
            if(!p.getUsers().contains(u)){
                p.getUsers().add(u);
                u.getProducts().add(p);
                productRepository.save(p);
                userRepository.save(u);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean revokeProduct(ProductsUsersRequest productsUsersRequest) {
        Optional<User> userOp = userRepository.findById(productsUsersRequest.getUserId());
        Optional<Product> productOp = productRepository.findById(productsUsersRequest.getProductId());
        if(userOp.isPresent() && productOp.isPresent()){
            User u = userOp.get();
            Product p = productOp.get();
            if(p.getUsers().contains(u)){
                p.getUsers().remove(u);
                u.getProducts().remove(p);
                productRepository.save(p);
                userRepository.save(u);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registerUser(RegisterUserRequest registerUserRequest) {
        if(userRepository.existsByUserEmail(registerUserRequest.getUserEmail()) || userRepository.existsByUsername(registerUserRequest.getUsername()))
            return false;
        registerUserRequest.setUserPassword(passwordEncoder.encode(registerUserRequest.getUserPassword()));

        User u = new User(registerUserRequest);
        userRepository.save(u);
        assignUserAuth(new UserAuthRequest(u.getUserId(), Role.ROLE_USER));
        return true;
    }

    @Override
    public UserInfoDto getUser(Long userId) {
        Optional<User> userOp = userRepository.findById(userId);
        if(userOp.isPresent()){
            return new UserInfoDto(userOp.get());
        }
        return null;
    }

    @Override
    public UserInfoDto getUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return new UserInfoDto(user);
        }
        return null;
    }

    @Override
    public boolean updateUser(UpdateUserRequest upreq) {
        User user = userRepository.findByUsername(upreq.getUsername());
        if(user != null){
            if(!upreq.getUserFirstname().equals("")) user.setUserFirstname(upreq.getUserFirstname());
            if (!upreq.getUserLastname().equals("")) user.setUserLastname(upreq.getUserLastname());
            if (!upreq.getUserHomeAddress().equals("")) user.setUserHomeAddress(upreq.getUserHomeAddress());
            if (!upreq.getUserPhone().equals("")) user.setUserPhone(upreq.getUserPhone());
            userRepository.save(user);
            return true;
        }
        return false;
    }

    //TODO: assignUserAuth & revokeUserAuth works, but no need for this complicated stuff improve it pleaseeee
    @Override
    public boolean assignUserAuth(UserAuthRequest userAuthRequest) {
        Optional<User> userOp = userRepository.findById(userAuthRequest.getUserId());
        if(userOp.isPresent()){
            User u = userOp.get();
            boolean userHasAuth = false;
            for (Authority a : u.getAuthority()) {
                if (a.getAuthority().equals(userAuthRequest.getRole().getRole())) {
                    userHasAuth = true;
                    break;
                }
            }
            if (!userHasAuth) {
                u.getAuthority().add(new Authority(userAuthRequest.getRole().getRole(), u));
                userRepository.save(u);
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean revokeUserAuth(UserAuthRequest userAuthRequest) {
        Optional<User> userOp = userRepository.findById(userAuthRequest.getUserId());
        if(userOp.isPresent()){
            User u = userOp.get();
            boolean userHasAuth = false;
            for (Authority a : u.getAuthority()) {
                if (a.getAuthority().equals(userAuthRequest.getRole().getRole())) {
                    userHasAuth = true;
                    a.setUser(null);
                    u.getAuthority().remove(a);
                    break;
                }
            }
            if (userHasAuth) {
                userRepository.save(u);
                return  true;
            }
        }
        return false;
    }
}
