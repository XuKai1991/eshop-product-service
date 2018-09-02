package com.eshop.eshopproductservice.service.impl;

import com.eshop.eshopproductservice.model.Category;
import com.eshop.eshopproductservice.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Xukai
 * @description:
 * @createDate: 2018/8/27 11:38
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void add() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findById() {
        Category category = categoryService.findById(1L);
        log.info(category.toString());
    }
}