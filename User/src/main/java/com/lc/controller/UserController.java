package com.lc.controller;

import com.lc.entity.User;
import com.lc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    @Value("${server.port}")
    private String port;

    @GetMapping("getPort")
    public String getPort(){
        return this.port;
    }

    @Autowired
    UserService userService;

    @GetMapping("findAll/{start}/{row}")
    public List<User> findAll(@PathVariable("start") int start, @PathVariable("row") int row){
        return userService.findAll(start, row);
    }

    @GetMapping("findById/{id}")
    public User findById(@PathVariable("id") int id){
        return userService.findById(id);
    }

    @GetMapping("getTotalcounts")
    public int getTotalcounts(){
        return userService.count();
    }

    @PostMapping("save")
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @PostMapping("update")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @GetMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        userService.deleteById(id);
    }
}
