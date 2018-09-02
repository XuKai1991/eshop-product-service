package com.eshop.eshopproductservice.service;

import com.eshop.eshopproductservice.model.Category;

/**
 * @author: Xukai
 * @description: 类别接口
 * @createDate: 2018/8/27 11:12
 * @modified By:
 */
public interface CategoryService {

    void add(Category category, String operationType);

    void update(Category category, String operationType);

    void delete(Long id, String operationType);

    Category findById(Long id);
}
