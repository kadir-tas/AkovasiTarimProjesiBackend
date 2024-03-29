package com.agriculture.project.model.dto;

import com.agriculture.project.model.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class ProductDto implements Serializable {

    private long productId;
    private String productName;

    public ProductDto(Product product){
        this.productId = product.getProductId();
        this.productName = product.getProductName();
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
}
