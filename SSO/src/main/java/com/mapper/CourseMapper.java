package com.mapper;

import com.pojo.course;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.SplittableRandom;

public interface CourseMapper {
    /**
     * 添加用户
     * @param course
     */
    @Insert("insert into course values(#{co_id},#{co_name})")
    void init(course course);
    /**
     * 清空表
     */
    @Delete("delete from course")
    void delete();

    /**
     * 根据id查询课程名称
     */
    @Select("select co_name from course where co_id=#{co_id}")
    String findName(@Param("co_id") String co_id);

    /**
     *查询所有课程
     */
    @Select("select *from course")
    List<course> selectAll();

    /**
     * 根据id查询
     * @param co_id
     * @return
     */
    @Select("select * from course where co_id=#{co_id}")
    course selectById(@Param("co_id")String co_id);

    /**
     * 根据名称查询
     * @param co_name
     * @return
     */
    @Select("select * from course where co_name=#{co_name}")
    course selectByName(@Param("co_name")String co_name);

    /**
     * 添加课程
     */
    @Insert("insert into course values(#{co_id},#{co_name})")
    void add(course course);
}
