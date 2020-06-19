package com.example.magazyn.service;

import com.example.magazyn.model.Account;
import com.example.magazyn.model.BankAccount;
import com.example.magazyn.repository.AccountRepository;
import com.example.magazyn.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BankAccountService {

    private  final BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BankAccount getById(int id) {
        return bankAccountRepository.findById(id);
    }

    public void addMoney(BankAccount bankAccount, int sum){

          int oldMoney = bankAccount.getMoney();
          bankAccount.setMoney(oldMoney + sum);

    }
}
