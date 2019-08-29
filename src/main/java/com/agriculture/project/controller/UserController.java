package com.agriculture.project.controller;

import com.agriculture.project.controller.request.FarmsUsersRequest;
import com.agriculture.project.controller.request.ProductsUsersRequest;
import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Product;
import com.agriculture.project.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UsersService usersService;

    @Secured("ROLE_ADMIN")
    @PostMapping("/setUserFarm")
    @ResponseBody HttpStatus
    setUserFarm(@RequestBody FarmsUsersRequest farmsUsersRequest){
        return usersService.assignFarm(farmsUsersRequest.getUserId(), farmsUsersRequest.getFarmId()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/unsetUserFarm")
    @ResponseBody HttpStatus
    removeUserFarm(@RequestBody FarmsUsersRequest farmsUsersRequest){
        return usersService.unassignFarm(farmsUsersRequest.getUserId(), farmsUsersRequest.getFarmId()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/getUserFarm")
    @ResponseBody List<Farm>
    getUserFarm(@RequestParam Long userId){
        return usersService.getUsersFarm(userId);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/setUserProduct")
    @ResponseBody HttpStatus
    setUserProduct(@RequestBody ProductsUsersRequest productsUsersRequest){
        return usersService.assignProduct(productsUsersRequest.getUserId(), productsUsersRequest.getProductId()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/unsetUserProduct")
    @ResponseBody HttpStatus
    unsetUserProduct(@RequestBody ProductsUsersRequest productsUsersRequest){
        return usersService.unassignProduct(productsUsersRequest.getUserId(), productsUsersRequest.getProductId()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/getUserProduct")
    @ResponseBody List<Product>
    getUserProduct(@RequestParam Long userId){
        return usersService.getUsersProducts(userId);
    }
}
