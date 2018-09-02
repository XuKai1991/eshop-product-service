package com.eshop.eshopproductservice.controller;

import com.eshop.eshopproductservice.model.Category;
import com.eshop.eshopproductservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/add")
    public String add(Category category, @RequestParam(required = false) String operationType) {
        try {
            categoryService.add(category, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/update")
    public String update(Category category, @RequestParam(required = false) String operationType) {
        try {
            categoryService.update(category, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/delete")
    public String delete(Long id, @RequestParam(required = false) String operationType) {
        try {
            categoryService.delete(id, operationType);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @GetMapping("/findById")
    public Category findById(Long id) {
        try {
            return categoryService.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Category();
    }

}
