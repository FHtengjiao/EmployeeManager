package com.xtjnoob.controller;

import com.xtjnoob.entity.Department;
import com.xtjnoob.entity.Employee;
import com.xtjnoob.global.StringUtils;
import com.xtjnoob.service.DepartmentService;
import com.xtjnoob.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller("employeeController")
public class EmpolyeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employees = employeeService.getAll();
        request.setAttribute("EMPLOYEES", employees);
        request.getRequestDispatcher("/pages/employee_list.jsp").forward(request, response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Department> departments = departmentService.getAll();
        request.setAttribute("DEPARTMENTS", departments);
        request.getRequestDispatcher("/pages/employee_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String status = request.getParameter("status");
        String departmentId = request.getParameter("department_id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("id_card");
        String birthday = request.getParameter("birthday");
        String mark = request.getParameter("mark");

        if (StringUtils.isNotEmpty(account) && StringUtils.isNotEmpty(status)
                && StringUtils.isNotEmpty(departmentId) && StringUtils.isNotEmpty(name)) {
            try {
                employeeService.add(new Employee(account, password, status, Integer.parseInt(departmentId), name, gender, idCard, StringUtils.string2Date(birthday), mark));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("/pages/employee_list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Employee employee = employeeService.getOne(Integer.parseInt(id));
        List<Department> departments = departmentService.getAll();
        request.setAttribute("DEPARTMENTS", departments);
        request.setAttribute("EMPLOYEE", employee);
        request.getRequestDispatcher("/pages/employee_edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        String departmentId = request.getParameter("department_id");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("id_card");
        String leaveTime = request.getParameter("leave_time");
        String birthday = request.getParameter("birthday");
        String mark = request.getParameter("mark");

        try {
            employeeService.edit(new Employee(status, Integer.parseInt(departmentId), name, gender, idCard, StringUtils.string2Date(leaveTime), StringUtils.string2Date(birthday), mark));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/employee/list.do");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =  request.getParameter("id");

        if (StringUtils.isNotEmpty(id)) {
            employeeService.remove(Integer.parseInt(id));
        }

        response.sendRedirect("/employee/list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =  request.getParameter("id");
        Employee employee = employeeService.getOne(Integer.parseInt(id));
        request.setAttribute("EMPLOYEE", employee);
        request.getRequestDispatcher("/pages/employee_detail.jsp").forward(request, response);
    }
}
