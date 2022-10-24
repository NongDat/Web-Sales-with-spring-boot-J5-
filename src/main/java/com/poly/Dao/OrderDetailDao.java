package com.poly.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, Integer>{
    @Query("SELECT a FROM OrderDetail a WHERE a.order.id =?1")
    public List<OrderDetail> listOrderDetailByOrder(Integer id);
}
