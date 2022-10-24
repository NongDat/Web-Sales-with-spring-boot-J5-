package com.poly.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Category;

public interface CategoryDao extends JpaRepository<Category, String>{

}
