package org.example;

public class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;
    private String accountType;
    private double initialBalance;

    public BankAccount(String accountType, int accountNumber, String holderName, double initialDeposit) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = Math.max(0, initialDeposit);
        this.initialBalance = this.balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void depositMoney(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdrawMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Error: Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public void addInterest() {
        if ("savings".equalsIgnoreCase(this.accountType)) {
            this.balance *= 1.06;
        } else if ("checking".equalsIgnoreCase(this.accountType)) {
            this.balance *= 1.01;
        }
    }

    public void displayInfo() {
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + String.format("%.2f", balance));
    }
}
