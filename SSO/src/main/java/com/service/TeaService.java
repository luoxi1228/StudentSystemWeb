package com.service;

import com.mapper.StuMapper;
import com.mapper.TeaMapper;
import com.pojo.student;
import com.pojo.teacher;
import com.util.DataGenerate;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.time.temporal.TemporalAccessor;
import java.util.List;

public class TeaService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void initTeacher(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        TeaMapper mapper = sqlSession.getMapper(TeaMapper.class);

        for (int i = 0; i < DataGenerate.ALLteachers.size(); i++) {
            mapper.init(DataGenerate.ALLteachers.get(i));
            System.out.println(DataGenerate.ALLteachers.get(i));
        }
        sqlSession.commit();
        sqlSession.close();
    }
    public void deleteTeacher(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        TeaMapper mapper = sqlSession.getMapper(TeaMapper.class);
        mapper.delete();
        sqlSession.commit();
        sqlSession.close();
    }

    //根据id查询
    public teacher selectById(String t_id){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        TeaMapper mapper = sqlSession.getMapper(TeaMapper.class);
        teacher tea=mapper.selectById(t_id);
        sqlSession.close();
        return tea;
    }

    //根据账号密码登录
    public teacher login(String t_id, String t_password){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        TeaMapper mapper = sqlSession.getMapper(TeaMapper.class);
        //4. 调用方法
        teacher stu=mapper.select(t_id,t_password);
        //释放资源
        sqlSession.close();

        return stu;
    }

    //添加老师
    public void addTea(teacher tea){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        TeaMapper mapper = sqlSession.getMapper(TeaMapper.class);
        mapper.addTea(tea);
        sqlSession.commit();
        sqlSession.close();
    }

    //查询所有
    public List<teacher> selectAll(){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        TeaMapper mapper = sqlSession.getMapper(TeaMapper.class);
        List<teacher> teachers=mapper.selectAll();
        sqlSession.close();
        return teachers;
    }
}
