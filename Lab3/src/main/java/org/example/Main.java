package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

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
            int choice = getUserChoice();

            switch (choice) {
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
            scanner.nextLine(); // clear newline
        }
    }

    private static void createAccount() {
        System.out.print("Enter Account Type (savings/checking): ");
        String type = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Initial Deposit: ");
        double deposit = scanner.nextDouble();
        scanner.nextLine();

        BankAccount.createAccount(type, number, name, deposit);
    }

    private static void depositMoney() {
        BankAccount account = BankAccount.getInstance();
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.depositMoney(amount);
        } else {
            System.out.println("No account found.");
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
            System.out.println("No account found.");
        }
    }

    private static void computeInterest() {
        BankAccount account = BankAccount.getInstance();
        if (account != null) {
            double before = account.getBalance();
            account.addInterest();
            double interest = account.getBalance() - before;
            System.out.printf("Interest earned: %.2f%n", interest);
            System.out.printf("New balance: %.2f%n", account.getBalance());
        } else {
            System.out.println("No account found.");
        }
    }

    private static void displayAccount() {
        BankAccount account = BankAccount.getInstance();
        if (account != null) {
            System.out.println("--- Account Information ---");
            account.displayInfo();
            System.out.println("---------------------------");
        } else {
            System.out.println("No account found.");
        }
    }
}
