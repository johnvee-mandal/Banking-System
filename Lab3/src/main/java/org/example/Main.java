package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

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
            int currentChoice = getUserChoice();

            switch (currentChoice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    computeInterest();
                    break;
                case 5:
                    displayAccount();
                    break;
                case 6:
                    System.out.println("----------------------------------------");
                    System.out.println("Thank you for using our banking service!");
                    System.out.println("----------------------------------------");
                    return; // Clean way to exit the loop and program
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static int getUserChoice() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return -1; // Return an invalid choice
        } finally {
            scanner.nextLine(); // Always consume the newline character
        }
    }

    private static BankAccount findAccount(int number) {
        for (BankAccount bankAccount : bankAccounts) {
            if (bankAccount.getAccountNumber() == number) {
                return bankAccount;
            }
        }
        return null;
    }

    private static void createAccount() {
        System.out.print("Enter Account Type (savings/checking): ");
        String accountType = scanner.nextLine();

        if (!"savings".equalsIgnoreCase(accountType) && !"checking".equalsIgnoreCase(accountType)) {
            System.out.println("Invalid account type. Please enter 'savings' or 'checking'.");
            return;
        }

        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial deposit amount: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine();

        BankAccount newAccount = new BankAccount(accountType, accountNumber, name, deposit);
        bankAccounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    private static void depositMoney() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            bankAccount.depositMoney(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            bankAccount.withdrawMoney(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void computeInterest() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount != null) {
            System.out.println("----------------------");
            System.out.println("Computing interest for Account# " + bankAccount.getAccountNumber());
            bankAccount.computeAndApplyInterest();
            System.out.println("----------------------");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void displayAccount() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount != null) {
            System.out.println("--- Account Information ---");
            bankAccount.displayInfo();
            System.out.println("---------------------------");
        } else {
            System.out.println("Account not found.");
        }
    }
}
