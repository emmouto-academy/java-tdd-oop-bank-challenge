package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * BankStatement
 */
public class BankStatement {
    public String generateStatement(List<Transaction> transactions) {
        StringBuilder statement = new StringBuilder();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        statement.append(String.format(
            "%-10s || %8s || %8s || %8s%n", 
            "date", "credit", "debit", "balance"));

            Deque<String> rows = new ArrayDeque<>();
            BigDecimal balance = BigDecimal.ZERO;

        for (Transaction t : transactions) {
            balance = t.type() == TransactionType.CREDIT 
                ? balance.add(t.amount())
                : balance.subtract(t.amount());
            
            String credit = t.type() == TransactionType.CREDIT 
                ? String.format("%.2f", t.amount()) 
                : "";

            String debit = t.type() == TransactionType.DEBIT 
                ? String.format("%.2f", t.amount()) 
                : "";

            rows.addFirst(String.format(
                "%-10s || %8s || %8s || %8.2f%n",
                 t.date().format(dateFormatter), 
                 credit, 
                 debit,
                 balance
            ));
        }

        for (String row : rows)
                statement.append(row);

        return statement.toString().trim();
    }
}
