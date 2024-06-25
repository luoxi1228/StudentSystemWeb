package com.service;

import com.mapper.AdminMapper;
import com.mapper.ClassroomMapper;
import com.pojo.admin;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AdminService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public admin login(String account ,String password){
        SqlSession sqlSession = factory.openSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        admin admin=mapper.selectAdmin(account,password);
        sqlSession.close();
        return admin;
    }
}
