package com.xtjnoob.service.impl;

import com.xtjnoob.dao.DepartmentDao;
import com.xtjnoob.entity.Department;
import com.xtjnoob.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void remove(Integer id) {
        departmentDao.deleteById(id);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department getOne(Integer id) {
        return departmentDao.getDepartmentById(id);
    }

    public List<Department> getAll() {
        return departmentDao.getAllDepartments();
    }
}
