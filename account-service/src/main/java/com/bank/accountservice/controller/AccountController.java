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
    // GET http://localhost:8082/api/accounts
    @GetMapping
    public ResponseEntity<List<Account>> getAll() {
        return ResponseEntity.ok(service.getAllAccounts());
    }

    // GET http://localhost:8082/api/accounts/1
    @GetMapping("/{id}")
    public ResponseEntity<Account> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(service.getAccountById(id));
    }

    // POST http://localhost:8082/api/accounts
    @PostMapping
    public ResponseEntity<Account> create(
            @RequestBody Account account) {
        Account saved = service.createAccount(account);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }
}