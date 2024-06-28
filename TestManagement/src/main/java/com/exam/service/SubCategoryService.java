package com.exam.service;

import com.exam.model.SubCategory;
import java.util.Optional;
import java.util.List;

public interface SubCategoryService {
    
    //store info in sub category table
    public boolean createSubCategory(SubCategory subCategory);

    //view all subCategory
    public List<SubCategory> getAllSubCotegory();

    //view subCategory by id
    public Optional<SubCategory> getSubCategory(int subCategoryID);

    //delete subCategory by id 
    public boolean deleteSubCategory(int subCategoryID);

    //updaete subCategory by id
    public boolean updateSubCategory(int subCategoryID ,SubCategory subCategory);
    
}
