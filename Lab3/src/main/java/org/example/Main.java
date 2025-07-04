package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Bank bank = Bank.getInstance();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1: createNewAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: computeInterest(); break;
                case 5: displayAccountDetails(); break;
                case 6:
                    System.out.println("Thank you for using our banking service!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Banking System ===");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Compute Interest");
        System.out.println("5. Display Account Details");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        } finally {
            scanner.nextLine();
        }
    }

    private static void createNewAccount() {
        System.out.print("Enter Account Type (savings/checking): ");
        String type = scanner.nextLine();
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter Holder Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double deposit = getDoubleInput();

        BankAccount newAccount = AccountFactory.createAccount(type, accNum, name, deposit);
        bank.addAccount(newAccount);
    }

    private static BankAccount findAccountByNumber() {
        System.out.print("Enter Account Number: ");
        String accNum = scanner.nextLine();
        BankAccount account = bank.findAccount(accNum);
        if (account == null) {
            System.out.println("Account not found.");
        }
        return account;
    }

    private static void deposit() {
        BankAccount account = findAccountByNumber();
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = getDoubleInput();
            account.deposit(amount);
        }
    }

    private static void withdraw() {
        BankAccount account = findAccountByNumber();
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = getDoubleInput();
            account.withdraw(amount);
        }
    }
    
    private static void computeInterest() {
        BankAccount account = findAccountByNumber();
        if (account != null) {
            account.computeInterest();
        }
    }

    private static void displayAccountDetails() {
        BankAccount account = findAccountByNumber();
        if (account != null) {
            System.out.println("----------------------");
            account.displayInfo();
            System.out.println("----------------------");
        }
    }

    private static double getDoubleInput() {
        try {
            return scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return 0;
        } finally {
            scanner.nextLine();
        }
    }
}

class Bank {
    private static Bank instance;
    private final List<BankAccount> accounts;

    private Bank() {
        accounts = new ArrayList<>();
    }

    public static Bank getInstance() {
        if (instance == null) {
            instance = new Bank();
        }
        return instance;
    }

    public void addAccount(BankAccount account) {
        if (account != null) {
            accounts.add(account);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Failed to create account: Invalid account type.");
        }
    }

    public BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

class AccountFactory {
    public static BankAccount createAccount(String accountType, String accountNumber, String holderName, double initialDeposit) {
        if (accountType == null) {
            return null;
        }
        if (accountType.equalsIgnoreCase("savings")) {
            return new SavingsAccount(accountNumber, holderName, initialDeposit);
        } else if (accountType.equalsIgnoreCase("checking")) {
            return new CheckingAccount(accountNumber, holderName, initialDeposit);
        }
        return null;
    }
}
