package com.bank.accountservice.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String accountNumber;
    @Column(nullable = false)
    private String holderName;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private String accountType;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String n) { this.accountNumber = n; }
    public String getHolderName() { return holderName; }
    public void setHolderName(String n) { this.holderName = n; }
    public BigDecimal getBalance() { return balance; }
    public void setBalance(BigDecimal b) { this.balance = b; }
    public String getAccountType() { return accountType; }
    public void setAccountType(String t) { this.accountType = t; }
}