package com.poly.service;

import java.util.List;

import com.poly.entity.Order;

public interface OrderService {

    Order findOrderByID(Integer id);

    List<Order> findAll();

    void save(Order order);

    List<Order> listOrderByUsername(String username);

    void payOrder(Order order);

    void confirmOrder(Order order);

    void deleteOrder(Order order);

}
