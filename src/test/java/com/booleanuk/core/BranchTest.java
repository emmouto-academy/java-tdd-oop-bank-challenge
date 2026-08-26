package com.booleanuk.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BranchTest {
    @Test
    public void newBranch_hasNoAccounts() {
        Branch branch = new Branch("Gothenburg");

        Assertions.assertTrue(branch.getAccounts().isEmpty());
    }

    @Test
    public void addAccount_branchHasOneAccount() {
        Branch branch = new Branch("Gothenburg");
        Account account = new CurrentAccount();

        branch.addAccount(account);

        Assertions.assertTrue(branch.getAccounts().contains(account));
    }

    @Test
    public void addAccount_canAddMultipleAccounts() {
        Branch branch = new Branch("Gothenburg");
        Account account1 = new CurrentAccount();
        Account account2 = new SavingsAccount();

        branch.addAccount(account1);
        branch.addAccount(account2);

        Assertions.assertTrue(branch.getAccounts().contains(account1));
        Assertions.assertTrue(branch.getAccounts().contains(account2));
    }
}
