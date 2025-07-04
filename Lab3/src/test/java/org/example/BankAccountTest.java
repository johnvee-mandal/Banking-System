package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount testSavingsAccount;
    private BankAccount testCheckingAccount;

    @BeforeEach
    void setUp(){
        testSavingsAccount = new BankAccount("savings", 1, "John Doe", 1000);
        testCheckingAccount = new BankAccount("checking", 2, "Jill Doe", 1000);
    }

    @Test
    void testBankAccountCreation(){
        BankAccount accountCreationTest_Savings = new BankAccount("savings", 3, "Jack Doe", 1000);
        BankAccount accountCreationTest_Checking = new BankAccount("checking", 3, "Jamarcus Doe", 1000);

        assertNotNull(accountCreationTest_Savings);
        assertNotNull(accountCreationTest_Checking);
    }

    @Test
    void testValidWithdrawAmount() {

        testSavingsAccount.withdrawMoney(500);
        assertEquals(500,testSavingsAccount.getBalance(), 0.001);

        testCheckingAccount.withdrawMoney(500);
        assertEquals(500,testCheckingAccount.getBalance(), 0.001);

    }

    @Test
    void testInvalidWithdrawAmount() {

        testSavingsAccount.withdrawMoney(-500);
        assertEquals(testSavingsAccount.getInitialBalance(),testSavingsAccount.getBalance(), 0.001);

        testCheckingAccount.withdrawMoney(-500);
        assertEquals(testCheckingAccount.getInitialBalance(),testCheckingAccount.getBalance(), 0.001);

    }

    @Test
    void testValidDepositAmount() {

        testSavingsAccount.depositMoney(500);
        assertEquals(1500,testSavingsAccount.getBalance(), 0.001);

        testCheckingAccount.depositMoney(500);
        assertEquals(1500,testCheckingAccount.getBalance(), 0.001);

    }

    @Test
    void testInvalidDepositAmount() {

        testSavingsAccount.depositMoney(-500);
        assertEquals(testSavingsAccount.getInitialBalance(),testSavingsAccount.getBalance(), 0.001);

        testCheckingAccount.depositMoney(-500);
        assertEquals(testCheckingAccount.getInitialBalance(),testCheckingAccount.getBalance(), 0.001);

    }

    @Test
    void testInterestCalculations() {

        testSavingsAccount.addInterest();
        assertEquals((testSavingsAccount.getInitialBalance() * 1.06),testSavingsAccount.getBalance(), 0.001);

        testCheckingAccount.addInterest();
        assertEquals((testCheckingAccount.getInitialBalance() * 1.01),testCheckingAccount.getBalance(), 0.001);

    }
}