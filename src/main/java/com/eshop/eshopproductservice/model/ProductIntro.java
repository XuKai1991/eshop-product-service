package com.eshop.eshopproductservice.model;

import lombok.Data;

/**
 * 商品介绍实体类
 */
@Data
public class ProductIntro {

    private Long id;

    private String content;

    private Long productId;

}
