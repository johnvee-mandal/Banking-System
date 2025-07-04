package org.example;

public class BankAccount {

    private static BankAccount instance;

    private int accountNumber;
    private String holderName;
    private double balance;
<<<<<<< HEAD
    private String accountType;
=======
    private String accountType; // "savings" or "checking"
>>>>>>> origin/main
    private double initialBalance;

    public BankAccount(String accountType, int accountNumber, String holderName, double initialDeposit) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = Math.max(0, initialDeposit);
        this.initialBalance = this.balance;
<<<<<<< HEAD
=======
    }

    public static BankAccount createAccount(String accountType, int accountNumber, String holderName, double initialDeposit) {

        if (instance == null) {
            instance = new BankAccount(accountType, accountNumber, holderName, initialDeposit);
            System.out.println("Account created successfully!");
        }

        return instance;
    }

    public static BankAccount getInstance() {
        if (instance == null) {
            System.out.println("No account has been created yet.");
        }
        return instance;
>>>>>>> origin/main
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

<<<<<<< HEAD
    public void addInterest() {
        if ("savings".equalsIgnoreCase(this.accountType)) {
            this.balance *= 1.06;
        } else if ("checking".equalsIgnoreCase(this.accountType)) {
            this.balance *= 1.01;
        }
    }

=======
>>>>>>> origin/main
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
        if(this.getAccountType().equalsIgnoreCase("Savings")){
            balance *= 1.06; //Adds 6% to this balance
        }
        else{
            balance *= 1.01; //Adds 1% to this balance
        }
    }

    public static void resetInstance() {
        instance = null;
        System.out.println("Singleton instance reset.");
    }
}
