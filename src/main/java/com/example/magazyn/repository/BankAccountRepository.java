package com.example.magazyn.repository;

import com.example.magazyn.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
    BankAccount findById(int id);
}