package com.service;

import com.mapper.CourseMapper;
import com.mapper.StuMapper;
import com.pojo.course;
import com.util.DataGenerate;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CourseService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void initCourse(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);

        for (int i = 0; i < DataGenerate.ALLcourse.size(); i++) {
            mapper.init(DataGenerate.ALLcourse.get(i));
            System.out.println(DataGenerate.ALLcourse.get(i));
        }
        sqlSession.commit();
        sqlSession.close();

    }
    public void deleteCourse(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.delete();
        sqlSession.commit();
        sqlSession.close();
    }

    //根据id查课程名
    public String findName(String co_id){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        String co_name=mapper.findName(co_id);
        sqlSession.close();
        return co_name;
    }

    //查询所有课程
    public List<course> selectAll()
    {
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        List<course> courses=mapper.selectAll();
        sqlSession.close();
        return courses;
    }
    //根据id查询
    public course selectById(String co_id){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        course co=mapper.selectById(co_id);
        sqlSession.close();
        return co;
    }
    //根据名称查询
    public course selectByName(String co_name){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        course co=mapper.selectByName(co_name);
        sqlSession.close();
        return co;
    }

    //添加课程
    public void addCourse(course course) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        CourseMapper mapper = sqlSession.getMapper(CourseMapper.class);
        mapper.add(course);
        sqlSession.commit();
        sqlSession.close();
    }
}
