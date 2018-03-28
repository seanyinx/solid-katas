package com.github.seanyinx.solid.bank.account;

public class FixedDepositSavingAccount implements SavingAccount {

    private final double balance;

    FixedDepositSavingAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double balance() {
        return balance;
    }

    @Override
    public boolean withdraw(double amount) {
        return false;
    }
}
