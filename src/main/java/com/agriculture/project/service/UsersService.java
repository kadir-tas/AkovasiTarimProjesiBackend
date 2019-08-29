package com.agriculture.project.service;

import com.agriculture.project.model.Farm;
import com.agriculture.project.model.Product;
import com.agriculture.project.model.User;

import java.util.List;

public interface UsersService {

    boolean assignFarm(Long userId, Long farmId);
    boolean unassignFarm(Long userId, Long farmId);
    List<Farm> getUsersFarm(Long userId);

    boolean assignProduct(Long userId, Long productId);
    boolean unassignProduct(Long userId, Long productId);
    List<Product> getUsersProducts(Long userId);
}
