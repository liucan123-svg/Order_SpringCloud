package com.lc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.lc.entity.AllVO;
import com.lc.entity.Menu;
import com.lc.entity.Type;
import com.lc.service.MenuService;
import com.lc.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.List;


/*通过Client中的feign调用此Controller,feign再传到Client层的MenuController*/
@RestController
@RequestMapping("menu")
//使用@Controller 注解，在对应的方法上，视图解析器可以解析return 的jsp,html页面，并且跳转到相应页面
//若返回json等内容到页面，则需要加@ResponseBody注解
//@RestController=@Controller +@@ResponseBody
//@Controller层只是提供数据，没有视图。
public class MenuController {
//获得当前启动端口和IP
    @Value("${server.port}")
    private String port;


    @Autowired
    MenuService menuService;

    @Autowired
    TypeService typeService;

    @RequestMapping("getPort")
    public String getPort(){
        return "port:"+this.port;
    }


    @GetMapping("/getMenus/{start}/{row}")
    public List<Menu> getMenus(@PathVariable("start") int start, @PathVariable("row") int row){
        return menuService.findAll(start, row);
    }

    @GetMapping("getTotalcounts")
    public Integer getTotalcounts(){
        return menuService.count();
    }


    @GetMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") int id){
        menuService.deleteById(id);
    }


    @GetMapping("findTypes")
    public List<Type> findTypes(){
        return typeService.findAll();
    }

    @PostMapping("save")
    public AllVO save(@RequestBody Menu menu){
        menuService.save(menu);
        return new AllVO().setCode(200).setMsg("添加成功");
    }

    @PostMapping("update")
    @HystrixCommand(fallbackMethod = "hystrixMethod") // 失败时调用指定方法
    public AllVO update(@RequestBody Menu menu){
        if(menu.getPrice()<0){
            System.out.println("-----Hystrix-------");
            throw new RuntimeException("价格不允许小于0");
        }
        menuService.update(menu);
        return new AllVO().setMsg("修改成功").setCode(200);
    }

    @GetMapping("findById/{id}")
    public Menu findById(@PathVariable("id") int id){
        return menuService.findById(id);
    }



    public AllVO hystrixMethod(@RequestBody Menu menu){
        return new AllVO().setMsg("服务熔断，价格不允许小于0！").setCode(499);
    }
}
