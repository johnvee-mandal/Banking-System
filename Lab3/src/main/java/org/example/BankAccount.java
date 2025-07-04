package org.example;

public class BankAccount {

    private static BankAccount instance;

    private int accountNumber;
    private String holderName;
    private double balance;
    private String accountType; 
    private double initialBalance;

    private BankAccount(String accountType, int accountNumber, String holderName, double initialDeposit) {
        this.accountType = accountType.toLowerCase();
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = Math.max(0, initialDeposit);
        this.initialBalance = this.balance;
    }

    public static BankAccount createAccount(String accountType, int accountNumber, String holderName, double initialDeposit) {
        if (instance == null && (accountType.equalsIgnoreCase("savings") || accountType.equalsIgnoreCase("checking"))) {
            instance = new BankAccount(accountType, accountNumber, holderName, initialDeposit);
            System.out.println("Account created successfully!");
        } else if (instance != null) {
            System.out.println("An account already exists. Only one account is allowed.");
        } else {
            System.out.println("Invalid account type.");
        }
        return instance;
    }

    public static BankAccount getInstance() {
        return instance;
    }

    public static void resetInstanceForTesting() {
        instance = null;
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
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.printf("Balance: %.2f%n", balance);
    }
}
