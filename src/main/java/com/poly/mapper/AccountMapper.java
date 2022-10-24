package com.poly.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.entity.Account;
import com.poly.modelDTO.AccountDTO;

@Service
public class AccountMapper {
    @Autowired
    private ModelMapper mapper;
    public Account  convertToEntity(AccountDTO accountDTO) {
        Account account = mapper.map(accountDTO, Account.class);
        return account;
    }
    
    public AccountDTO  convertToDTO(Account account) {
        AccountDTO accountDTO = mapper.map(account, AccountDTO.class);
        return accountDTO;
    }
}
