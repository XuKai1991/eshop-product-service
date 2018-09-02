package com.eshop.eshopproductservice.controller;

import com.eshop.eshopproductservice.model.ProductSpecification;
import com.eshop.eshopproductservice.service.ProductSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-specification")
public class ProductSpecificationController {

    @Autowired
    private ProductSpecificationService productSpecificationService;

    @GetMapping("/add")
    public String add(ProductSpecification productSpecification, @RequestParam(required = false) String operationType) {
        try {
            productSpecificationService.add(productSpecification, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(ProductSpecification productSpecification, @RequestParam(required = false) String operationType) {
        try {
            productSpecificationService.update(productSpecification, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/delete")
    public String delete(Long id, @RequestParam(required = false) String operationType) {
        try {
            productSpecificationService.delete(id, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/findById")
    public ProductSpecification findById(Long id) {
        try {
            return productSpecificationService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductSpecification();
    }

    @GetMapping("/findByProductId")
    public ProductSpecification findByProductId(Long productId) {
        try {
            return productSpecificationService.findByProductId(productId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductSpecification();
    }

}
