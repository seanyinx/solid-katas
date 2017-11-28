package com.github.seanyinx.solid.employee;

public class HRReportImpl implements HRReport {

  private final Employee employee;

  public HRReportImpl(Employee employee) {
    this.employee = employee;
  }

  @Override
  public String describe() {
    return String.format("{\"id\": %d, \"name\": \"%s\"}", employee.getId(), employee.getName());
  }
}
