# Domain Model

``` java
1. 
As a customer,
So I can safely store and use my money,
I want to create a current account.

class CurrentAccount()
    BigDecimal balance
    getBalance() : BigDecimal 

```

``` java
2.
As a customer,
So I can save for a rainy day,
I want to create a savings account.

abstract class Account()
    BigDecimal balance

class SavingsAccount() extends Account
class CurrentAccount() extends Account

```

``` java
3.
As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

record Transaction()
    Date date
    BigDecimal amount
    BigDecimal balance
    TransactionType type

enum TransactionType
    CREDIT
    DEBIT

class BankStatement()
    generateStatement(transactions) : String

abstract class Account()
    List<Transaction> transactions
    getTransactions() : List<Transaction>

```

``` java
4.
As a customer,
So I can use my account,
I want to deposit and withdraw funds.

abstract class Account()
    deposit() : void
    withdraw() : void
```

``` java 
5. Extension 1
As an engineer,
So I don''t need to keep track of state,
I want account balances to be calculated based on transaction history instead of stored in memory.

remove BigDecimal balance from class Account and record Transaction
change getBalance() to calculate based on transactions
```

``` java
6. Extension 2
As a bank manager,
So I can expand,
I want accounts to be associated with specific branches.

class Branch 
    String name
    List<Account> accounts

abstract class Account
    Branch branch;

Does every Account need to have a Branch?
```

# Class Diagram

```mermaid

classDiagram

class Branch {
    - String name
    - List~Account~ accounts
    + getName() String
    + addAccount(Account account) void
    + getAccounts() List~Account~
}

class Account {
    <<abstract>>
    - BigDecimal balance
    - List~Transaction~
    - Branch branch
    + deposit() void
    + withdraw() void
    + getBalance() BigDecimal
    + getTransactions() List~Transaction~
    + getBranch() branch
}

class SavingsAccount {

}

class CurrentAccount {

}

class Transaction {
    <<record>>
    - LocalDate date
    - BigDecimal amount
    - BigDecimal balance
    - TransactionType type
}

class TransactionType {
    <<enumeration>>
    DEBIT,
    CREDIT
}

class BankStatement {
    + generateStatement : String
}

Account <|-- SavingsAccount : inherits
Account <|-- CurrentAccount : inherits

Branch "1" -- "0..*" Account : has
Account "1" *-- "0..*" Transaction : records
Transaction "1" --> "1" TransactionType : has
BankStatement --> Transaction : formats

```