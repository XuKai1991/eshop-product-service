package com.eshop.eshopproductservice.controller;

import com.eshop.eshopproductservice.model.Product;
import com.eshop.eshopproductservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String add(Product product, @RequestParam(required = false) String operationType) {
        try {
            productService.add(product, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(Product product, @RequestParam(required = false) String operationType) {
        try {
            productService.update(product, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/delete")
    public String delete(Long id, @RequestParam(required = false) String operationType) {
        try {
            productService.delete(id, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/findById")
    public Product findById(Long id) {
        try {
            return productService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Product();
    }

}
