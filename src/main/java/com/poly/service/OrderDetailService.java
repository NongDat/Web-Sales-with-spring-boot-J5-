package com.poly.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.entity.OrderDetail;

@Service
public interface OrderDetailService {

    OrderDetail findOrderDetailById(Integer id);

    List<OrderDetail> findAllOrderDetail();

    void save(List<OrderDetail> orderDetails);

    List<OrderDetail> listOrderDetailByOrder(Integer id);

}
