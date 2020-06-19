package com.example.magazyn.service;

import com.example.magazyn.model.Account;
import com.example.magazyn.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountService {

    private  final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getById(int id) {
        return accountRepository.findById(id);
    }

    public Account addAccount() {

        Account account = new Account();

        return accountRepository.save(account);
    }
}
