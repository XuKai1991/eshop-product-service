package com.eshop.eshopproductservice.controller;

import com.eshop.eshopproductservice.model.ProductProperty;
import com.eshop.eshopproductservice.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-property")
public class ProductPropertyController {

    @Autowired
    private ProductPropertyService productPropertyService;

    @GetMapping("/add")
    public String add(ProductProperty productProperty, @RequestParam(required = false) String operationType) {
        try {
            productPropertyService.add(productProperty, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(ProductProperty productProperty, @RequestParam(required = false) String operationType) {
        try {
            productPropertyService.update(productProperty, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/delete")
    public String delete(Long id, @RequestParam(required = false) String operationType) {
        try {
            productPropertyService.delete(id, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/findById")
    public ProductProperty findById(Long id) {
        try {
            return productPropertyService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductProperty();
    }

    @GetMapping("/findByProductId")
    public ProductProperty findByProductId(Long productId) {
        try {
            return productPropertyService.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductProperty();
    }

}
