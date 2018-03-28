package com.github.seanyinx.solid.bank.account;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class SavingAccountTest {

    private final SavingAccount savingAccount = new RegularSavingAccount(1000d);

    @Test
    public void ableToWithdrawCash() {
        boolean success = savingAccount.withdraw(100d);

        assertThat(success, is(true));
        assertThat(savingAccount.balance(), closeTo(900d, 0.000001d));
    }
}