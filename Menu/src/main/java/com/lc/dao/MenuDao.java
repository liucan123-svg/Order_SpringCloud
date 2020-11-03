package com.lc.dao;

import com.lc.entity.Menu;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface MenuDao {

//   根据点击的多少条为一页的参数，行数参数查找菜品的记录
    List<Menu> findAll(@Param("start") int start, @Param("row") int row);

//    菜品的总数
    Integer count();

//  根据id查询菜品
    Menu findById(Integer id);

//    添加菜品
    void save(Menu menu);

//    修改菜品
    void update(Menu menu);

//   根据id删除菜品
    void deleteById(Integer id);

}
