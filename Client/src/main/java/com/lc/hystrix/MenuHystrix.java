package com.lc.hystrix;

import com.lc.entity.AllVO;
import com.lc.entity.Menu;
import com.lc.entity.Type;
import com.lc.feign.MenuFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
//将组件纳入Spring管理，才能使用Spring的一系列的功能和特性。
public class MenuHystrix implements FallbackFactory {

    @Override
    public Object create(Throwable throwable) {
        return new MenuFeign() {
            @Override
            public List<Menu> getMenus(int start, int row) {
                return null;
            }

            @Override
            public Integer getTotalcounts() {
                return null;
            }

            @Override
            public void deleteById(int id) {

            }

            @Override
            public List<Type> findTypes() {
                return null;
            }

            @Override
            public AllVO save(Menu menu) {
                return new AllVO().setCode(499).setMsg("服务降级，现在不允许添加菜单，请稍后再试！");
            }

            @Override
            public AllVO update(Menu menu) {
                return null;
            }

            @Override
            public Menu findById(int id) {
                return null;
            }
        };
    }
}


