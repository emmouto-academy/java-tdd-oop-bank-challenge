package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Account
 */
public abstract class Account {
    List<Transaction> transactions;
    Branch branch;

    public Account() {
        transactions = new ArrayList<>();
    }

    public void deposit(BigDecimal amount, LocalDate date) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Deposit amount must be positive.");

        transactions.add(new Transaction(date, amount, TransactionType.CREDIT));
    }

    public void deposit(BigDecimal amount) {
        deposit(amount, LocalDate.now());
    }

    public void withdraw(BigDecimal amount, LocalDate date) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Deposit amount must be positive.");

        if (amount.compareTo(getBalance()) > 0)
            throw new IllegalArgumentException("Insufficient funds");

        transactions.add(new Transaction(date, amount, TransactionType.DEBIT));
    }

    public void withdraw(BigDecimal amount) {
        withdraw(amount, LocalDate.now());
    }

    public BigDecimal getBalance() {
        BigDecimal balance = new BigDecimal(0);

        for (Transaction t : transactions) {
            balance = t.type().equals(TransactionType.CREDIT)
                ? balance.add(t.amount())
                : balance.subtract(t.amount());
        }

        return balance;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public Branch getBranch() {
        return branch;
    }
    
    void setBranch(Branch branch) {
        this.branch = branch;
    }
}
