package com.mapper;

import com.mysql.cj.util.DnsSrv;
import com.pojo.Rank.totalRank;
import com.pojo.User;
import com.pojo.student;
import com.service.GradeService;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StuMapper {
    /**
     * 添加用户
     * @param stu
     */
    @Insert("insert into student values(#{s_id},#{s_name},#{s_gender},#{s_age},#{s_faculty},#{s_grade},#{s_password})")
    void init(student stu);

    /**
     * 查询所有学生
     */
    @Select("select * from student")
    List<student> selectALL();


    /**
     * 改成绩
     */
    @Update("update student SET s_grade = #{s_grade} where s_id=#{s_id}")
    void updateGrade(@Param("s_grade") int s_grade, @Param("s_id") String s_id);

    /**
     * 清空表
     */
    @Delete("delete from student")
    void delete();

    /**
     * 根据学号，密码查询
     */
    @Select("select * from student where s_id = #{s_id} and s_password = #{s_password}")
    student select(@Param("s_id") String s_username, @Param("s_password")  String s_password);

    /**
     * 查总成绩排名
     */
    @Select("SELECT s_id, s_name, s_grade, total_rank\n" +
            "FROM (\n" +
            "         SELECT s_id, s_name, s_grade,\n" +
            "                DENSE_RANK() OVER (ORDER BY s_grade DESC) AS total_rank\n" +
            "         FROM student\n" +
            "     ) AS ranked_students\n" +
            "WHERE s_id = #{s_id}")
    totalRank findRank(@Param("s_id")String s_id);

    /**
     * 根据学号查学生
     */
    @Select("select * from student where s_id=#{s_id}")
    student selectById(@Param("s_id") String s_id);

    /**
     * 添加数据
     */
    @Insert("insert into student values(#{s_id},#{s_name},#{s_gender},#{s_age},#{s_faculty},#{s_grade},#{s_password})")
    void addStu(student stu);

}
