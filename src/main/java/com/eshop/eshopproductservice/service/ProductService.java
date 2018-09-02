package com.eshop.eshopproductservice.service;

import com.eshop.eshopproductservice.model.Product;

/**
 * @author: Xukai
 * @description:
 * @createDate: 2018/8/27 11:17
 * @modified By:
 */
public interface ProductService {

    void add(Product product, String operationType);

    void update(Product product, String operationType);

    void delete(Long id, String operationType);

    Product findById(Long id);
}
