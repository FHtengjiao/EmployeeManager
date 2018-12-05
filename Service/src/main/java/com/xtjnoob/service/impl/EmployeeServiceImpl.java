package com.xtjnoob.service.impl;

import com.xtjnoob.dao.EmployeeDao;
import com.xtjnoob.entity.Employee;
import com.xtjnoob.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void add(Employee employee) {
        employee.setPassword("123456");
        employee.setEnterTime(new Date(System.currentTimeMillis()));
        employeeDao.insert(employee);
    }

    public void remove(Integer id) {
        employeeDao.deleteById(id);
    }

    public void edit(Employee employee) {
        employeeDao.update(employee);
    }

    public Employee getOne(Integer id) {
        return employeeDao.getEmployeeById(id);
    }

    public List<Employee> getAll() {
        return employeeDao.getAllEmployees();
    }
}
