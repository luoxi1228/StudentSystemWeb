package com.mapper;

import com.pojo.admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper {
    /**
     * 查询用户
     */
    @Select("select * from admin where account=#{account} and password=#{password}")
    public admin selectAdmin(@Param("account") String account, @Param("password") String password);
}
