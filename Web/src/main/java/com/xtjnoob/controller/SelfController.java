package com.xtjnoob.controller;

import com.xtjnoob.entity.Employee;
import com.xtjnoob.global.StringUtils;
import com.xtjnoob.service.SelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SelfController {

    @Autowired
    private SelfService selfService;

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/login.jsp").forward(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");

        if (StringUtils.isNotEmpty(account) && StringUtils.isNotEmpty(password)) {
            Employee employee = selfService.login(account, password);
            if (employee == null) {
                response.sendRedirect("/toLogin.do");
            } else {
                request.getSession().setAttribute("USER", employee);
                response.sendRedirect("/main.do");
            }
        } else {
            response.sendRedirect("/toLogin.do");
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("USER");
        response.sendRedirect("/toLogin.do");
    }

    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
    }

    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/change_password.jsp").forward(request, response);
    }

    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        if (StringUtils.isNotEmpty(id) && StringUtils.isNotEmpty(password) && StringUtils.isNotEmpty(newPassword)) {
            boolean flag = selfService.changePassword(Integer.parseInt(id), password, newPassword);
            if (flag) {
                response.getWriter().print("<script>window.parent.location='logout.do'</script>");
            } else {
                request.setAttribute("msg","修改失败");
                request.getRequestDispatcher("/toChangePassword.do").forward(request, response);
            }
        } else {
            response.sendRedirect("/pages/user_detail.jsp");
        }
    }
}
