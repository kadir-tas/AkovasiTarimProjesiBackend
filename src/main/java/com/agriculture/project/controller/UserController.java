package com.agriculture.project.controller;

import com.agriculture.project.controller.request.*;
import com.agriculture.project.model.Message;
import com.agriculture.project.model.dto.UserInfoDto;
import com.agriculture.project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UsersService usersService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/get")
    ResponseEntity<?>
    getUser(@RequestParam Long userId){
        UserInfoDto userInfoDto = usersService.getUser(userId);
        if(userInfoDto != null){
            return new ResponseEntity<>(userInfoDto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message(userId + " not found"), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/register")
    ResponseEntity<?>
    registerUser(@RequestBody RegisterUserRequest registerUserRequest){
        if(usersService.registerUser(registerUserRequest)){
            return new ResponseEntity<>(new Message("User " + registerUserRequest.getUsername() + " is registered successfully"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new Message("Failed to register user " + registerUserRequest.getUsername()), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/update")
    ResponseEntity<?>
    updateUser(@RequestBody UpdateUserRequest updateUserRequest){
        if(usersService.updateUser(updateUserRequest)){
            return new ResponseEntity<>(new Message("User " + updateUserRequest.getUsername() + " is updated successfully"), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(new Message("Failed to update user " + updateUserRequest.getUsername()), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/assign/farm")
    ResponseEntity<?>
    assignUserFarm(@RequestBody FarmsUsersRequest farmsUsersRequest){
        if(usersService.assignFarm(farmsUsersRequest)){
            return new ResponseEntity<>(new Message("Farm " + farmsUsersRequest.getFarmId() + " is assigned to the user " + farmsUsersRequest.getUserId()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Failed to assing farm " + farmsUsersRequest.getFarmId() + " to the user " + farmsUsersRequest.getUserId()), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/revoke/farm")
    ResponseEntity<?>
    revokeUserFarm(@RequestBody FarmsUsersRequest farmsUsersRequest){
        if(usersService.revokeFarm(farmsUsersRequest)){
            return new ResponseEntity<>(new Message("Farm " + farmsUsersRequest.getFarmId() + " is revoked from user " + farmsUsersRequest.getUserId()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Failed to revoke farm " + farmsUsersRequest.getFarmId() + " from user " + farmsUsersRequest.getUserId()), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/assign/product")
    ResponseEntity<?>
    assignUserProduct(@RequestBody ProductsUsersRequest productsUsersRequest){
        if(usersService.assignProduct(productsUsersRequest)){
            return new ResponseEntity<>(new Message("Product " + productsUsersRequest.getProductId() + " is assigned to the user " + productsUsersRequest.getUserId()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Failed to assign product " + productsUsersRequest.getProductId() + " to the user " + productsUsersRequest.getUserId()), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/revoke/product")
    ResponseEntity<?>
    revokeUserProduct(@RequestBody ProductsUsersRequest productsUsersRequest){
        if(usersService.revokeProduct(productsUsersRequest)){
            return new ResponseEntity<>(new Message("Product " + productsUsersRequest.getProductId() + " is revoked from user " + productsUsersRequest.getUserId()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Failed to revoke product " + productsUsersRequest.getProductId() + " from user " + productsUsersRequest.getUserId()), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/assign/auth")
    ResponseEntity<?>
    assignAuth(@RequestBody UserAuthRequest userAuthRequest){
        if(usersService.assignUserAuth(userAuthRequest)){
            return new ResponseEntity<>(new Message("Role " + userAuthRequest.getRole() + " is assigned to the user " + userAuthRequest.getUserId()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Failed to assign role " + userAuthRequest.getRole() + " to the user " + userAuthRequest.getUserId()), HttpStatus.BAD_REQUEST);
        }
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/revoke/auth")
    ResponseEntity<?>
    revokeAuth(@RequestBody UserAuthRequest userAuthRequest){
        if(usersService.revokeUserAuth(userAuthRequest)){
            return new ResponseEntity<>(new Message("Role " + userAuthRequest.getRole() + " is revoked from user " + userAuthRequest.getUserId()), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new Message("Failed to revoke role " + userAuthRequest.getRole() + " from user " + userAuthRequest.getUserId()), HttpStatus.BAD_REQUEST);
        }
    }

}
