package com.service;

import com.mapper.ClassroomMapper;
import com.pojo.classroom;
import com.util.DataGenerate;
import com.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ClassroomService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public void initCourse(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ClassroomMapper mapper = sqlSession.getMapper(ClassroomMapper.class);

        for (int i = 0; i < DataGenerate.ALLclassrooms.size(); i++) {
            mapper.init(DataGenerate.ALLclassrooms.get(i));
            System.out.println(DataGenerate.ALLclassrooms.get(i));
        }
        sqlSession.commit();
        sqlSession.close();

    }
    public void deleteCourse(){
        //2. 获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ClassroomMapper mapper = sqlSession.getMapper(ClassroomMapper.class);
        mapper.delete();
        sqlSession.commit();
        sqlSession.close();

    }

    //根据课程id查询班级id
    public List<String>findClassId(String co_id){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ClassroomMapper mapper = sqlSession.getMapper(ClassroomMapper.class);
        List<String>classIds=mapper.findClassId(co_id);
        sqlSession.close();
        return classIds;
    }

    //根据班级id查询班级信息
    public classroom findClass(String c_id){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ClassroomMapper mapper = sqlSession.getMapper(ClassroomMapper.class);
        classroom classroom=mapper.findClass(c_id);
        sqlSession.close();
        return classroom;
    }

    //更新班级人数
    public void updateNum(int num,String id){
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ClassroomMapper mapper = sqlSession.getMapper(ClassroomMapper.class);
        mapper.updateNum(num,id);
        sqlSession.commit();
        sqlSession.close();
    }

    //查询所有班级
    public List<classroom> selectAll()
    {
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ClassroomMapper mapper = sqlSession.getMapper(ClassroomMapper.class);
        List<classroom> classrooms=mapper.selectAll();
        sqlSession.close();
        return classrooms;
    }

    //根据课程id查询班级
    public List<classroom> selectByCourse(String co_id)
    {
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ClassroomMapper mapper = sqlSession.getMapper(ClassroomMapper.class);
        List<classroom> classrooms=mapper.selectByCourse(co_id);
        sqlSession.close();
        return classrooms;
    }

    //根据老师id查询班级
    public List<classroom> selectByTea(String t_id)
    {
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ClassroomMapper mapper = sqlSession.getMapper(ClassroomMapper.class);
        List<classroom> classrooms=mapper.selectByTea(t_id);
        sqlSession.close();
        return classrooms;
    }

    //添加班级
    public void addClassroom(classroom newClassroom) {
        SqlSession sqlSession = factory.openSession();
        //3. 获取UserMapper
        ClassroomMapper mapper = sqlSession.getMapper(ClassroomMapper.class);
        mapper.add(newClassroom);
        sqlSession.commit();
        sqlSession.close();
    }
}
