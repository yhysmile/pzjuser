package com.pzj.core.customer.bankcard;

import com.pzj.framework.armyant.anno.OneCase;
import com.pzj.framework.armyant.anno.TestData;
import com.pzj.framework.armyant.junit.spring.ArmyantSpringRunner;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;

import java.io.Serializable;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Administrator on 2017-3-3.
 */
@RunWith(ArmyantSpringRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/spring-context.xml" })
public class BankCardServiceTest {
    @Resource
    BankCardService bankCardService;

    private static  <T extends Serializable> void assertNotNullAndPrint(Result<T> result){
        assertNotNull(result);
        assertTrue(result.isOk());
        assertNotNull(result.getData());

        System.out.println(JSONConverter.toJson(result));
    }

    private static void assertTrueAndPrint(Result<Boolean> result){
        assertNotNull(result);
        assertTrue(result.isOk());
        assertTrue(result.getData());

        System.out.println(JSONConverter.toJson(result));
    }

    @Test
    @OneCase("/com/pzj/core/customer/bankcard/BankCardService/createMicroshopBankCard.json")
    public void createMicroshopBankCard(@TestData CreateBankCardRequest createBankCardRequest){
        Result<Long> result = bankCardService.createMicroshopBankCard(createBankCardRequest);

        assertNotNullAndPrint(result);
    }

    @Test
    @OneCase("/com/pzj/core/customer/bankcard/BankCardService/modifyMicroshopBankCard.json")
    public void modifyMicroshopBankCard(@TestData ModifyBankCardRequest modifyBankCardRequest){
        Result<Boolean> result = bankCardService.modifyMicroshopBankCard(modifyBankCardRequest);

        assertTrueAndPrint(result);
    }

    @Test
    @OneCase("/com/pzj/core/customer/bankcard/BankCardService/queryMicroshopBankCardByOwnerid.json")
    public void queryMicroshopBankCardByOwnerid(@TestData Long ownerId){
        Result<BankCardDetailResponse> result = bankCardService.queryMicroshopBankCardByOwnerid(ownerId);

        assertNotNullAndPrint(result);
    }
}
