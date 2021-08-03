package com.cnc.my.mybatis.service;

import org.apache.ibatis.session.SqlSession;

public interface IBatisService {
    void setSession(SqlSession session);
}
