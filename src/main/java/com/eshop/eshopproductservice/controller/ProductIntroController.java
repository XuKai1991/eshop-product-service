package com.eshop.eshopproductservice.controller;

import com.eshop.eshopproductservice.model.ProductIntro;
import com.eshop.eshopproductservice.service.ProductIntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-intro")
public class ProductIntroController {

    @Autowired
    private ProductIntroService productIntroService;

    @GetMapping("/add")
    public String add(ProductIntro productIntro, @RequestParam(required = false) String operationType) {
        try {
            productIntroService.add(productIntro, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(ProductIntro productIntro, @RequestParam(required = false) String operationType) {
        try {
            productIntroService.update(productIntro, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/delete")
    public String delete(Long id, @RequestParam(required = false) String operationType) {
        try {
            productIntroService.delete(id, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/findById")
    public ProductIntro findById(Long id) {
        try {
            return productIntroService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ProductIntro();
    }

}
