package org.example;

public abstract class BankAccount {
    protected String accountNumber;
    protected String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = Math.max(0, initialDeposit);
    }

    public abstract void computeInterest();

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + String.format("%.2f", balance));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + String.format("%.2f", balance));
        }
    }

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name   : " + holderName);
        System.out.println("Balance       : " + String.format("%.2f", balance));
    }
}

class SavingsAccount extends BankAccount {
    private static final double SAVINGS_RATE = 0.06;

    public SavingsAccount(String accountNumber, String holderName, double initialDeposit) {
        super(accountNumber, holderName, initialDeposit);
    }

    public void computeInterest() {
        double interest = this.balance * SAVINGS_RATE;
        System.out.println("Interest earned: " + String.format("%.2f", interest));
        this.balance += interest;
        System.out.println("New balance after interest: " + String.format("%.2f", this.balance));
    }
}

class CheckingAccount extends BankAccount {
    private static final double CHECKING_RATE = 0.01;

    public CheckingAccount(String accountNumber, String holderName, double initialDeposit) {
        super(accountNumber, holderName, initialDeposit);
    }

    public void computeInterest() {
        double interest = this.balance * CHECKING_RATE;
        System.out.println("Interest earned: " + String.format("%.2f", interest));
        this.balance += interest;
        System.out.println("New balance after interest: " + String.format("%.2f", this.balance));
    }
}
