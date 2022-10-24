package com.poly.service;

import java.util.List;

import com.poly.entity.Product;

public interface ProductService {

    void delete(Product product);

    void saveProduct(Product product);

    List<Product> findByCategoryId(String categoryId);

    Product findProductById(Integer productId);

    List<Product> findAllProduct();
}
