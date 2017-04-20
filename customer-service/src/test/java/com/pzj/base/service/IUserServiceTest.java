package com.pzj.base.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.pzj.base.entity.SysChannel;
import com.pzj.framework.armyant.anno.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.pzj.base.common.global.PasswordGenerateUtil;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.SysUserRelation;
import com.pzj.base.service.sys.IUserService;
import com.pzj.framework.armyant.OneTestConfiguration;
import com.pzj.framework.armyant.OneTestConfigurationBuilder;
import com.pzj.framework.armyant.anno.OneCase;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;

/**
 * Created by Administrator on 2016-11-21.
 */
@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = {
        //"classpath:/spring-context.xml",
        "classpath:/META-INF/spring/spring-context.xml"
})
public class IUserServiceTest {
    @Autowired
    IUserService userService;

    @Test
    @OneCase("/com/pzj/base/service/IUserService/findListByParams.json")
    public void findListByParams(@TestData SysUser sysUser){
        List<SysUser> result = userService.findListByParams(sysUser);

        assertNotNull(result);
    }

    @OneCase("/com/pzj/base/service/IUserService/queryChannelUnbundledDirectsDistributor.json")
    @Test
    public void queryChannelUnbundledDirectsDistributor(@TestData("channelId") Long channelId,
                                                        @TestData("distributorParam") SysUser distributorParam,
                                                        @TestData("pageModel") PageModel pageModel) throws ClassNotFoundException {

        PageList<SysUser> pageListResult = userService.queryChannelUnbundledDirectsDistributor(channelId, distributorParam, pageModel);

        assertNotNull(pageListResult);

        List<SysUser> resultList = pageListResult.getResultList();
        assertNotNull(resultList);
    }

    @Test
    public void queryPendingAuditedUser(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/IUserService/queryPendingAuditedUser.json");

        SysUser userParam = (SysUser)oneTestConfiguration.getTestData("userParam");
        PageModel pageModel = (PageModel)oneTestConfiguration.getTestData("pageModel");


        PageList<SysUser> result = userService.queryPendingAuditedUser(userParam, pageModel);
        assertNotNull(result);

        List<SysUser> resultList = result.getResultList();
        assertNotNull(resultList);
    }

    @Test
    public void modifyUserReAudit(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/IUserService/modifyUserReAudit.json");

        SysUser sysUser = (SysUser)oneTestConfiguration.getTestData();

        Result result = userService.modifyUserReAudit(sysUser);

        assertNotNull(result);

        System.out.println(result.getErrorCode());
        System.out.println(result.getErrorMsg());

        assertTrue(result.isOk());
    }



    @Test
    public void auditPassUser(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/IUserService/auditPassUser.json");

        Long userId = (Long)oneTestConfiguration.getTestData("userId");
        Long checkUserId = (Long)oneTestConfiguration.getTestData("checkUserId");

        Result<Boolean> result = userService.auditPassUser(userId, checkUserId);

        assertNotNull(result);

        Boolean audit = result.getData();
        System.out.println(audit);

        System.out.println(result.getErrorMsg());
        assertTrue(audit);

    }


    @Test
    public void auditRejectUser(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/IUserService/auditRejectUser.json");

        Long userId = (Long)oneTestConfiguration.getTestData("userId");
        Long checkUserId = (Long)oneTestConfiguration.getTestData("checkUserId");
        String reasonsForRefusal =  (String)oneTestConfiguration.getTestData("reasonsForRefusal");

        Result<Boolean> result = userService.auditRejectUser(userId, checkUserId, reasonsForRefusal);

        assertNotNull(result);

        Boolean audit = result.getData();
        System.out.println(audit);

        System.out.println(result.getErrorMsg());
        assertTrue(audit);

    }

    @Test
    public void checkUserPass(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/IUserService/checkUserPass.json");

        Long userId = (Long)oneTestConfiguration.getTestData("userId");
        Long checkUserId = (Long)oneTestConfiguration.getTestData("checkUserId");

        Result<Boolean> result = userService.checkUserPass(userId, checkUserId);

        assertNotNull(result);

        Boolean audit = result.getData();
        System.out.println(audit);

        System.out.println(result.getErrorMsg());
        assertTrue(audit);
    }

    @Test
    public void unbundingSupplierAndDirctSingDistributors(){
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/IUserService/unbundingSupplierAndDirctSingDistributors.json");

        Long supplierId = (Long)oneTestConfiguration.getTestData("supplierId");
        Long distributorsId = (Long)oneTestConfiguration.getTestData("distributorsId");

        Result<Boolean> result = userService.unbundingSupplierAndDirctSingDistributors(supplierId, distributorsId);

        assertNotNull(result);

        Boolean audit = result.getData();
        System.out.println(audit);

        System.out.println(result.getErrorMsg());
        assertTrue(audit);
    }

    @Test
    public void findRefCustomerByRelation() throws ParseException {
        OneTestConfiguration oneTestConfiguration = OneTestConfigurationBuilder.build("/com/pzj/base/service/IUserService/findRefCustomerByRelation.json");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SysUser relUserParam = (SysUser)oneTestConfiguration.getTestData("relUserParam");
        relUserParam.setCreateDate(sdf.parse("2017-01-04 00:00:00.0"));
        relUserParam.setCreateDateEnd(sdf.parse("2017-01-04 23:59:59"));
        boolean isFindMaster = false;
        PageModel pageModel = null;
        SysUserRelation relation = new SysUserRelation();
        relation.setRelType("6");
        relation.setUserId(3306769055481857L);

        PageList<SysUser> result = userService.findRefCustomerByRelation(relation, relUserParam, isFindMaster, pageModel);

        assertNotNull(result);

        List<SysUser> userList = result.getResultList();
        assertNotNull(userList);
    }

    @Test
    public void saveUser(){
        for (int i = 0; i < 10; i++){
            updPass();
        }
    }

    private void updPass(){
        PageModel pageModel = new PageModel(1, 500);
        SysUser param = new SysUser();
        param.setIsBuygroup(1);

        PageList<SysUser> sysUserPageList = userService.queryPageByParamMap(pageModel, param);

        List<SysUser> resultList = sysUserPageList.getResultList();

        List<SysUser> updList = new ArrayList<>(resultList.size());

        for (SysUser user : resultList){
            try {
                String password = PasswordGenerateUtil.generatePassword(user.getId(), user.getLoginName(), "123456");


                SysUser upd = new SysUser();
                upd.setId(user.getId());
                upd.setIsBuygroup(2);
                upd.setLoginPasswd(password);

                updList.add(upd);

                System.out.println("id : " + user.getId() + " ; loginName : " + user.getLoginName() + " ; old pass : " + user.getLoginPasswd() + " ; nwe pass : " + password);
            } catch (Exception e){
                System.out.println("id : " + user.getId() + " ; loginName : " + user.getLoginName());
                e.printStackTrace();
                continue;
            }
        }

        userService.updateBatchByPrimaryKey(updList);
    }

    @Test
    @OneCase("/com/pzj/base/service/IUserService/updateByPrimaryKey.json")
    public void updateByPrimaryKey(@TestData SysUser user){
        Integer integer = userService.updateByPrimaryKey(user);
        assertNotNull(integer);
    }


    @Test
    @OneCase("/com/pzj/base/service/IUserService/insert.json")
    public void insert(@TestData SysUser user){
        Long id = userService.insert(user);
        assertNotNull(id);
        System.out.println(id);
    }

    @Test
    public void addUserAndAuth(){
        SysUser user = new SysUser();
        user.setUserType("6");
        user.setResellerType("5");
        user.setIsNeedUpdateNull(false);
        user.setId(3585148721823745L);

        List<SysChannel> channelList = new ArrayList<>();
        {
            SysChannel channel = new SysChannel();
            channel.setId(2216619736563714L);
            channel.setSupplierId(123456789L);
            channel.setIsNeedUpdateNull(false);
        }

        SysUser sysUser = userService.addUserAndAuth(user, null, null, null, null, channelList, null, null);
        System.out.println(sysUser);
    }

    @Test
    @OneCase("/com/pzj/base/service/IUserService/addUserAndAuth.json")
    public void addUserAndAuth2(@TestData("user") SysUser user,@TestData("channels") List<SysChannel> channelList){
        SysUser sysUser = userService.addUserAndAuth(user, null, null, null, null, channelList, null, null);
        System.out.println(sysUser);
    }
}
