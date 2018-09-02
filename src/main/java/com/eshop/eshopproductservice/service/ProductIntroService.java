package com.eshop.eshopproductservice.service;

import com.eshop.eshopproductservice.model.ProductIntro;

/**
 * 商品介绍接口
 */
public interface ProductIntroService {

    void add(ProductIntro productIntro, String operationType);

    void update(ProductIntro productIntro, String operationType);

    void delete(Long id, String operationType);

    ProductIntro findById(Long id);

}
