package com.pzj.dao;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysAddress;
import com.pzj.base.entity.query.SysAddressQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wuliqing on 2016-10-19.
 */
@MyBatisDao
public interface SysAddressMapper extends BaseMapper<SysAddress> {

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
    int deleteBatchByParam(@Param("bParam") SysAddressQueryParam queryParam);

    List<SysAddress> queryByManyParam(List<SysAddressQueryParam> queryParamList);
}