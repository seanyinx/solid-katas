package com.github.seanyinx.solid.employee;

public class Accountant {
  String generatePayroll(AccountReport report) {
    return String.format(
        "{\"Payroll\": { \"salary\": %f, \"tax\": %f}}",
        report.calculatePay(),
        report.calculateTax()
    );
  }
}
