package com.poly.service;

import java.util.List;

import com.poly.entity.Category;

public interface CategoryService {

    Category fillCategoryByID(String id);

    List<Category> fillAllCategory();

}
