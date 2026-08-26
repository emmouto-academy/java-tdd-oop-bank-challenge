package com.booleanuk.core;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

// for testing both SavingsAccount and CurrentAccount
public class AccountTest {
    @Test
    public void newAccount_balanceIsZero() {
        Account account = new CurrentAccount();

        Assertions.assertEquals(new BigDecimal(0), account.getBalance());
    }

    @Test
    public void deposit_increasesBalance_500() {
        Account account = new CurrentAccount();

        account.deposit(new BigDecimal(500));

        Assertions.assertEquals(new BigDecimal(500), account.getBalance());
    }

    @Test
    public void deposit_negativeAmount_throwError() {
        Account account = new CurrentAccount();

        Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> account.deposit(new BigDecimal(-500))
        );
    }
    
    @Test
    public void withdraw_decreasesBalance_1000() {
        Account account = new SavingsAccount();

        account.deposit(new BigDecimal(2000));
        account.withdraw(new BigDecimal(1000));

        Assertions.assertEquals(new BigDecimal(1000), account.getBalance());
    }

    @Test
    public void withdraw_balanceIsZero_throwError() {
        Account account = new SavingsAccount();

        Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> account.withdraw(new BigDecimal(-500))
        );
    }
}
