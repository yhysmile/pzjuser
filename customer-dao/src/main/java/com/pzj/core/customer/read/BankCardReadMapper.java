package com.pzj.core.customer.read;

import com.pzj.core.customer.entitys.BankCardEntity;
import com.pzj.core.customer.entitys.BankCardQueryParam;
import com.pzj.core.customer.entitys.PageEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017-3-3.
 */
public interface BankCardReadMapper {
    BankCardEntity selectById(@Param("id") Long id);

    List<BankCardEntity> selectByOwnerId(@Param("ownerId") Long ownerId);

    List<BankCardEntity> queryByParam(@Param("param") BankCardQueryParam param, @Param("page") PageEntity page);
}
