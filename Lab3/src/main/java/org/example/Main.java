package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static BankAccount bankAccount;
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
                    addInterest();
                    break;
                case 5:
                    displayAccount();
                    break;
                case 6:
                    System.out.println("----------------------------------------");
                    System.out.println("Thank you for using our banking service!");
                    System.out.println("----------------------------------------");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
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

    private static void createAccount() {

        if (bankAccount != null) {
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

<<<<<<< HEAD
        BankAccount newAccount = AccountFactory.createAccount(accountType, accountNumber, name, deposit);

        if (newAccount != null) {
            bankAccounts.add(newAccount);
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Invalid account type. Please enter 'savings' or 'checking'.");
        }
=======
        bankAccount = new BankAccount(accountType, accountNumber, name, deposit);
        System.out.println("Account created successfully!");
>>>>>>> origin/main
    }

    private static void depositMoney() {

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
        if (bankAccount != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            bankAccount.withdrawMoney(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

<<<<<<< HEAD
    private static void addInterest() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount(accountNumber);

        if (bankAccount != null) {
            double balanceBeforeInterest = bankAccount.getBalance();
            bankAccount.addInterest();
            double interestEarned = bankAccount.getBalance() - balanceBeforeInterest;

            System.out.println("----------------------");
            System.out.println("Computing interest for Account# " + accountNumber);
            System.out.printf("Interest earned: %.2f%n", interestEarned);
            System.out.printf("New balance: %.2f%n", bankAccount.getBalance());
            System.out.println("----------------------");
        } else {
            System.out.println("Account not found.");
        }
    }

=======
>>>>>>> origin/main
    private static void displayAccount() {

        if (bankAccount != null) {
            System.out.println("--- Account Information ---");
            bankAccount.displayInfo();
            System.out.println("---------------------------");
        } else {
            System.out.println("Account not found.");
        }
    }
<<<<<<< HEAD
}

class AccountFactory {
    public static BankAccount createAccount(String accountType, int accountNumber, String holderName, double initialDeposit) {
        if ("savings".equalsIgnoreCase(accountType) || "checking".equalsIgnoreCase(accountType)) {
            return new BankAccount(accountType, accountNumber, holderName, initialDeposit);
        }
        return null;
    }
}
=======
    private static void addInterest() {

        if (bankAccount != null) {

            bankAccount.addInterest();
            double interestEarned = bankAccount.getBalance() - bankAccount.getInitialBalance();

            System.out.printf("Computing interest for account %d" + "\n", bankAccount.getAccountNumber());
            System.out.printf("Interest earned: %.2f" + "\n", interestEarned);
            System.out.printf("New balance: %.2f" + "\n", bankAccount.getBalance());

        }
        else {
            System.out.println("Account not found.");
        }
    }

}
>>>>>>> origin/main
