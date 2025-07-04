package org.example;

public class BankAccount {
    private int accountNumber;
    private String holderName;
    private double balance;
    private String accountType; // "savings" or "checking"
    private double initialBalance;

    public BankAccount(String accountType, int accountNumber, String holderName, double initialDeposit) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.holderName = holderName;

        if(initialDeposit >= 0) {
            this.balance = initialDeposit;
            this.initialBalance = initialDeposit;
        }
        else {
            this.balance = 0;
            this.initialBalance = 0;
        }
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

    public void computeAndApplyInterest() {
        double interestRate;
        if ("savings".equalsIgnoreCase(this.accountType)) {
            interestRate = 0.06; // 6% for savings
        } else {
            interestRate = 0.01; // 1% for checking
        }

        double interestEarned = this.balance * interestRate;
        this.balance += interestEarned;

        System.out.println("Interest earned: " + String.format("%.2f", interestEarned));
        System.out.println("New balance: " + String.format("%.2f", this.balance));
    }

    public void displayInfo() {
        System.out.println("Account Type: " + accountType);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + String.format("%.2f", balance));
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void addInterest (){
        balance *= 1.06; //Adds 6% to balance
    }
}
