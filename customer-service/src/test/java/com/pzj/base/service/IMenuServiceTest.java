package com.pzj.base.service;

import com.pzj.base.entity.SysMenu;
import com.pzj.base.service.sys.IMenuService;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.converter.JSONConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-5-5.
 */
@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-local.xml"})
public class IMenuServiceTest {
    @Resource
    private IMenuService menuService;

    @Test
    public void findMenuOfUser(){
        Long userId = 2216619736665199L;
        List<SysMenu> result = menuService.findMenuOfUser(userId);
        // System.out.println(JSONConverter.toJson(result));

        for (SysMenu menu : result){
            System.out.println(menu.getCatalog() + " - " +menu.getHref());
        }
    }
}
