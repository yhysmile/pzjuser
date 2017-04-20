package com.pzj.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.common.utils.PageBean;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.service.sys.ILabelService;
import com.pzj.core.customer.dao.SysLabelMapper;

@Service("labelServiceImpl")
public class LabelServiceImpl extends BaseUserServiceImpl<SysLabel, SysLabelMapper> implements ILabelService {

    public PageList<SysLabel> queryPageByObjId(PageModel pager, SysLabel label,
            Long channelId, String refType) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", label);
        params.put("idParam", channelId);
        params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, refType);
        List<SysLabel> listBean = mapper.findLabelListByObjID(params);
        Integer count = mapper.countLabelByObjID(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysLabel> pagelist = null;
        pagelist = new PageList<SysLabel>(listBean, pageObj);
        return pagelist;
    }

    public PageList<SysLabel> queryPageByRefId(PageModel pager, SysLabel label,
            Long channelId, String refType) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("pParam", pager);
        params.put("bParam", label);
        params.put("idParam", channelId);
        params.put(ChannelMapKeyParam.RELATION_TYPE_KEY, refType);
        List<SysLabel> listBean = mapper.findLabelListByRefID(params);
        Integer count = mapper.countLabelByRefID(params);
        PageBean pageObj = new PageBean(Long.valueOf(count.toString()), pager);
        PageList<SysLabel> pagelist = null;
        pagelist = new PageList<SysLabel>(listBean, pageObj);
        return pagelist;
    }

    @Override
    public List<SysLabel> findByRelation(SysLabelRelationKey key) {
        if (null == key)
            return null;

        return mapper.selectByRelation(key);
    }

}
