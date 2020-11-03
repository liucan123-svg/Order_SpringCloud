package com.lc.controller;

import com.lc.entity.AllVO;
import com.lc.entity.Menu;
import com.lc.entity.Msg;
import com.lc.entity.Type;
import com.lc.feign.MenuFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/client/menu")
@Api(value = "菜单模块|Menu")
public class MenuController {

    @Autowired
    MenuFeign menuFeign;


    @GetMapping("getMenus")
    @ResponseBody
    @ApiOperation(value="分页查询菜单",notes = "分页查询菜单")
    public AllVO getMenus(@RequestParam("page") int page, @RequestParam("limit") int limit){
        List<Menu> menus = menuFeign.getMenus((page - 1) * limit, limit);
        return new AllVO(0, "", menuFeign.getTotalcounts(), menus);
    }
    @ApiOperation(value="删除菜单",notes = "根据id删除菜单")
    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") int id){
        menuFeign.deleteById(id);
        return "redirect:/menu_manage.html";
    }
    @ApiOperation(value="查询菜单类型",notes = "查询菜单类型")
    @GetMapping("findTypes")
    @ResponseBody
    public Msg findTypes(Model model){
        List<Type> types = menuFeign.findTypes();
        return Msg.success().add("types", types);
    }

    // 这里仅仅是测试服务降级，因为前台没用ajax提交，所以这里没法将消息响应给前端
    @PostMapping("save")
    @ApiOperation(value="添加菜单",notes = "添加菜单")
    public String save(Menu menu){
        AllVO vo = menuFeign.save(menu);
        System.out.println(vo.getCode());
        if(vo.getCode()==200){
            return "redirect:/menu_manage.html";
        }else{
            System.out.println(vo.getMsg());
            return "redirect:/user_manage.html"; //指向另外一个页面，以区分成功时的页面
        }
    }


    @GetMapping("findById/{id}")
    @ResponseBody
    @ApiOperation(value="查询菜单",notes = "根据id查询菜单")
    public Msg findById(@PathVariable("id") int id){
        Menu menu = menuFeign.findById(id);
        return Msg.success().add("oneMenu",menu);
    }

    /*修改菜品*/
    @PostMapping("/update")
    @ResponseBody
    @ApiOperation(value="修改菜单",notes = "修改菜单")
    public Msg update(Menu menu){
        AllVO vo = menuFeign.update(menu);
        if(vo.getCode()==200){
            return Msg.success().add("msg", vo.getMsg());
        }else{
            return Msg.fail().add("msg", vo.getMsg());
        }
    }

}
