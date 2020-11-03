package com.lc.feign;

import com.lc.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@FeignClient("order")
public interface OrderFeign {


    @PostMapping("/order/save")
    public void save(Order order);

    @GetMapping("/order/findByUid/{uid}/{start}/{row}")
    public List<Order> findByUid(@PathVariable("uid") int uid, @PathVariable("start") int start, @PathVariable("row") int row);


    @GetMapping("/order/getTotalcountsByUid/{uid}")
    public int getTotalcountsByUid(@PathVariable("uid") int uid);

    @GetMapping("/order/findByState/{start}/{row}")
    List<Order> findByState(@PathVariable("start") int start, @PathVariable("row") int row);

    @GetMapping("/order/getState0Count")
    int getState0Count();

    @GetMapping("/order/updateState/{id}")
    void updateState(@PathVariable("id") int id);
}
