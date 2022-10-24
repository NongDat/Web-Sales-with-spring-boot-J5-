package com.poly.service;

import java.util.List;

import com.poly.entity.Account;

public interface AccountService {

	Account fillById(String username);

	List<Account> fillAll();

    void update(Account account);

    void save(Account account);

    void delete(Account account);

}
