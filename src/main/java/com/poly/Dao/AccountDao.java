package com.poly.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.entity.Account;

public interface AccountDao extends JpaRepository<Account, String>{
    @Query("SELECT entity FROM Account entity WHERE email=:email")
    public Account findByEmail(@Param("email") String email);
}
