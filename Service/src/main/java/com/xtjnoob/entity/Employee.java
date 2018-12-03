package com.xtjnoob.entity;

import java.util.Date;

public class Employee {
    private Integer id;
    private String account;
    private String password;
    private String status;

    private Integer departmentId;
    private String name;
    private String gender;
    private String idCard;
    private Date enterTime;
    private Date leaveTime;
    private Date birthday;
    private String mark;

    private Department department;

    public Employee(String account, String password, String status, int i, String name, String gender, String idCard, Date date, String mark) {
    }

    public Employee(Integer id, String account, String password, String status, Integer departmentId, String name, String gender, String idCard, Date enterTime, Date leaveTime, Date birthday, String mark) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.status = status;
        this.departmentId = departmentId;
        this.name = name;
        this.gender = gender;
        this.idCard = idCard;
        this.enterTime = enterTime;
        this.leaveTime = leaveTime;
        this.birthday = birthday;
        this.mark = mark;
    }

    public Employee(Integer id, String account, String password, String status, Integer departmentId, String name, String gender, String idCard, Date birthday, String mark) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.status = status;
        this.departmentId = departmentId;
        this.name = name;
        this.gender = gender;
        this.idCard = idCard;
        this.birthday = birthday;
        this.mark = mark;
    }

    public Employee(String account, String password, String status, Integer departmentId, String name, String gender, String idCard, Date enterTime, Date leaveTime, Date birthday, String mark) {
        this.account = account;
        this.password = password;
        this.status = status;
        this.departmentId = departmentId;
        this.name = name;
        this.gender = gender;
        this.idCard = idCard;
        this.enterTime = enterTime;
        this.leaveTime = leaveTime;
        this.birthday = birthday;
        this.mark = mark;
    }

    public Employee(String status, Integer departmentId, String name, String gender, String idCard, Date leaveTime, Date birthday, String mark) {
        this.status = status;
        this.departmentId = departmentId;
        this.name = name;
        this.gender = gender;
        this.idCard = idCard;
        this.leaveTime = leaveTime;
        this.birthday = birthday;
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
