package com.lc.feign;

import com.lc.entity.AllVO;
import com.lc.entity.Menu;
import com.lc.entity.Type;
import com.lc.hystrix.MenuHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;



@FeignClient(value = "menu", fallbackFactory = MenuHystrix.class) // yaml要配置feign.hystrix.feign=true
public interface MenuFeign {

    @GetMapping("/menu/getMenus/{start}/{row}")
    public List<Menu> getMenus(@PathVariable("start") int start, @PathVariable("row") int row);

    @GetMapping("/menu/getTotalcounts")
    public Integer getTotalcounts();

    @GetMapping("/menu/deleteById/{id}")
    void deleteById(@PathVariable("id") int id);

    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    AllVO save(Menu menu);

    @PostMapping("/menu/update")
    AllVO update(Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable("id") int id);
}
