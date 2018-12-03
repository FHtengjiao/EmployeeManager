package com.xtjnoob.controller;

import com.sun.deploy.net.HttpResponse;
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
        request.getRequestDispatcher("/pages/department_list.jsp").forward(request, response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/pages/department_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String location  = request.getParameter("location");
        if (StringUtils.isNotEmpty(name)) {
            departmentService.add(new Department(name, location));
        }
        response.sendRedirect("/department/list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if ((StringUtils.isNotEmpty(id))) {
            Department department = departmentService.getOne(Integer.parseInt(id));
            request.setAttribute("DEPARTMENT", department);
            request.getRequestDispatcher("/pages/department_edit.jsp").forward(request, response);
        } else {
            response.sendRedirect("/department/list.do");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty("name") && StringUtils.isNotEmpty("location")) {
            departmentService.edit(new Department(Integer.parseInt(id), name, location));
        }
        response.sendRedirect("/department/list.do");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (StringUtils.isNotEmpty(id)) {
            departmentService.remove(Integer.parseInt(id));
        }
        response.sendRedirect("/department/list.do");
    }
}
