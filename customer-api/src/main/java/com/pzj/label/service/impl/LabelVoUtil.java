package com.pzj.label.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.service.sys.ILabelService;
import com.pzj.label.entity.LabelVo;

@Component
public class LabelVoUtil {

    @Autowired
    private ILabelService ilabelService;

    /**
     * 遍历列表，拼接Ids
     * 
     */
    public String getIds(List<LabelVo> records) {

        if (records == null || records.isEmpty()) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        for (LabelVo vo : records) {
            Long id = vo.getId();
            if (id != null) {
                buff.append(id).append(",");
            }

        }
        return buff.substring(0, buff.length() - 1);
    }

    /**
     * 根据角色Ids获取所有有效角色列表
     * 
     * @throws Exception
     */
    public List<LabelVo> getRecordListByIds(String ids) throws Exception {
        Map<String, String> idsMap = new HashMap<String, String>();
        idsMap.put(UserGlobalParam.ChannelMapKeyParam.LABEL_MAP_KEY, ids);
        idsMap.put(UserGlobalParam.UserMapKeyParam.DELE_MAP_KEY,
                String.valueOf(GlobalParam.FLAG.start()));
        List<LabelVo> list = null;
        List<SysLabel> sysList = ilabelService.findByIds(idsMap);
        if (sysList != null && !sysList.isEmpty()) {
            list = LabelVo.sList2CList(sysList);
        }
        return list;
    }
}
