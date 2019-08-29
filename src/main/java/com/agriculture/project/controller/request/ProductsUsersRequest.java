package com.agriculture.project.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsUsersRequest {
    private Long userId;
    private Long productId;
}
