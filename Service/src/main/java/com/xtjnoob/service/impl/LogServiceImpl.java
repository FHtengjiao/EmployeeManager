package com.xtjnoob.service.impl;

import com.xtjnoob.dao.LogDao;
import com.xtjnoob.entity.Log;
import com.xtjnoob.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public void insertSystemLog(Log log) {
        log.setOperateTime(new Date());
        log.setType("system");
        logDao.insert(log);
    }

    @Override
    public void insertLoginLog(Log log) {
        log.setOperateTime(new Date());
        log.setType("login");
        logDao.insert(log);
    }

    @Override
    public void insertOperationLog(Log log) {
        log.setOperateTime(new Date());
        log.setType("operation");
        logDao.insert(log);
    }

    @Override
    public List<Log> getSystemLog() {
        return logDao.selectLogByType("system");
    }

    @Override
    public List<Log> getLoginLog() {
        return logDao.selectLogByType("login");
    }

    @Override
    public List<Log> getOperationLog() {
        return logDao.selectLogByType("operation");
    }
}
