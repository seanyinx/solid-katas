package com.github.seanyinx.solid.employee;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    Employee addEmployee(int id, String name, double salary) {
        Employee employee = new Employee(id, name, salary, employeeRepository);

        employee.save();

        return employee;
    }
}
