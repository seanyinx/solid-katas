package com.github.seanyinx.solid.employee;

public class HumanResource {
    String generateEmployeeReport(Employee employee) {
        return String.format("{\"Employee\": %s}", employee.describe());
    }
}
