package com.poly.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Dao.OrderDetailDao;
import com.poly.entity.OrderDetail;
import com.poly.service.OrderDetailService;
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailDao dao;
    
    @Override
    public List<OrderDetail> findAllOrderDetail() {
        return dao.findAll();
    }
    
    @Override
    public OrderDetail findOrderDetailById(Integer id) {
        return dao.findById(id).get();
    }
    
    @Override
    public List<OrderDetail> listOrderDetailByOrder(Integer id) {
        return dao.listOrderDetailByOrder(id);
    }
    @Override
    public void save(List<OrderDetail> orderDetails) {
        dao.saveAll(orderDetails);
    }
}
