package com.service;

import com.mapper.StuMapper;
import com.mapper.TeaMapper;
import com.mapper.UserMapper;
import com.pojo.*;
import com.pojo.Rank.totalRank;
import com.util.DataGenerate;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public class StuService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void initStudent(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        for (int i = 0; i < DataGenerate.ALLstudents.size(); i++) {
            mapper.init(DataGenerate.ALLstudents.get(i));
            System.out.println(DataGenerate.ALLstudents.get(i));
        }
        sqlSession.commit();
        sqlSession.close();

    }

    public void initGrade(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        for (student alLstudent : DataGenerate.ALLstudents) {
            int s_grade = 0;
            for (grade grade : DataGenerate.ALLGrade) {
                if (grade.getS_id().equals(alLstudent.getS_id())) {
                    s_grade += grade.getFinalGrade();
                }
            }
            //System.out.println("学生："+alLstudent.getS_id()+"成绩："+s_grade);
            mapper.updateGrade(s_grade,alLstudent.getS_id());
        }
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteStu(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        mapper.delete();
        sqlSession.commit();
        sqlSession.close();
    }

    public student login(String s_id,String s_password){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        //4. 调用方法
        student stu=mapper.select(s_id,s_password);
        //释放资源
        sqlSession.close();

        return stu;
    }

    //查询所有学生
    public List<student>selectAll(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        //4. 调用方法
        List<student> stu=mapper.selectALL();
        sqlSession.close();
        return stu;
    }

    //查询排名
    public totalRank findRank(String s_id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        totalRank totalrank=mapper.findRank(s_id);
        sqlSession.close();
        return totalrank;
    }
    //根据学号查询学生
    public student selectById(String s_id){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        student stu=mapper.selectById(s_id);
        sqlSession.close();
        return stu;
    }

    //更新总成绩
    public void updateAllGrade(String s_id,int grade){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        mapper.updateGrade(grade,s_id);
        sqlSession.commit();
        sqlSession.close();
    }

    //添加学生
    public void addStu(student stu){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);
        mapper.addStu(stu);
        sqlSession.commit();
        sqlSession.close();
    }

}
