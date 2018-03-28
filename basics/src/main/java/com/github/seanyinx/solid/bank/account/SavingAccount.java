package com.github.seanyinx.solid.bank.account;

public interface SavingAccount {
    double balance();

    boolean withdraw(double amount);
}
