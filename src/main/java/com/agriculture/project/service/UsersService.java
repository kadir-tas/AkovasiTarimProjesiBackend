package com.agriculture.project.service;

import com.agriculture.project.controller.request.*;
import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Product;
import com.agriculture.project.model.dto.UserInfoDto;
import com.agriculture.project.model.value.*;
import com.agriculture.project.model.dto.UserDto;

import java.util.List;

public interface UsersService {

    boolean assignFarm(FarmsUsersRequest farmsUsersRequest);
    boolean revokeFarm(FarmsUsersRequest farmsUsersRequest);

    boolean assignProduct(ProductsUsersRequest productsUsersRequest);
    boolean revokeProduct(ProductsUsersRequest productsUsersRequest);

    boolean registerUser(RegisterUserRequest registerUserRequest);
    boolean updateUser(UpdateUserRequest userDto);
    UserInfoDto getUser(Long userId);


    boolean assignUserAuth(UserAuthRequest userAuthRequest);
    boolean revokeUserAuth(UserAuthRequest userAuthRequest);
}
