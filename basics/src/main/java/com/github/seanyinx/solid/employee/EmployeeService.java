package com.github.seanyinx.solid.employee;

import java.sql.SQLException;

public interface EmployeeService {
  Employee addEmployee(int id, String name, double salary);

  void save(Employee employee);

  Employee findById(int id) throws SQLException;
}
