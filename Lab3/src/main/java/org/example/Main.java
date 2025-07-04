package org.example;

public class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(int accountNumber, String holderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;

        if(initialDeposit >= 0) {
            this.balance = initialDeposit;
        }
        else {
            this.balance = 0;
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void depositMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive.");
        }
        else {
            balance += amount;
            System.out.println("Deposit successful.");
        }
    }

    public void withdrawMoney(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        }
        else if (amount > balance) {
            System.out.println("Error: Insufficient balance.");
        }
        else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        }
    }

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
