package com.poly.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class CartItem {
	private Integer id;
	private String name;
    private String image;
	private Integer quantity;
	private Double price;
	private Boolean available;
	private String categoryId;
}
