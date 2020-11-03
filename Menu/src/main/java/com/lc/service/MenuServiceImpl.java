package com.lc.service;

import com.lc.dao.MenuDao;
import com.lc.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional //将事务开启
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuDao menuDao;

    @Override
    public List<Menu> findAll(int start, int row) {
        return menuDao.findAll(start, row);
    }

    @Override
    public Integer count() {
        return menuDao.count();
    }

    @Override
    public Menu findById(Integer id) {
        return menuDao.findById(id);
    }

    @Override
    public void save(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    public void update(Menu menu) {
        menuDao.update(menu);
    }

    @Override
    public void deleteById(Integer id) {
        menuDao.deleteById(id);
    }
}
