package com.lc.service;

import com.lc.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface UserService {

    List<User> findAll(@Param("start") int start, @Param("row") int row);

    User findById(int id);

    int count();

    void save(User user);

    void update(User user);

    void deleteById(int id);
}
