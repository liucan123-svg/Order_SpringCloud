package com.lc.service;

import com.lc.dao.OrderDao;
import com.lc.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public void save(Order order) {
        orderDao.save(order);
    }

    @Override
    public List<Order> findByUid(int uid, int start, int row) {
        return orderDao.findByUid(uid, start, row);
    }

    @Override
    public int getTotalcountsByUid(int uid) {
        return orderDao.getTotalcountsByUid(uid);
    }

    @Override
    public List<Order> findByState(int start, int row) {
        return orderDao.findByState(start, row);
    }

    @Override
    public int getState0Count() {
        return orderDao.getState0Count();
    }

    @Override
    public void updateState(int id) {
        orderDao.updateState(id);
    }

}
