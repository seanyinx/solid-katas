package com.github.seanyinx.solid.employee;

import java.sql.ResultSet;

public interface EmployeeRepository {
  void save(int id, String name, double salary);

  ResultSet findById(int id);
}
