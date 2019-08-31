package com.agriculture.project.service;

import com.agriculture.project.controller.request.*;
import com.agriculture.project.model.dto.UserInfoDto;

public interface UsersService {

    boolean assignFarm(FarmsUsersRequest farmsUsersRequest);
    boolean revokeFarm(FarmsUsersRequest farmsUsersRequest);

    boolean assignProduct(ProductsUsersRequest productsUsersRequest);
    boolean revokeProduct(ProductsUsersRequest productsUsersRequest);

    boolean registerUser(RegisterUserRequest registerUserRequest);

    boolean updateUser(UpdateUserRequest updateUserRequest);
    UserInfoDto getUser(Long userId);

    UserInfoDto getUser(String username);


    boolean assignUserAuth(UserAuthRequest userAuthRequest);
    boolean revokeUserAuth(UserAuthRequest userAuthRequest);
}
