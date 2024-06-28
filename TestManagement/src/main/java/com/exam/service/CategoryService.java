package com.exam.service;

import com.exam.model.Category;
import java.util.Optional;


import java.util.List;

public interface CategoryService {
    //category data save in database
    public boolean createCategory(Category category);

    //All category data view
    public List<Category> getAllCategoryInfo();

    //view category by id
    public Optional<Category> getCategoryInfo(int categoryId);

    //delete category by id
    public boolean deleteCategoryByID(int categoryId);

    //update catagory data from database
    public boolean updateCategoryById(int categoryId ,Category category);
}
