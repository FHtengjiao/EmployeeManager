package com.xtjnoob.service.impl;

import com.xtjnoob.dao.EmployeeDao;
import com.xtjnoob.dao.SelfDao;
import com.xtjnoob.entity.Employee;
import com.xtjnoob.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("selfService")
public class SelfServiceImpl implements SelfService {

    @Autowired
    private SelfDao selfDao;

    @Autowired
    private EmployeeDao employeeDao;

    public Employee login(String account, String password) {
        Employee employee = selfDao.getEmployeeByAccount(account);
        if (employee == null) {
            return null;
        }
        if (employee.getPassword().equals(password)) {
            return employee;
        } else {
            return null;
        }
    }

    public boolean changePassword(Integer id, String oldPassword, String newPassword) {
        Employee employee = employeeDao.getEmployeeById(id);
        if (employee.getPassword().equals(oldPassword)) {
            employee.setPassword(newPassword);
            employeeDao.update(employee);
            return true;
        }
        return false;
    }
}
