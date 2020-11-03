package com.lc.feign;

import com.lc.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@FeignClient("user")

public interface UserFeign {

    @GetMapping("/user/findAll/{start}/{row}")
    public List<User> findAll(@PathVariable("start") int start, @PathVariable("row") int row);

    @GetMapping("/user/findById/{id}")
    public User findById(@PathVariable("id") int id);

    @GetMapping("/user/getTotalcounts")
    public int getTotalcounts();

    @PostMapping("/user/save")
    public void save(User user);

    @PostMapping("/user/update")
    public void update(User user);

    @GetMapping("/user/deleteById/{id}")
    public void deleteById(@PathVariable("id") int id);
}
