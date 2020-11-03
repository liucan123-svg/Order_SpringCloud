package com.lc.controller;

import com.lc.entity.Order;
import com.lc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;



@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Value("${server.port}")
    private String port;

    @GetMapping("getPort")
    public String getPort(){
        return "port:"+this.port;
    }

    @GetMapping("findByUid/{uid}/{start}/{row}")
    public List<Order> findByUid(@PathVariable("uid") int uid, @PathVariable("start") int start, @PathVariable("row") int row){
        return orderService.findByUid(uid, start, row);
    }

    @PostMapping("save")
    public void save(@RequestBody Order order){
        order.setDate(new Date());
        orderService.save(order);
    }

    @GetMapping("getTotalcountsByUid/{uid}")
    public int getTotalcountsByUid(@PathVariable("uid") int uid){
        return orderService.getTotalcountsByUid(uid);
    }

    @GetMapping("findByState/{start}/{row}")
    List<Order> findByState(@PathVariable("start") int start, @PathVariable("row") int row){
        List<Order> orders = orderService.findByState(start, row);
//        for (Order order : orders) {
//            System.out.println(order);
//        }
        return orders;
    }

    @GetMapping("getState0Count")
    int getState0Count(){
        return orderService.getState0Count();
    }

    @GetMapping("updateState/{id}")
    void updateState(@PathVariable("id") int id){
        orderService.updateState(id);
    }
}
