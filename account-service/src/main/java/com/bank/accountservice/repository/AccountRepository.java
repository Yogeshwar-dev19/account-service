package com.bank.accountservice.repository;

import com.bank.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository
        extends JpaRepository<Account, Long> {

    // Spring gives us these methods for FREE — no code needed:
    // save(account)    → saves to database
    // findAll()        → gets all accounts
    // findById(id)     → gets one account by id
    // deleteById(id)   → deletes an account
}