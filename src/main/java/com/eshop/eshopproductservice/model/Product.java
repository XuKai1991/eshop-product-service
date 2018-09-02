package com.eshop.eshopproductservice.model;

import lombok.Data;

/**
 * 商品实体类
 */
@Data
public class Product {

    private Long id;

    private String name;

    private Long categoryId;

    private Long brandId;

    public Product() {
        super();
    }

    public Product(Long id, String name, Long categoryId, Long brandId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
}
