package com.bank.accountservice.service;

import com.bank.accountservice.model.Account;
import com.bank.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account getAccountById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Account not found: " + id));
    }

    public Account createAccount(Account account) {
        return repository.save(account);
    }
}
