package com.lc.service;

import com.lc.entity.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface MenuService {

    List<Menu> findAll(@Param("start") int start, @Param("row") int row);

    Integer count();

    Menu findById(Integer id);

    void save(Menu menu);

    void update(Menu menu);

    void deleteById(Integer id);
}
