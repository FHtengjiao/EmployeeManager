package com.xtjnoob.global;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "dispatcherServlet", urlPatterns = "*.do")
public class DispatcherServlet extends HttpServlet {

    private ApplicationContext applicationContext;

    @Override
    public void init() throws ServletException {
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();

        String beanName = null;
        String methodName = null;

        String beanAndMethod = servletPath.substring(1, servletPath.indexOf(".do"));
        if (beanAndMethod.contains("/")) {
            beanName = beanAndMethod.split("/")[0] + "Controller";
            methodName = beanAndMethod.split("/")[1];
        } else {
            beanName = "selfController";
            methodName = beanAndMethod;
        }

        Object bean = applicationContext.getBean(beanName);
        try {
            Method method = bean.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(bean, request, response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
