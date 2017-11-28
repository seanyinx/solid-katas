package com.github.seanyinx.solid.employee;

public class HumanResource {
  String generateEmployeeReport(HRReport hrReport) {
    return String.format("{\"Employee\": %s}", hrReport.describe());
  }
}
