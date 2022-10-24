package com.poly.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Product;
import com.poly.modelDTO.ProductDTO;

@Service
public class ProductMapper {
    @Autowired
    private ModelMapper mapper;
    
    public Product convertToEntity(ProductDTO productDTO) {
        Product product = mapper.map(productDTO, Product.class);
        return product;
    }
    
    public ProductDTO convertToDTO(Product product) {
          ProductDTO productDTO = mapper.map(product, ProductDTO.class);
        return productDTO;
    }
    
    
}
