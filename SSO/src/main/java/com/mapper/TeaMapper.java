package com.mapper;

import com.pojo.student;
import com.pojo.teacher;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeaMapper {
    /**
     * 初始用户
     * @param tea
     */
    @Insert("insert into teacher values(#{t_id},#{t_name},#{t_gender},#{t_age},#{t_faculty},#{t_password})")
    void init(teacher tea);

    /**
     * 清空表
     */
    @Delete("delete from teacher")
    void delete();

    /**
     * 查询所有
     */
    @Select("select *from teacher")
    public List<teacher> selectAll();
    /**
     * 根据id查询
     */
    @Select(" select * from teacher where t_id=#{t_id}")
    teacher selectById(@Param("t_id") String t_id);

    /**
     * 根据账号密码查询
     */
    @Select("select * from teacher where t_id = #{t_id} and t_password = #{t_password}")
    teacher select(@Param("t_id") String t_username, @Param("t_password")  String t_password);

    /**
     * 添加用户
     */
    @Insert("insert into teacher values(#{t_id},#{t_name},#{t_gender},#{t_age},#{t_faculty},#{t_password})")
    void addTea(teacher teacher);
}
