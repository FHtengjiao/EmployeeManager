package com.xtjnoob.dao;

import com.xtjnoob.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDao {
    void insert(Department department);

    void deleteById(Integer id);

    void update(Department department);

    Department getDepartmentById(Integer id);

    List<Department> getAllDepartments();
}
