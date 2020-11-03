package com.lc.dao;

import com.lc.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface UserDao {
//查询所有用户
    @Select("select * from t_user limit #{start}, #{row}")
    List<User> findAll(@Param("start") int start, @Param("row") int row);
//根据id查询用户
    @Select("select * from t_user where id=#{id}")
    User findById(int id);
//查询用户的总数
    @Select("select count(*) from t_user")
    int count();
//新增用户
    @Insert("insert into t_user(username, password, nickname, gender, telephone, registerdate, address) " +
            "values(#{username}, #{password}, #{nickname}, #{gender}, #{telephone}, #{registerdate}, #{address})")
    void save(User user);
//修改用户
    @Update("update t_user set username=#{username}, password=#{password}, gender=#{gender}, telephone=#{telephone}," +
            "registerdate=#{registerdate}, address=#{address} where id=#{id}")
    void update(User user);
//删除用户
    @Delete("delete from t_user where id=#{id}")
    void deleteById(int id);

}
