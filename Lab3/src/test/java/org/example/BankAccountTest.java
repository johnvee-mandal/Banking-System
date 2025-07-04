package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class BankAccountTest {

    private BankAccount testSavingsAccount;
    private BankAccount testCheckingAccount;

    @BeforeEach
    void setUp(){
        testSavingsAccount = new BankAccount("savings", 1, "John Doe", 1000);
        testCheckingAccount = new BankAccount("checking", 2, "Jill Doe", 1000);
    }

    @Test
    void getAccountNumber() {
    }

    @Test
    void depositMoney() {
    }

    @Test
    void withdrawMoney() {
    }

    @Test
    void addInterest() {
    }
}