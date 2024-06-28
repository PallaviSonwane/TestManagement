package com.exam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.SubCategory;
import com.exam.repository.SubCategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubCategoryServiceImp implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;


    //add data in subCategory table
    @Override
    public boolean createSubCategory(SubCategory subCategory) {
    
        try{
                subCategoryRepository.save(subCategory);
                log.info("SubCategory data save in database");
                return true;
        }catch(Exception ex){
            log.error("SubCategory data is not added may be data base not created", ex);
            return false;
        }
    }

    //view data in SubCategory table 
    @Override
    public List<SubCategory> getAllSubCotegory() {
        try{
            return subCategoryRepository.findAll();

        }catch(Exception ex){
            log.error("data not present", ex);
            return null;
        }
    }

    //get data subCategory table by id
    @Override
    public Optional<SubCategory> getSubCategory(int subCategoryID) {
        Optional<SubCategory> exist=subCategoryRepository.findById(subCategoryID);
        try{
            if(exist.isPresent()){
                return subCategoryRepository.findById(subCategoryID);
            }else{
                log.error("Not found id in subCategory table");
                return null;
            }
        }catch(Exception ex){
            log.error("Not id fount in database", ex);
            return null;
        }
    }

    //delete data from subCategory by id
    @Override
    public boolean deleteSubCategory(int subCategoryID) {
        boolean exist=subCategoryRepository.existsById(subCategoryID);
        try{
            if(exist){
                subCategoryRepository.deleteById(subCategoryID);
                return true;
            }else{
                log.error("Not found id in subCategory table");
                return false;
            }
        }catch(Exception ex){
            log.error("some problem  in database", ex);
            return false;
        }
    }

    //update data from subCategory table
    @Override
    public boolean updateSubCategory(int subCategoryID ,SubCategory subCategory) {
         Optional<SubCategory> exist = subCategoryRepository.findById(subCategoryID);
    
    if (exist.isPresent()) {
        try {
          subCategoryRepository.save(subCategory);
            return true;
        } catch (Exception ex) {
            return false;
        }
    } else {
        log.info("Id not present in subCategory");
        return false;
    }
    }

}
