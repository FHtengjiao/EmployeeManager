package com.xtjnoob.dao;

import com.xtjnoob.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfDao {

    Employee getEmployeeByAccount(String account);

}
