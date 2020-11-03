package com.lc.dao;

import com.lc.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDao {
//      根据用户 username，password判断是否登录成功
    @Select("select * from t_user where username=#{username} and password=#{password}")
    User login(@Param("username") String username, @Param("password") String password);
}
