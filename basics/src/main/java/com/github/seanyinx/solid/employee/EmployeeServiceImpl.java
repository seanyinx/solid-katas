package com.github.seanyinx.solid.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class EmployeeServiceImpl implements EmployeeService {
  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public Employee addEmployee(int id, String name, double salary) {
    Employee employee = new Employee(id, name, salary);
    this.save(employee);
    return employee;
  }

  @Override
  public void save(Employee employee) {
    employeeRepository.save(employee.getId(), employee.getName(), employee.getSalary());
  }

  @Override
  public Employee findById(int id) throws SQLException {
    ResultSet resultSet = employeeRepository.findById(id);
    if (resultSet.next()) {
      int employeeId = resultSet.getInt(1);
      String name = resultSet.getString(2);
      double salary = resultSet.getDouble(3);
      return new Employee(employeeId, name, salary);
    }

    throw new NoSuchElementException("No such employee with id " + id);
  }
}
