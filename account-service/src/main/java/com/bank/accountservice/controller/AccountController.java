package com.bank.accountservice.controller;

import com.bank.accountservice.model.Account;
import com.bank.accountservice.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(service.getAllAccounts());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getAccountById(id));
    }

    
    @PostMapping
    public ResponseEntity<Account> create(
            @RequestBody Account account) {
        Account saved = service.createAccount(account);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }
}
