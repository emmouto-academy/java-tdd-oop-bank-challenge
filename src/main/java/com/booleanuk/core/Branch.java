package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Branch
 */
public class Branch {
    String name;
    List<Account> accounts; // TODO change to customer

    public Branch(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setBranch(this); // TODO move to Customer and figure out how this should work
    }

    public List<Account> getAccounts() {
        return accounts;
    }

}
