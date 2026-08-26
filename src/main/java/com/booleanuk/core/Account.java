package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Account
 */
public abstract class Account {
    BigDecimal balance;
    List<Transaction> transactions;

    public Account() {
        this.balance = new BigDecimal(0);
        transactions = new ArrayList<>();
    }

    public void deposit(BigDecimal amount, LocalDate date) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Deposit amount must be positive.");

        transactions.add(new Transaction(date, amount, balance.add(amount), TransactionType.CREDIT));
        balance = balance.add(amount);
    }

    public void deposit(BigDecimal amount) {
        deposit(amount, LocalDate.now());
    }

    public void withdraw(BigDecimal amount, LocalDate date) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Deposit amount must be positive.");

        if (amount.compareTo(balance) > 0)
            throw new IllegalArgumentException("Insufficient funds");

        transactions.add(new Transaction(date, amount, balance.subtract(amount), TransactionType.DEBIT));
        balance = balance.subtract(amount);
    }

    public void withdraw(BigDecimal amount) {
        withdraw(amount, LocalDate.now());
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

}
