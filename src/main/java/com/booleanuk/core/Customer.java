package com.booleanuk.core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Customer
 */
public class Customer {
    List<Account> accounts;

    public Customer() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAccount'");
    }

    public OverdraftRequest requestOverdraft(Account account, BigDecimal amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestOverdraft'");
    }

}
