package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Dao.CategoryDao;
import com.poly.entity.Category;
import com.poly.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired 
    CategoryDao categoryDao;
    
    @Override
    public List<Category> fillAllCategory() {
        return categoryDao.findAll();
    }
    
    @Override
    public Category fillCategoryByID(String id) {
        return categoryDao.getById(id);
    }
}
