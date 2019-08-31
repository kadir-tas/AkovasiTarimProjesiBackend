package com.agriculture.project.model.dto;

import com.agriculture.project.model.Product;

import java.io.Serializable;
import java.util.Set;

public class ProductInfoDto implements Serializable {
    private long productId;
    private String productName;
    private Set<UserDto> users;

    public ProductInfoDto(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.users = product.getUsersDto();
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<UserDto> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDto> users) {
        this.users = users;
    }
}
