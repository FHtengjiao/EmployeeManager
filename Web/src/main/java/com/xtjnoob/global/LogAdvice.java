package com.xtjnoob.global;

import com.xtjnoob.entity.Employee;
import com.xtjnoob.entity.Log;
import com.xtjnoob.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LogAdvice {

    @Autowired
    private LogService logService;

    private Log dealLogInfo(JoinPoint joinPoint) {
        String module = joinPoint.getTarget().getClass().getSimpleName();
        String operation = joinPoint.getSignature().getName();

        HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
        Employee employee = (Employee)request.getSession().getAttribute("USER");
        String account  = employee.getAccount();

        Log log = new Log();
        log.setModule(module);
        log.setOperation(operation);
        log.setOperator(account);

        return log;
    }

    @AfterReturning(pointcut = "execution(* com.xtjnoob.controller.DepartmentController.*(..)) || execution(* com.xtjnoob.controller.SelfController.changePassword(..))" +
            " || execution(* com.xtjnoob.controller.EmpolyeeController.*(..)) && !execution(* com.xtjnoob.controller.*.to*(..)))")
    public void operationLog(JoinPoint joinPoint) {
        Log log = dealLogInfo(joinPoint);
        log.setResult("success");
        logService.insertOperationLog(log);
    }

    @AfterThrowing(throwing = "e", pointcut = "execution(* com.xtjnoob.controller.*.*(..)) && !execution(* com.xtjnoob.controller.SelfController.*(..))")
    public void systemLog(JoinPoint joinPoint, Throwable e) {
        Log log = dealLogInfo(joinPoint);
        log.setResult(e.getClass().getSimpleName());
        logService.insertSystemLog(log);
    }
}
