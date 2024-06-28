package com.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.Category;
import com.exam.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    //store category info indatabse
    @Override
    public boolean createCategory(Category category) {
       try{
            categoryRepository.save(category);  //save() method returns the saved entity(data) otherwise throw exception
            log.info("Data save in database................");
            return true;
       }catch(Exception ex){
            log.error("some problem is there may be database not connected... ", ex);
            return false;
       }
    }

    //view category data in databse
@Override
public List<Category> getAllCategoryInfo() {
     try{
          return categoryRepository.findAll();
     }catch(Exception ex){
          log.error("category table is empty", ex);
          return null;
     }
}

//view single category data in databse
@Override
public Optional<Category> getCategoryInfo(int categoryId) {
     boolean exist=categoryRepository.existsById(categoryId);
     try{
          if(exist){
               return categoryRepository.findById(categoryId);
          }else{
               log.error("not found data in databse");
               return null;
          }
          
     }catch(Exception ex){
          log.error("not found data in databse", ex);
          return null;
     }
}

//delete catogory by id
@Override
public boolean deleteCategoryByID(int categoryId) {
     boolean exist=categoryRepository.existsById(categoryId);
     try{
          if(exist){
               categoryRepository.deleteById(categoryId);
               log.info("category data deleted from database");
               return true;
          }else{
               log.error("category id is not present");
               return false;
          }
          
     }catch(Exception ex){
          log.error("category id already deleted", ex);
          return false;
     }
}

@Override
public boolean updateCategoryById(int categoryId , Category category) {
     boolean exist=categoryRepository.existsById(categoryId);
     try{
          if(exist){
               categoryRepository.save(category);
               return true;
          }else{
               log.error("Id not found in databse");
               return false;
          }

     }catch(Exception ex){
          log.error("Id not found in database", ex);
          return false;
     }
}



}
