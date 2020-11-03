package com.lc.dao;

import com.lc.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TypeDao {
//    根据id查询菜品的类别
    public Type findById(Integer id);
//    查询总菜品的类别
    public List<Type> findAll();
}
