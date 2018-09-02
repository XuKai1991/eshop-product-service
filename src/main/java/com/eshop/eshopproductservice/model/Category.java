package com.eshop.eshopproductservice.model;

import lombok.Data;

/**
 * 类别实体类
 */
@Data
public class Category {

    private Long id;

    private String name;

    private String description;

    public Category() {
        super();
    }

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
