package com.poly.service;

import java.util.Collection;

import com.poly.modelDTO.CartItem;

public interface CartService {

    int getCount();

    double getAmount();

    void update(Integer productId, Integer quantity);

    void clear();

    Collection<CartItem> getCartItems();

    void remove(Integer productId);

    void add(CartItem item);

    int getCountQuantity();

}
