package com.lc.controller;

import com.lc.entity.*;
import com.lc.feign.OrderFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/client/order")
@Api(value = "订单模块|Order")
public class OrderController {


    @Autowired
    OrderFeign orderFeign;

    /*根据用户id查询订单*/
    @GetMapping("/findByUid")
    @ResponseBody
    @ApiOperation(value="分页查询订单",notes = "根据用户id查询订单")
    public AllVO findAllByUid(@RequestParam("page")int page, @RequestParam("limit")int limit, HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Order> orders = orderFeign.findByUid(user.getId(), (page - 1) * limit, limit);
        return new AllVO(0,"",orderFeign.getTotalcountsByUid(user.getId()), orders);
    }

    @PostMapping("save/{mid}")
    @ResponseBody
    @ApiOperation(value="根据菜单id下订单",notes = "根据菜单id下订单")
    public Msg save(@PathVariable("mid")int mid, HttpSession session){
        User user = (User)session.getAttribute("user");
        Order order = new Order();
        order.setUser(user).setMenu(new Menu().setId(mid));
        orderFeign.save(order);
        return Msg.success();
    }

    @GetMapping("findByState")
    @ResponseBody
    @ApiOperation(value="根据订单状态查询订单",notes = "state=0，未发送,state=1,已发送")
    public AllVO findByState(@RequestParam("page")int page, @RequestParam("limit")int limit){
        List<Order> orders = orderFeign.findByState((page-1)*limit, limit);
        return new AllVO(0, "", orderFeign.getState0Count(), orders);
    }

    @GetMapping("updateState/{id}")
    @ResponseBody
    @ApiOperation(value="修改订单状态",notes = "根据用户id修改订单")
    public Msg updateState(@PathVariable("id") int id){
        orderFeign.updateState(id);
        return Msg.success();
    }

}
