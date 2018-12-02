package com.xtjnoob.service;

import com.xtjnoob.entity.Department;

import java.util.List;

public interface DepartmentService {
    void add(Department department);

    void remove(Integer id);

    void edit(Department department);

    Department getOne(Integer id);

    List<Department> getAll();
}
