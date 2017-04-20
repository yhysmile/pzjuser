package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysLabelRelationKey;

public interface ILabelService extends IBaseUserService<SysLabel> {
    /**
     * 通过关系表中的objId获取标签分页集合
     * 
     */
    public PageList<SysLabel> queryPageByObjId(PageModel pager, SysLabel label,
            Long objId, String refType);

    /**
     * 通过关系表中的refId获取标签分页集合
     * 
     */
    public PageList<SysLabel> queryPageByRefId(PageModel pager, SysLabel label,
            Long refId, String refType);

    /**
     * 
     * @param key
     */
    public List<SysLabel> findByRelation(SysLabelRelationKey key);

}
