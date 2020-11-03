package com.lc.controller;

import com.lc.entity.AllVO;
import com.lc.entity.User;
import com.lc.feign.UserFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/client/user")
@Api(value = "用户模块|User")
public class UserController {

    @Autowired
    UserFeign userFeign;


    @GetMapping("findAll")
    @ResponseBody
    @ApiOperation(value="查询所有用户",notes="分页查询所有用户")
    public AllVO findAll(@RequestParam("page") int start, @RequestParam("limit") int row){
        List<User> users = userFeign.findAll((start - 1) * row, row);
        return new AllVO(0, "", userFeign.getTotalcounts(), users);
    }

    @GetMapping("findById/{id}")
    @ResponseBody
    @ApiOperation(value="根据id查询用户",notes = "根据id查询用户")
    public User findById(@PathVariable("id") int id){
        return userFeign.findById(id);
    }
    @ApiOperation(value="查询用户总数",notes = "查询用户总数")
    @GetMapping("getTotalcounts")
    public int getTotalcounts(){
        return userFeign.getTotalcounts();
    }
    @ApiOperation(value="新增用户",notes = "新增用户")
    @PostMapping("save")
    public String save(User user){
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/user_manage.html";
    }
    @ApiOperation(value="修改用户",notes = "修改用户")
    @PostMapping("update")
    public void update(User user){
        userFeign.update(user);
    }
    @ApiOperation(value="删除用户",notes = "根据id删除用户")
    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        userFeign.deleteById(id);
        return "redirect:/user_manage.html";
    }
}
