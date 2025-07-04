package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @BeforeEach
    void resetSingleton() {
        BankAccount.resetInstanceForTesting(); 
    }

    @Test
    void testSingletonCreation() {
        BankAccount account1 = BankAccount.createAccount("savings", 101, "Alice", 1000);
        BankAccount account2 = BankAccount.createAccount("checking", 102, "Bob", 500);

        assertSame(account1, account2, "Singleton should return the same instance");
        assertEquals("savings", account1.getAccountType(), "Account type should be from first creation only");
        assertEquals(101, account1.getAccountNumber());
        assertEquals("Alice", account1.getHolderName());
    }

    @Test
    void testValidDeposit() {
        BankAccount account = BankAccount.createAccount("checking", 103, "Charlie", 1000);
        account.depositMoney(500);
        assertEquals(1500, account.getBalance(), 0.001);
    }

    @Test
    void testInvalidDeposit() {
        BankAccount account = BankAccount.createAccount("checking", 104, "Dave", 1000);
        account.depositMoney(-300); // Should be ignored
        assertEquals(1000, account.getBalance(), 0.001);
    }

    @Test
    void testValidWithdraw() {
        BankAccount account = BankAccount.createAccount("checking", 105, "Eve", 1000);
        account.withdrawMoney(400);
        assertEquals(600, account.getBalance(), 0.001);
    }

    @Test
    void testInvalidWithdraw() {
        BankAccount account = BankAccount.createAccount("checking", 106, "Frank", 1000);
        account.withdrawMoney(-200); // Invalid
        account.withdrawMoney(2000); // Exceeds balance
        assertEquals(1000, account.getBalance(), 0.001);
    }

    @Test
    void testInterestForSavingsAccount() {
        BankAccount account = BankAccount.createAccount("savings", 107, "Grace", 1000);
        account.addInterest();
        assertEquals(1060.0, account.getBalance(), 0.001);
    }

    @Test
    void testInterestForCheckingAccount() {
        BankAccount account = BankAccount.createAccount("checking", 108, "Henry", 1000);
        account.addInterest();
        assertEquals(1010.0, account.getBalance(), 0.001);
    }

    @Test
    void testInitialBalanceTracking() {
        BankAccount account = BankAccount.createAccount("savings", 109, "Isaac", 1000);
        account.depositMoney(200);
        account.withdrawMoney(100);
        assertEquals(1000 + 200 - 100, account.getBalance(), 0.001);
    }
}
