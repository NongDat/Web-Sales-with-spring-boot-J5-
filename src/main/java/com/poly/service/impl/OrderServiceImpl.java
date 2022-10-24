package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Dao.OrderDao;
import com.poly.entity.Order;
import com.poly.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao dao;
    
    @Override
    public List<Order> findAll() {
        return dao.findAll();
    }
    
    @Override
    public Order findOrderByID(Integer id) {
        return dao.findById(id).get();
    }
    
    @Override
    public List<Order> listOrderByUsername(String username) {
        return dao.listOrderByUsername(username);
    }
    
    @Override
    public void save(Order order) {
        dao.save(order);
    }
    
    @Override
    public void deleteOrder(Order order) {
        order.setIsPay(false);
        order.setIsComfirm(false);
        dao.save(order);
    }
    
    @Override
    public void confirmOrder(Order order) {
        order.setIsComfirm(true);
        dao.save(order);
    }
    
    @Override
    public void payOrder(Order order) {
        order.setIsPay(true);
        dao.save(order);
    }
}
