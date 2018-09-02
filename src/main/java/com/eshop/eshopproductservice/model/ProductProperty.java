package com.eshop.eshopproductservice.model;

import lombok.Data;

/**
 * 商品属性实体类
 */
@Data
public class ProductProperty {

    private Long id;

    private String name;

    private String value;

    private Long productId;

}
