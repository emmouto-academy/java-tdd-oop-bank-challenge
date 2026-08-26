package com.booleanuk.core;

import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * BankStatement
 */
public class BankStatement {
    public String generateBankStatement(List<Transaction> transactions) {
        StringBuilder statement = new StringBuilder();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        statement.append(String.format(
            "%-10s || %8s || %8s || %8s%n", 
            "date", "credit", "debit", "balance"));

        for (Transaction t : transactions.reversed()) {
            statement.append(String.format(
                "%-10s || %8s || %8s || %8.2f%n",
                 t.date().format(dateFormatter), 
                 t.type().equals(TransactionType.CREDIT) ? String.format("%.2f", t.amount()) : "", 
                 t.type().equals(TransactionType.DEBIT) ? String.format("%.2f", t.amount()) : "", 
                 t.balance())
            );
        }

        return statement.toString().trim();
    }
}
