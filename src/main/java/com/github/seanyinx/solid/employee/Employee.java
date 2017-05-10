package com.github.seanyinx.solid.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class Employee {
    private final int    id;
    private final String name;
    private final double salary;
    private final EmployeeRepository employeeRepository;

    public Employee(int id, String name, double salary, EmployeeRepository employeeRepository) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.employeeRepository = employeeRepository;
    }

    void save() {
        employeeRepository.save(id, name, salary);
    }

    Employee findById(int id) throws SQLException {
        ResultSet resultSet = employeeRepository.findById(id);
        if (resultSet.next()) {
            int employeeId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            double salary = resultSet.getDouble(3);
            return new Employee(employeeId, name, salary, employeeRepository);
        }

        throw new NoSuchElementException("No such employee with id " + id);
    }

    double calculatePay() {
        return salary * 0.8;
    }

    double calculateTax() {
        return salary * 0.2;
    }

    String describe() {
        return String.format("{\"id\": %d, \"name\": \"%s\"}", id, name);
    }
}
