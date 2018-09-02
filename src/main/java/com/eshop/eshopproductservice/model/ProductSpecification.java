package com.eshop.eshopproductservice.model;

import lombok.Data;

/**
 * 商品规格实体类
 */
@Data
public class ProductSpecification {

    private Long id;

    private String name;

    private String value;

    private Long productId;

}
