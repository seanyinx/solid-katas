package com.github.seanyinx.solid.bank.account;

public class RegularSavingAccount implements SavingAccount {
    private double balance;

    RegularSavingAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double balance() {
        return balance;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }

        return false;
    }
}
