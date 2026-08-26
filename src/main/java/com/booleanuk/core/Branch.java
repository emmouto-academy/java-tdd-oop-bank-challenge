package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Branch
 */
public class Branch {
    String name;
    List<Account> accounts;

    public Branch(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.setBranch(this);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

}
