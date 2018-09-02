package com.eshop.eshopproductservice.service;

import com.eshop.eshopproductservice.model.ProductProperty;

/**
 * 商品属性接口
 */
public interface ProductPropertyService {

    void add(ProductProperty productProperty, String operationType);

    void update(ProductProperty productProperty, String operationType);

    void delete(Long id, String operationType);

    ProductProperty findById(Long id);

    ProductProperty findByProductId(Long productId);

}
