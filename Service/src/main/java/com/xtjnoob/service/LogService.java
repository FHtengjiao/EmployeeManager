package com.xtjnoob.service;

import com.xtjnoob.entity.Log;

import java.util.List;

public interface LogService {
    void insertSystemLog(Log log);

    void insertLoginLog(Log log);

    void insertOperationLog(Log log);

    List<Log> getSystemLog();

    List<Log> getLoginLog();

    List<Log> getOperationLog();
}
