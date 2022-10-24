package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Dao.ProductDao;
import com.poly.entity.Product;
import com.poly.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDao pDao;
	
	@Override
	public List<Product> findAllProduct() {
		return pDao.findAll();
	}
	@Override
	public Product findProductById(Integer productId) {
		return pDao.findById(productId).get();
	}
	
	@Override
    public List<Product> findByCategoryId(String categoryId) {
	    return pDao.findByCategoryId(categoryId);
	}
	
	@Override
    public void saveProduct(Product product) {
         pDao.save(product);
    }
	
	@Override
    public void delete(Product product) {
	    product.setAvailable(false);
        pDao.save(product);
    }
}
