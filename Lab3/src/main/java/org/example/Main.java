package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static ArrayList<BankAccount> bankAccounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
<<<<<<< HEAD

        boolean hasNotExit = true;

        while(hasNotExit!=false) {
            System.out.println("=== Welcome to Bank#2 ===");
=======
        while (true) {
            System.out.println("\n=== Welcome to Bank#2 ===");
>>>>>>> Johnvee-Branch
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Compute Interest");
            System.out.println("5. Display Account");
            System.out.println("6. Exit");

<<<<<<< HEAD
            System.out.printf("Enter choice: ");
            int currentChoice = scanner.nextInt();
            scanner.nextLine();
=======
            System.out.print("Enter choice: ");
            int currentChoice = getUserChoice();
>>>>>>> Johnvee-Branch

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

<<<<<<< HEAD
    private static BankAccount findAccount(int number) {
        for (BankAccount bankAccount : bankAccounts) {
            if(bankAccount.getAccountNumber() == number) {
=======
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
>>>>>>> Johnvee-Branch
                return bankAccount;
            }
        }
        return null;
    }

    private static void createAccount() {
<<<<<<< HEAD
        System.out.println("Enter Account Type (savings/checking): ");
        String accountType = scanner.nextLine();

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

        BankAccount newAccount = new BankAccount(accountType, accountNumber, name, deposit); //added accountType
        bankAccounts.add(newAccount);
        System.out.println("Account created successfully!");

    }

    private static void depositMoney() {

        System.out.printf("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount((accountNumber));

        System.out.printf("Enter Account Type (savings/checking): ");
        String accountType = scanner.nextLine();
=======
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
>>>>>>> Johnvee-Branch

        if (bankAccount != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
<<<<<<< HEAD

            bankAccount.depositMoney(accountType, amount); //added accountType
        }
        else {
            System.out.println("----------------------");
=======
            bankAccount.depositMoney(amount);
        } else {
>>>>>>> Johnvee-Branch
            System.out.println("Account not found.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount(accountNumber);

        System.out.printf("Enter Account Type (savings/checking): ");
        String accountType = scanner.nextLine();

        if (bankAccount != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
<<<<<<< HEAD
            System.out.println("----------------------");
            bankAccount.withdrawMoney(accountType, amount); //added accountType
            System.out.println("----------------------");
        }
        else {
            System.out.println("----------------------");
=======
            bankAccount.withdrawMoney(amount);
        } else {
>>>>>>> Johnvee-Branch
            System.out.println("Account not found.");
        }
    }

    private static void computeInterest() {
<<<<<<< HEAD
        System.out.printf("Enter account number: ");
=======
        System.out.print("Enter account number: ");
>>>>>>> Johnvee-Branch
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount(accountNumber);

<<<<<<< HEAD
        System.out.printf("Enter Account Type (savings/checking): ");
        String accountType = scanner.nextLine();

        if(bankAccount != null) {
            System.out.println("----------------------");
            System.out.println("Computing interest for Account# " + bankAccount);
            System.out.println("Interest earned: "); //add interest here
            System.out.println("New balance: "); //add new balance of account here
            System.out.println("----------------------");
        }

        else {
            System.out.println("----------------------");
            System.out.println("Account does not exist.");
            System.out.println("----------------------");
        }

    }


    private static void displayAccount() {
        System.out.printf("Enter account number: ");
=======
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
>>>>>>> Johnvee-Branch
        int accountNumber = scanner.nextInt();
        scanner.nextLine();
        BankAccount bankAccount = findAccount(accountNumber);

<<<<<<< HEAD
        System.out.printf("Enter Account Type (savings/checking): ");
        String accountType = scanner.nextLine();

        if(bankAccount != null) {
            System.out.println("--- Account Information ---");
            System.out.println("Account Number: " + bankAccount.getAccountNumber());
            System.out.println("Holder Name: " + bankAccount.getHolderName());
            System.out.println("Balance: " + bankAccount.getAccountNumber()); //Fix this I think?
            System.out.println("---------------------------");
        }

        else {
            System.out.println("----------------------");
            System.out.println("Account does not exist.");
            System.out.println("----------------------");
        }
    }

}
=======
        if (bankAccount != null) {
            System.out.println("--- Account Information ---");
            bankAccount.displayInfo();
            System.out.println("---------------------------");
        } else {
            System.out.println("Account not found.");
        }
    }
}
>>>>>>> Johnvee-Branch
