package com.github.seanyinx.solid.employee;

public class Accountant {
    String generatePayroll(Employee employee) {
        return String.format(
                "{\"Payroll\": { \"salary\": %f, \"tax\": %f}}",
                employee.calculatePay(),
                employee.calculateTax()
        );
    }
}
