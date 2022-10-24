package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.Dao.AccountDao;
import com.poly.entity.Account;
import com.poly.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDao dao;
	
	@Override
	public List<Account> fillAll() {
		return dao.findAll();
	}
	
	@Override
	public Account fillById(String username) {
		return dao.findById(username).get();
	}
	
	
    @Override
    public void save(Account account) {
        dao.save(account);
    }
	
	@Override
    public void update(Account account) {
	    dao.save(account);
	}
	
	@Override
    public void delete(Account account) {
//	    account.setRole(false);
        dao.delete(account);
    }
}
