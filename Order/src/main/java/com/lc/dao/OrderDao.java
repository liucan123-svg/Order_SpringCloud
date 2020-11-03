package com.lc.dao;


import com.lc.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderDao {
//    新增订单
    @Insert("insert into t_order(uid, mid, date, state) values(#{user.id}, #{menu.id}, #{date}, 0)")
    void save(Order order);
//    根据用户id-uid查询订单
//    @Select("select id, uid, mid, date, state from t_order limit #{start}, #{row}")
    List<Order> findByUid(@Param("uid") int uid, @Param("start") int start, @Param("row") int row);
//    根据用户id-uid查询该用户所有订单
    @Select("select count(1) from t_order where uid=#{uid}")
    int getTotalcountsByUid(int uid);
//根据订单状态查询订单
    List<Order> findByState(@Param("start") int start, @Param("row") int row);
//根据订单状态为0查询订单 0为未派送 1为已派送
    @Select("select count(1) from t_order where state=0")
    int getState0Count();
//根据id修改订单状态 (0-1 从未派送-已派送)
    @Update("update t_order set state=1 where id=#{id}")
    void updateState(int id);

}
