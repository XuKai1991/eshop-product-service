package com.eshop.eshopproductservice.model;

import lombok.Data;

/**
 * 品牌实体类
 */
@Data
public class Brand {

    private Long id;

    private String name;

    private String description;

    public Brand() {
        super();
    }

    public Brand(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
