package com.eshop.eshopproductservice.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eshop.eshopproductservice.model.Brand;
import com.eshop.eshopproductservice.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: Xukai
 * @description:
 * @createDate: 2018/8/27 11:29
 * @modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BrandServiceImplTest {

    @Autowired
    private BrandService brandService;

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
        Brand brand = brandService.findById(1L);
        log.info(brand.toString());
    }

    @Test
    public void findByIds() {
        List<Brand> brandList = brandService.findByIds("7,8,11");
        JSONArray jsonArray = JSONArray.parseArray(JSONObject.toJSONString(brandList));
        log.info(jsonArray.toJSONString());
    }
}