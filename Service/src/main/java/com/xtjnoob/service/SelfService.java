package com.xtjnoob.service;

import com.xtjnoob.entity.Employee;

public interface SelfService {
    void login(String account);

    void changePassword(Employee employee, String password);
}
