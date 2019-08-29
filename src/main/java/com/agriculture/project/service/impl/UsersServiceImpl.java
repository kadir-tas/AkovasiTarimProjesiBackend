package com.agriculture.project.service.impl;

import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Product;
import com.agriculture.project.model.User;
import com.agriculture.project.repository.FarmRepository;
import com.agriculture.project.repository.ProductRepository;
import com.agriculture.project.repository.UserRepository;
import com.agriculture.project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public boolean assignFarm(Long userId, Long farmId) {
        Optional<User> userOp = userRepository.findById(userId);
        Optional<Farm> farmOp = farmRepository.findById(farmId);
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
    public boolean unassignFarm(Long userId, Long farmId) {
        Optional<User> userOp = userRepository.findById(userId);
        Optional<Farm> farmOp = farmRepository.findById(farmId);

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
    public List<Farm> getUsersFarm(Long userId) {
        return farmRepository.findByUsersUserId(userId);
    }

    @Override
    public boolean assignProduct(Long userId, Long productId) {
        Optional<User> userOp = userRepository.findById(userId);
        Optional<Product> productOp = productRepository.findById(productId);
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
    public boolean unassignProduct(Long userId, Long productId) {
        Optional<User> userOp = userRepository.findById(userId);
        Optional<Product> productOp = productRepository.findById(productId);
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
    public List<Product> getUsersProducts(Long userId) {
        return productRepository.findByUsersUserId(userId);
    }
}
