package com.eshop.eshopproductservice.service;

import com.eshop.eshopproductservice.model.Brand;

import java.util.List;

/**
 * @author: Xukai
 * @description: 品牌接口
 * @createDate: 2018/8/27 11:00
 * @modified By:
 */
public interface BrandService {

    void add(Brand brand, String operationType);

    void update(Brand brand, String operationType);

    void delete(Long id, String operationType);

    Brand findById(Long id);

    List<Brand> findByIds(String ids);
}
