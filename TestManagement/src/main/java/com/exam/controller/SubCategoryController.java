package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import com.exam.model.SubCategory;
import com.exam.service.SubCategoryService;

@RestController
@RequestMapping("/subCategory")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    //add data in subCategory table
    @PostMapping("/addSubcategory")
    public void createSubCategory(@RequestBody SubCategory subCategory){
        Boolean b=subCategoryService.createSubCategory(subCategory);
        System.out.println(b?"subcategory data save...":"subcategory data not save");
    }

    //view data from subCategory table
    @GetMapping("/getAllSubCategory")
    public List<SubCategory> getAllSubCotegory(){
        return subCategoryService.getAllSubCotegory();
    }

    //view data from  subCategory table by id
    @GetMapping("/getSubCategory/{subCategoryID}")
    public Optional<SubCategory> getSubCategory(@PathVariable("subCategoryID") int subCategoryID){
        return subCategoryService.getSubCategory(subCategoryID);
    }

    //delete data from subCategory by id
    @DeleteMapping("/deleteSubCategory/{subCategoryID}")
    public String deleteCategoryByID(@PathVariable("subCategoryID") int subCategoryID){
        boolean b=subCategoryService.deleteSubCategory(subCategoryID);
        return b?"data delete from subCategory":"data not delete from subCategory";
    }

    @PutMapping("/updateSubCategory/{subCategoryID}")
    public String updateSubCategory(@PathVariable int subCategoryID,@RequestBody SubCategory subCategory){
        boolean b=subCategoryService.updateSubCategory(subCategoryID, subCategory);
        return b?"data updated sussessfully":"data not updated";
    }


    
}
