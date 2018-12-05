package com.xtjnoob.service.impl;

import com.xtjnoob.dao.SelfDao;
import com.xtjnoob.entity.Employee;
import com.xtjnoob.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfServiceImpl implements SelfService {

    @Autowired
    private SelfDao selfDao;

    @Override
    public void login(String account) {
        Employee employee = selfDao.getEmployeeByAccount(account);

    }

    @Override
    public void changePassword(Employee employee, String password) {

    }
}
