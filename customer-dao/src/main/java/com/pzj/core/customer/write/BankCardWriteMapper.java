package com.pzj.core.customer.write;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.core.customer.profile.BankCardEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017-3-3.
 */
@MyBatisDao
public interface BankCardWriteMapper {
    BankCardEntity selectById(@Param("id") Long id);

    int insert(BankCardEntity entity);

    int insertBatch(List<BankCardEntity> entitys);

    int update(BankCardEntity entity);

    int updateBatch(List<BankCardEntity> entitys);
}
