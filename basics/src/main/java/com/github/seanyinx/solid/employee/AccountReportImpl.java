package com.github.seanyinx.solid.employee;

public class AccountReportImpl implements AccountReport {

  private final Employee employee;

  public AccountReportImpl(Employee employee) {
    this.employee = employee;
  }

  @Override
  public double calculatePay() {
    return employee.getSalary() * 0.8;
  }

  @Override
  public double calculateTax() {
    return employee.getSalary() * 0.2;
  }
}
