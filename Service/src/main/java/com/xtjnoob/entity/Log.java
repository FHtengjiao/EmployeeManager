package com.xtjnoob.entity;

import java.util.Date;

public class Log {
    private Date operateTime;
    private String type;
    private String operator;
    private String module;
    private String operation;
    private String result;

    public Log() {
    }

    public Log(Date operateTime, String type, String operator, String module, String operation, String result) {
        this.operateTime = operateTime;
        this.type = type;
        this.operator = operator;
        this.module = module;
        this.operation = operation;
        this.result = result;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
