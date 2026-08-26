package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BankStatementTest {
    @Test
    public void generateBankStatement_fulfillsAcceptanceCriteria() {
        Account account = new SavingsAccount();
        BankStatement statement = new BankStatement();
        
        account.deposit(new BigDecimal(1000), 
                        LocalDate.of(2012, 01, 10));
        account.deposit(new BigDecimal(2000), 
                        LocalDate.of(2012, 01, 13));
        account.withdraw(new BigDecimal(500), 
                        LocalDate.of(2012, 01, 14));

        String actual = statement.generateBankStatement(account.getTransactions());
        String expected = """
date       ||   credit ||    debit ||  balance
14/01/2012 ||          ||   500.00 ||  2500.00
13/01/2012 ||  2000.00 ||          ||  3000.00
10/01/2012 ||  1000.00 ||          ||  1000.00""";
        
        Assertions.assertEquals(expected, actual);
    }
}
