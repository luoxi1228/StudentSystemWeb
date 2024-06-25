package com.mapper;

import com.pojo.grade;
import com.pojo.viewGrade.*;
import org.apache.ibatis.annotations.*;
import org.w3c.dom.ls.LSInput;

import java.util.List;

public interface GradeMapper {
    /**
     * 添加用户
     * @param grade
     */
    @Insert("insert into grade values(#{s_id},#{c_id},#{midGrade},#{labGrade},#{examGrade},#{usualGrade},#{finalGrade})")
    void init(grade grade);

    /**
     * 清空表
     */
    @Delete("delete from grade")
    void delete();

    /**
     * 查询学生所选课程的成绩
     */
    @Select("SELECT s_id,classroom.c_id,t_id,course.co_id,co_name,midGrade,labGrade,examGrade,usualGrade,finalGrade,c_room,c_time\n" +
            "FROM grade JOIN classroom ON grade.c_id = classroom.c_id JOIN course ON classroom.co_id = course.co_id WHERE grade.s_id =#{s_id}")
    List<courseGrade> personGrade(@Param("s_id") String s_id);

    /**
     * 查询班级所有人的成绩
     */
    @Select("SELECT grade.s_id,s_name,t.t_id,t.t_name,classroom.c_id,classroom.c_room,course.co_id,co_name,finalGrade,c_time\n" +
            "FROM grade JOIN classroom ON grade.c_id = classroom.c_id JOIN course ON classroom.co_id = course.co_id\n" +
            "    JOIN student s on grade.s_id = s.s_id  join teacher t on classroom.t_id = t.t_id WHERE grade.c_id = #{c_id}")
    List<classGrade>classGrades(@Param("c_id")String c_id);

    /**
     * 根据班级id查询学生
     */
    @Select("select * from grade where c_id=#{c_id}")
    List<grade> findStu(@Param("c_id")String c_id);

    /**
     * 查询各班人数
     */
    @Select("SELECT COUNT(*) FROM grade WHERE c_id=#{c_id}")
    int stuNum(@Param("c_id") String c_id);

    /**
     * 添加信息
     */
    @Insert("insert into grade (s_id, c_id, midGrade, labGrade, examGrade, usualGrade, finalGrade) " +
            "values (#{s_id}, #{c_id}, 0, 0, 0, 0, 0)")
    void add(@Param("s_id") String s_id, @Param("c_id") String c_id);

    /**
     * 更新数据
     */
    @Update("UPDATE grade SET midGrade = #{midGrade}, labGrade = #{labGrade}, examGrade = #{examGrade}, usualGrade = #{usualGrade}, finalGrade = #{finalGrade} " +
            "WHERE s_id = #{s_id} AND c_id = #{c_id}")
    void updateGrade(@Param("s_id") String s_id,
                     @Param("c_id") String c_id,
                     @Param("midGrade") int midGrade,
                     @Param("labGrade") int labGrade,
                     @Param("examGrade") int examGrade,
                     @Param("usualGrade") int usualGrade,
                     @Param("finalGrade") int finalGrade);

    /**
     * 查询所有成绩
     */
    @Select("select * from grade")
    List<grade>selectAll();
}
