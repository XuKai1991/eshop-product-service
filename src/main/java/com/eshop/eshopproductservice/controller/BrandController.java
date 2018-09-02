package com.eshop.eshopproductservice.controller;

import com.eshop.eshopproductservice.model.Brand;
import com.eshop.eshopproductservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/add")
    public String add(Brand brand, @RequestParam(required = false) String operationType) {
        try {
            brandService.add(brand, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(Brand brand, @RequestParam(required = false) String operationType) {
        try {
            brandService.update(brand, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/delete")
    public String delete(Long id, @RequestParam(required = false) String operationType) {
        try {
            brandService.delete(id, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/findById")
    public Brand findById(Long id) {
        try {
            return brandService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Brand();
    }

    @GetMapping("/findByIds")
    public List<Brand> findByIds(String ids) {
        try {
            return brandService.findByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
