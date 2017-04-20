package com.pzj.base.service;

import com.pzj.base.entity.SysUserRelation;
import com.pzj.base.service.sys.ISysUserRelationService;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.pzj.framework.armyant.OneTestConfiguration;
import com.pzj.framework.armyant.OneTestConfigurationBuilder;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2016-11-21.
 */
@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/spring-context.xml" })
public class  ISysUserRelationServiceTest {
    @Autowired
    ISysUserRelationService userRelationService;

    @Test
    public void insertBatch(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/ISysUserRelationService/insertBatch.json");

        List<SysUserRelation> userRelationList = (List<SysUserRelation>)oneTestConfiguration.getTestData("userRelationList");

        Long insertBatch = userRelationService.insertBatch(userRelationList);

        assertNotNull(insertBatch);
    }

    @Test
    public void createNoRepeat(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/ISysUserRelationService/createNoRepeat.json");

        SysUserRelation userRelation = (SysUserRelation)oneTestConfiguration.getTestData();

        Long id = userRelationService.createNoRepeat(userRelation);

        assertNotNull(id);
    }

    @Test
    public void createBatchNoRepeat(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/ISysUserRelationService/createBatchNoRepeat.json");

        List<SysUserRelation> userRelationList = (List<SysUserRelation>)oneTestConfiguration.getTestData();

        Result<Boolean> count = userRelationService.createBatchNoRepeat(userRelationList);

        assertNotNull(count);
        assertTrue(count.getData());
        assertTrue(count.isOk());
    }
}
