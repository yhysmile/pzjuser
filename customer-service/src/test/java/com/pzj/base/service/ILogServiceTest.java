package com.pzj.base.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.pzj.base.entity.SysLog;
import com.pzj.base.service.sys.ILogService;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class })
@ContextConfiguration(locations = {"classpath*:/META-INF/spring/spring-context.xml"})
public class ILogServiceTest {
    @Autowired
    private ILogService logService;

    @Test
    public void insert() {
        SysLog entity = new SysLog();
        entity.setCreateBy("wwwwefwe");
        entity.setCreateId(1L);
        entity.setCreateDate(new Date());
        entity.setParams("params...");
        entity.setPosition("aaaa");
        entity.setException("eefe");
        entity.setMethod("method...");

        Long id = logService.insert(entity);

        assertNotNull(id);
    }

    @Test
    public void findListByParams() {

        SysLog entity = new SysLog();

        List<SysLog> result = logService.findListByParams(entity);

        assertNotNull(result);
    }

}
