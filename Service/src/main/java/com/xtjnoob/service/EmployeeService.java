package com.xtjnoob.service;

import com.xtjnoob.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void add(Employee employee);

    void remove(Integer id);

    void edit(Employee employee);

    Employee getOne(Integer id);

    List<Employee> getAll();
}
