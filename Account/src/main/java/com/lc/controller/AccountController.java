package com.lc.controller;

import com.lc.dao.AdminDao;
import com.lc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("account")
public class AccountController {

    @Autowired
    UserDao userDao;

    @Autowired
    AdminDao adminDao;
//    根据不同类型判断登录
    @GetMapping("login/{username}/{password}/{type}")
    public Object login(@PathVariable("username")String username,@PathVariable("password")String password,@PathVariable("type")String type){
        Object obj = null;
        if("user".equals(type)){
            obj = userDao.login(username, password);
        }else if("admin".equals(type)){
            obj = adminDao.login(username, password);
        }
        return obj;
    }
}
