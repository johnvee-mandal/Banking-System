package org.example;

import java.util.*;

public class Main {

    private static ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean hasNotExit = true;

        while(hasNotExit!=false) {
            System.out.println("=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");

            System.out.printf("Enter choice (1-5): ");
            int currentChoice = scanner.nextInt();
            scanner.nextLine();

            switch (currentChoice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewAllAccounts();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    depositMoney();
                    break;
                case 5:
                    withdrawMoney();
                    break;
                case 6:
                    hasNotExit=false;
                    System.out.println("----------------------------------------");
                    System.out.println("Thank you for using our banking service!");
                    System.out.println("----------------------------------------");
                    System.exit(0);
                default:
                    System.out.println("Invalid option");
            }

            System.out.println("\n");
            System.out.printf("Would you like to return to the menu? (yes/no): ");

            String response2 = scanner.nextLine();
            if (response2.equals("yes")) {
                continue;
            }

            else if (response2.equals("no")) {

                System.out.println("----------------------------------------");
                System.out.println("Thank you for using our banking service!");
                System.out.println("----------------------------------------");
                return;
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("Thank you for using our banking service!");
        System.out.println("----------------------------------------");
    }

    private static void createAccount() {
        System.out.printf("Enter Account Number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.printf("Enter Holder Name: ");
        String name = scanner.nextLine();

        System.out.printf("Initial deposit? (yes/no): ");
        String response = scanner.nextLine();
        double deposit = 0;

        if (response.equals("yes")) {
            System.out.printf("Enter initial deposit money: ");
            deposit = scanner.nextDouble();
            scanner.nextLine();

            if (deposit < 0) {
                System.out.println("Deposit has to be non-negative.");
                return;
            }
        }

        BankAccount newAccount = new BankAccount(accountNumber, name, deposit);
        bankAccounts.add(newAccount);
        System.out.println("Account created successfully!");

    }

    private static void viewAllAccounts() {
        for (BankAccount bankAccount: bankAccounts) {
            System.out.println("----------------------");
            bankAccount.displayInfo();
            System.out.println("----------------------");
        }
    }

    private static BankAccount findAccount(int number) {
        for (BankAccount bankAccount : bankAccounts) {
            if(bankAccount.getAccountNumber() == number) {
                return bankAccount;
            }
        }
        return null;
    }

    private static void checkBalance() {
        System.out.printf("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount(accountNumber);

        if(bankAccount != null) {
            System.out.println("----------------------");
            System.out.println("Balance: " + bankAccount.getBalance());
            System.out.println("----------------------");
        }

        else {
            System.out.println("----------------------");
            System.out.println("Account does not exist.");
            System.out.println("----------------------");
        }
    }

    private static void depositMoney() {
        System.out.printf("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount((accountNumber));

        if (bankAccount != null) {
            System.out.printf("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            bankAccount.depositMoney(amount);
        }
        else {
            System.out.println("----------------------");
            System.out.println("Account not found.");
            System.out.println("----------------------");
        }
    }

    private static void withdrawMoney() {
        System.out.printf("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount((accountNumber));

        if (bankAccount != null) {
            System.out.printf("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("----------------------");
            bankAccount.withdrawMoney(amount);
            System.out.println("----------------------");
        }
        else {
            System.out.println("----------------------");
            System.out.println("Account not found.");
            System.out.println("----------------------");
        }
    }

}