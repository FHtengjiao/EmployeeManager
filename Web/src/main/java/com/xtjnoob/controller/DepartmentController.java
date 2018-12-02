package com.xtjnoob.controller;

import com.xtjnoob.entity.Department;
import com.xtjnoob.global.StringUtils;
import com.xtjnoob.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> deps = departmentService.getAll();
        request.setAttribute("LIST", deps);
        request.getRequestDispatcher("/department_list.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String location  = request.getParameter("location");
        if (StringUtils.isNotEmpty(name)) {
            departmentService.add(new Department(name, location));
        }
    }

}
