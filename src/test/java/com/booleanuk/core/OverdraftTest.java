package com.booleanuk.core;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class OverdraftTest {
    @Test
    public void newOverdraft_isPending() {
        OverdraftRequest request = new OverdraftRequest(new BigDecimal(500));

        Assertions.assertEquals(OverdraftStatus.PENDING, request.getStatus());
    }

    @Test
    public void customer_canRequestOverdraft() {
        Customer customer = new Customer();
        Account account = new CurrentAccount();
        customer.addAccount(account);
        // account needs to belong to customer, check?

        OverdraftRequest request = customer.requestOverdraft(account, new BigDecimal(500));

        Assertions.assertEquals(OverdraftStatus.PENDING, request.getStatus());
    }

    @Test
    public void manager_canApproveOverdraft() {
        BankManager manager = new BankManager();
        OverdraftRequest request = new OverdraftRequest(new BigDecimal(100));

        manager.approve(request);

        Assertions.assertEquals(OverdraftStatus.APPROVED, request.getStatus());
    }

    @Test
    public void manager_canRejectOverdraft() {
        BankManager manager = new BankManager();
        OverdraftRequest request = new OverdraftRequest(new BigDecimal(100));

        manager.reject(request);

        Assertions.assertEquals(OverdraftStatus.REJECTED, request.getStatus());
    }
}
