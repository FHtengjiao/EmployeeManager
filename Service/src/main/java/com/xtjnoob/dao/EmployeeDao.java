package com.xtjnoob.dao;

import com.xtjnoob.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    void insert(Employee employee);

    void deleteById(Integer id);

    void update(Employee employee);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployees();
}
