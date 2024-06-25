package com.service;

import com.mapper.CourseMapper;
import com.mapper.GradeMapper;
import com.pojo.grade;
import com.pojo.viewGrade.classGrade;
import com.pojo.viewGrade.courseGrade;
import com.util.DataGenerate;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.w3c.dom.ls.LSInput;

import java.util.GregorianCalendar;
import java.util.List;

public class GradeService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void initGrade() {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);

        for (int i = 0; i < DataGenerate.ALLGrade.size(); i++) {
            mapper.init(DataGenerate.ALLGrade.get(i));
            System.out.println(DataGenerate.ALLGrade.get(i));
        }
        sqlSession.commit();
        sqlSession.close();

    }

    public void deleteGrade() {
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
        mapper.delete();
        sqlSession.commit();
        sqlSession.close();

    }

    public List<courseGrade> personGrade(String s_id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
        List<courseGrade>  grades=mapper.personGrade(s_id);
/*        for (courseGrade grade : grades) {
            System.out.println(grade);
        }*/
        sqlSession.commit();
        sqlSession.close();
        return grades;
    }

    public List<classGrade> classGrades(String c_id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
        List<classGrade>  grades=mapper.classGrades(c_id);
        sqlSession.commit();
        sqlSession.close();
        return grades;
    }

    //根据班级查询学生
    public List<grade>findStu(String c_id){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
        List<grade>grades=mapper.findStu(c_id);
        sqlSession.commit();
        sqlSession.close();
        return grades;
    }

    //查询班级人数
    public int stuNum(String c_id){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
        int num=mapper.stuNum(c_id);
        sqlSession.close();
        return num;
    }

    //添加信息
    public void addGrade(String s_id,String c_id){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
        mapper.add(s_id,c_id);
        sqlSession.commit();
        sqlSession.close();
    }

    //更新数据
    public void updateGrade(grade gd){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
        String s_id=gd.getS_id();
        String c_id=gd.getC_id();
        int midGrade=gd.getMidGrade();
        int labGrade=gd.getLabGrade();
        int examGrade=gd.getExamGrade();
        int usualGrade=gd.getUsualGrade();
        int finalGrade=gd.getFinalGrade();
        mapper.updateGrade(s_id,c_id,midGrade,labGrade,examGrade,usualGrade,finalGrade);

        sqlSession.commit();
        sqlSession.close();
    }

    //查询所有grade
    public List<grade> selectAll()
    {
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        GradeMapper mapper = sqlSession.getMapper(GradeMapper.class);
        List<grade>grades=mapper.selectAll();
        sqlSession.close();
        return grades;
    }
}
