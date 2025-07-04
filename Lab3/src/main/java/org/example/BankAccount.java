package org.example;

public class BankAccount {

    private static BankAccount instance;

    private int accountNumber;
    private String holderName;
    private double balance;
    private double initialBalance;
    private String accountType;

    private BankAccount(String accountType, int accountNumber, String holderName, double initialDeposit) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = Math.max(0, initialDeposit);
        this.initialBalance = this.balance;
    }

    // Factory + Singleton combined
    public static BankAccount createAccount(String accountType, int accountNumber, String holderName, double initialDeposit) {
        if (instance != null) return null; // Only one account allowed
        if (!"savings".equalsIgnoreCase(accountType) && !"checking".equalsIgnoreCase(accountType)) {
            return null; // invalid type
        }
        instance = new BankAccount(accountType, accountNumber, holderName, initialDeposit);
        return instance;
    }

    public static BankAccount getInstance() {
        return instance;
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
            initialBalance += amount;
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
        if ("savings".equalsIgnoreCase(accountType)) {
            balance *= 1.06;
        } else if ("checking".equalsIgnoreCase(accountType)) {
            balance *= 1.01;
        }
    }

    public void displayInfo() {
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.printf("Balance: %.2f%n", balance);
    }
}
