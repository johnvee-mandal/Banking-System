package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Welcome to Bank#2 ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Compute Interest");
            System.out.println("5. Display Account");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = getUserChoice();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> depositMoney();
                case 3 -> withdrawMoney();
                case 4 -> addInterest();
                case 5 -> displayAccount();
                case 6 -> {
                    System.out.println("----------------------------------------");
                    System.out.println("Thank you for using our banking service!");
                    System.out.println("----------------------------------------");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1;
        } finally {
            scanner.nextLine(); // consume newline
        }
    }

    private static void createAccount() {
        if (BankAccount.getInstance() != null) {
            System.out.println("An account already exists. Only one account is allowed.");
            return;
        }

        System.out.print("Enter Account Type (savings/checking): ");
        String accountType = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine();

        BankAccount created = BankAccount.createAccount(accountType, accountNumber, name, deposit);
        if (created == null) {
            System.out.println("Invalid account type. Account not created.");
        } else {
            System.out.println("Account created successfully!");
        }
    }

    private static void depositMoney() {
        BankAccount account = BankAccount.getInstance();
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.depositMoney(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        BankAccount account = BankAccount.getInstance();
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.withdrawMoney(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void addInterest() {
        BankAccount account = BankAccount.getInstance();
        if (account != null) {
            double before = account.getBalance();
            account.addInterest();
            double interest = account.getBalance() - before;

            System.out.printf("Computing interest for account %d%n", account.getAccountNumber());
            System.out.printf("Interest earned: %.2f%n", interest);
            System.out.printf("New balance: %.2f%n", account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void displayAccount() {
        BankAccount account = BankAccount.getInstance();
        if (account != null) {
            System.out.println("--- Account Information ---");
            account.displayInfo();
            System.out.println("---------------------------");
        } else {
            System.out.println("Account not found.");
        }
    }
}
