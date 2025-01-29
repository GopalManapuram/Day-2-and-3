package com.Assignment2;
abstract class Account {
    int accountNumber;
    String accountHolder;
    double balance;

    public Account(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    abstract void deposit(double amount);
    abstract void withdraw(double amount);
    abstract void transferFunds(Account toAccount, double amount);
}
class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into Savings Account. New Balance: " + balance);
    }

    @Override
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Savings Account. Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    @Override
    void transferFunds(Account toAccount, double amount) {
        if (amount <= balance) {
            balance -= amount;
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " from Savings Account to " + toAccount.accountHolder);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}
class CurrentAccount extends Account {

    public CurrentAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into Current Account. New Balance: " + balance);
    }

    @Override
    void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrew " + amount + " from Current Account. Remaining Balance: " + balance);
    }

    @Override
    void transferFunds(Account toAccount, double amount) {
        if (amount <= balance) {
            balance -= amount;
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " from Current Account to " + toAccount.accountHolder);
        } else {
            System.out.println("Insufficient Balance!");
        }
    }
}
public class Bank {

    public static void main(String[] args) {
        Account savings = new SavingsAccount(101, "Alice", 5000);
        Account current = new CurrentAccount(102, "Bob", 3000);

        savings.deposit(1000);
        savings.withdraw(1200);
        savings.transferFunds(current, 300);

        current.withdraw(2000);
        System.out.println("\nAccount Details:");
        System.out.println(savings);
        System.out.println(current);
     }
}

