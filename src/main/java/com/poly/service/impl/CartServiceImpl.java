package com.poly.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.poly.modelDTO.CartItem;
import com.poly.service.CartService;
@Service
@SessionScope
public class CartServiceImpl implements CartService{
    private Map<Integer, CartItem> map = new HashMap<Integer,CartItem>();
    
    @Override
    public void add(CartItem item) {
        CartItem exisItem = map.get(item.getId());
        if(exisItem != null) {
            exisItem.setQuantity(item.getQuantity() + exisItem.getQuantity());
        } else {
            map.put(item.getId(), item);
        }
    }
    
    @Override
    public void remove(Integer productId) {
        map.remove(productId);
    }
    
    @Override
    public Collection<CartItem> getCartItems() {
        return map.values();
    }
    
    @Override
    public void clear() {
        map.clear();
    }
    
    @Override
    public void update(Integer productId, Integer quantity) {
        CartItem item = map.get(productId);
        item.setQuantity(quantity);
        if(item.getQuantity() < 0) {
            map.remove(productId);
        }
    }
    
    @Override
    public double getAmount() {
        return map.values().stream().mapToDouble(item->item.getQuantity() * item.getPrice()).sum();
    }
    
    
    @Override
    public int getCount() {
        if(map.isEmpty()) {
            return 0;
        }
        return map.values().size();
    }
    
    @Override
    public int getCountQuantity() {
        if(map.isEmpty()) {
            return 0;
        }
        return map.values().stream().mapToInt(item->item.getQuantity()).sum();
    }
}
