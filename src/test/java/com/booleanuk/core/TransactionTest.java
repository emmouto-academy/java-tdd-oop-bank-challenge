package com.booleanuk.core;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;

public class TransactionTest {
    @Test
    public void transaction_recordsData() {
        LocalDate date = LocalDate.of(2012, 01, 10);

        Transaction transaction = new Transaction(
            date, 
            new BigDecimal(1000), 
            new BigDecimal(1000)
        );

        Assertions.assertEquals(date, transaction.date());
        Assertions.assertEquals(new BigDecimal(1000), transaction.amount());
        Assertions.assertEquals(new BigDecimal(1000), transaction.balance());
    }

    @Test
    public void deposit_createsTransaction() {
        Account account = new CurrentAccount();
        LocalDate date = LocalDate.of(2012, 01, 10);

        account.deposit(new BigDecimal(1000), date);
        
        Assertions.assertEquals(1, account.getTransactions.size());
    }

    @Test
    public void withdraw_createsTransaction() {
        Account account = new CurrentAccount();
        LocalDate date = LocalDate.of(2012, 01, 10);

        account.deposit(new BigDecimal(1000), date);
        account.withdraw(new BigDecimal(500), date);
        
        Assertions.assertEquals(2, account.getTransactions.size());
    }
}
