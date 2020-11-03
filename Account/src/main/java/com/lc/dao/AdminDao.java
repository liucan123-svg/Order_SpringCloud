package com.lc.dao;

import com.lc.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



@Repository
public interface AdminDao {
//        根据管理员username，password判断是否登录成功
    @Select("select * from t_admin where username=#{username} and password=#{password}")
    Admin login(@Param("username") String username, @Param("password") String password);
}
