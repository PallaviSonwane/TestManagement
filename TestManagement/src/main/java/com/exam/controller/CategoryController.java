package com.exam.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import com.exam.model.Category;
import com.exam.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //add category data in databse
    @PostMapping("/addCategory")
    public String createCategory(@RequestBody Category category){
        boolean b=categoryService.createCategory(category);
       return b?"category data save in database":"category data not save in database";
    }

    //view all category data
    @GetMapping("/viewAllCategoryInfo")
    public List<Category> getAllCategoryInfo(){
        return categoryService.getAllCategoryInfo();
    }

    //view single category info
    @GetMapping("/viewSingleCategory/{categoryId}")
    public Optional<Category> getCategoryInfo(@PathVariable("categoryId") int c_id){
        return categoryService.getCategoryInfo(c_id);
    }

    //delete category data from database
    @DeleteMapping("/deleteCategoryById/{categoryId}")
    public String deleteCategoryById(@PathVariable("categoryId") int c_id){
        boolean b=categoryService.deleteCategoryByID(c_id);
        return b?"Category data deleted from database":"Catogory data not deletd from database";
    }

    //Update category data from database
    @PutMapping("/updateCategoryById/{categoryId}")
    public String updateCategoryById(@PathVariable("categoryId") int c_id ,@RequestBody Category category){
        
        boolean b=categoryService.updateCategoryById(c_id, category);
        return b?"Category data update from database":"Category data Not update from database";
    }
}
