package com.xtjnoob.service;

import com.xtjnoob.entity.Employee;

public interface SelfService {
    Employee login(String account, String password);

    void changePassword(Integer id, String password);
}
