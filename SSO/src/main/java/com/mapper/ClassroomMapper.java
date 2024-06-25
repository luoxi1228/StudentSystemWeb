package com.mapper;

import com.pojo.classroom;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClassroomMapper {
    /**
     * 添加用户
     * @param classroom
     */
    @Insert("insert into classroom values(#{c_id},#{t_id},#{co_id},#{c_room},#{s_num},#{c_time})")
    void init(classroom classroom);

    /**
     * 添加班级
     */
    @Insert("insert into classroom values(#{c_id},#{t_id},#{co_id},#{c_room},#{s_num},#{c_time})")
    void add(classroom classroom);

    /**
     * 清空表
     */
    @Delete("delete from classroom")
    void delete();

    /**
     * 根据课程id查班级id
     */
    @Select("select c_id from classroom where co_id=#{co_id}")
    List<String> findClassId(@Param("co_id") String co_id);

    /**
     * 根据班级id查班级信息
     */
    @Select("select * from classroom where c_id=#{c_id}")
    classroom findClass(@Param("c_id")String c_id);

    /**
     * 更新班级人数
     */
    @Update("UPDATE classroom SET s_num=#{s_num} WHERE c_id=#{c_id}")
    void updateNum(@Param("s_num") int s_num,@Param("c_id") String c_id);

    /**
     * 查询所有班级
     */
    @Select("select * from classroom")
    List<classroom>selectAll();

    /**
     * 根据课程id查询班级
     */
    @Select("select * from classroom where co_id=#{co_id}")
    List<classroom>selectByCourse(@Param("co_id") String co_id);

    /**
     * 根据老师id得到班级
     */
    @Select("select * from classroom where t_id=#{t_id}")
    List<classroom>selectByTea(@Param("t_id")String t_id);

}
