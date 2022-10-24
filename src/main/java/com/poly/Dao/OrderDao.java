package com.poly.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer>{
    @Query("SELECT a FROM Order a WHERE a.account.username =?1")
    public List<Order> listOrderByUsername(String username);
}
