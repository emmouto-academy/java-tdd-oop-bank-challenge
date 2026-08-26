package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Transaction(
    LocalDate date,
    BigDecimal amount,
    TransactionType type
) {}
