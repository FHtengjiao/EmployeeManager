package com.xtjnoob.dao;

import com.xtjnoob.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDao {
    void insert(Log log);

    List<Log> selectLogByType(String Type);
}
