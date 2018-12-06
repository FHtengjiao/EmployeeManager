package com.xtjnoob.service;

import com.xtjnoob.entity.Employee;

public interface SelfService {
    Employee login(String account, String password);

    boolean changePassword(Integer id, String oldPassword, String newPassword);
}
