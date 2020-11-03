package com.lc.service;
import com.lc.entity.Order;


import java.util.List;


public interface OrderService {

    void save(Order order);

    List<Order> findByUid(int uid, int start, int row);

    int getTotalcountsByUid(int uid);

    List<Order> findByState(int start, int row);

    int getState0Count();

    void updateState(int id);
}
