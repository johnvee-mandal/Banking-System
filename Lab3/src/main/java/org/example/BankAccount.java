package org.example;

public abstract class BankAccount {
    protected int accountNumber;
    protected String holderName;
    protected double balance;

    public BankAccount(int accountNumber, String holderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = Math.max(0, initialDeposit);
    }

    public abstract void computeInterest();

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
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

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + String.format("%.2f", balance));
    }
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.06; 

    public SavingsAccount(int accountNumber, String holderName, double initialDeposit) {
        super(accountNumber, holderName, initialDeposit);
    }

    @Override
    public void computeInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest earned: " + String.format("%.2f", interest));
        System.out.println("New balance: " + String.format("%.2f", balance));
    }
}

class CheckingAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.01;

    public CheckingAccount(int accountNumber, String holderName, double initialDeposit) {
        super(accountNumber, holderName, initialDeposit);
    }

    @Override
    public void computeInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest earned: " + String.format("%.2f", interest));
        System.out.println("New balance: " + String.format("%.2f", balance));
    }
}
