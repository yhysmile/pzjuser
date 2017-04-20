package com.pzj.core.customer.dao;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysContacts;
import com.pzj.base.entity.query.SysContactsQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016-10-12.
 */
@MyBatisDao
public interface SysContactMapper  extends BaseMapper<SysContacts> {

    /**
     * 删除对象
     *
     * @param ids
     * @return
     */
    int deleteBatchByPrimaryKey(List<Long> ids);

    /**
     * 删除对象
     *
     * @param queryParam
     * @return
     */
    int deleteBatchByParam(@Param("bParam") SysContactsQueryParam queryParam);
}
