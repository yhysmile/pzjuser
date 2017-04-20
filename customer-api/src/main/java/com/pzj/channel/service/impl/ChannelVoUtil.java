package com.pzj.channel.service.impl;

import java.util.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.global.UserGlobalParam.ChannelMapKeyParam;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysUser;
import com.pzj.base.service.sys.IChannelService;
import com.pzj.base.service.sys.ILabelService;
import com.pzj.base.service.sys.IUserService;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.customer.entity.Customer;
import com.pzj.label.entity.LabelVo;

@Component
public class ChannelVoUtil {
    @Autowired
    private IChannelService ichannelService = null;
    @Autowired
    private ILabelService ilabelService = null;
    @Autowired
    private IUserService iuserService = null;


    /**
     * 遍历列表，拼接Ids
     * 
     */
    public String getIds(List<ChannelVo> records) {

        if (records == null || records.isEmpty()) {
            return "";
        }
        StringBuffer buff = new StringBuffer();
        for (ChannelVo vo : records) {
            Long id = vo.getId();
            if (id != null) {
                buff.append(id).append(",");
            }

        }
        return buff.substring(0, buff.length() - 1);
    }

    /**
     * 根据id获取渠道对象
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public ChannelVo getRecordById(Long id) throws Exception {
        if (id == null) {
            return null;
        }

        ChannelVo vo = null;
        SysChannel sysBean = ichannelService.getById(id);
        if (sysBean != null) {
            vo = ChannelVo.changeTChannelVo(sysBean);
        }
        return vo;
    }

    /**
     * 根据ids获取所有有效渠道列表
     * 
     * @throws Exception
     */
    public List<ChannelVo> getRecordListByIds(String ids)
            throws Exception {
        Map<String, String> idsMap = new HashMap<String, String>();
        if (StringUtils.isNotBlank(ids)) {
            idsMap.put(UserGlobalParam.ChannelMapKeyParam.CHANNEL_MAP_KEY, ids);
        }

        List<ChannelVo> list = null;
        List<SysChannel> sysList = ichannelService.findByIds(idsMap);
        if (sysList != null && !sysList.isEmpty()) {
            list = ChannelVo.sList2CList(sysList);
        }
        return list;
    }

    /**
     * 判断渠道状态是否不在filterFlag中
     * 
     * @param vo
     * @param filterFlag
     * @return
     */
    public boolean judgeChannelFlag(ChannelVo vo, String... filterFlag) {
        if (vo == null || StringUtils.isBlank(vo.getFlag())) {
            return false;
        }
        List<ChannelVo> list = new ArrayList<ChannelVo>();
        list.add(vo);
        filterChannelFlag(list, filterFlag);
        if (list.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * 按照渠道状态过滤掉状态为：filterFlag的渠道
     */
    public void filterChannelFlag(List<ChannelVo> list,
            String... filterFlag) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (filterFlag == null || filterFlag.length == 0) {
            return;
        }
        StringBuffer filterBuffer = new StringBuffer();

        for (String s : filterFlag) {
            filterBuffer.append(s).append("#");
        }
        Iterator<ChannelVo> sListIterator = list.iterator();
        while (sListIterator.hasNext()) {
            ChannelVo e = sListIterator.next();
            String flag = e.getFlag();
            if (StringUtils.isNotBlank(flag)
                    && (filterBuffer.indexOf(flag) > -1)) {
                sListIterator.remove();
            }
        }

    }

    /**
     * 根据ids获取所有有效渠道列表
     * 
     * @throws Exception
     */
    public Map<Long, ChannelVo> getRecordMapByIds(String ids)
            throws Exception {
        Map<String, String> idsMap = new HashMap<String, String>();
        if (StringUtils.isNotBlank(ids)) {
            idsMap.put(UserGlobalParam.ChannelMapKeyParam.CHANNEL_MAP_KEY, ids);
        }

        Map<Long, ChannelVo> map = null;
        List<SysChannel> sysList = ichannelService.findByIds(idsMap);
        if (sysList != null && !sysList.isEmpty()) {
            map = new HashMap<Long, ChannelVo>();
            for (SysChannel bean : sysList) {
                map.put(bean.getId(), ChannelVo.changeTChannelVo(bean));
            }
        }
        return map;
    }

    /**
     * 给渠道封装对应的有效标签列表
     * 
     * @throws Exception
     * 
     */
    public void setChannelLabelist(ChannelVo vo) throws Exception {
        if (vo == null) {
            return;
        }
        if (vo.getId() == null) {
            return;
        }
        PageList<SysLabel> pageList = ilabelService.queryPageByObjId(null,
                null, vo.getId(),
                ChannelMapKeyParam.CHANNEL_LABEL_RELATION_TYPE);
        if (pageList == null || pageList.getResultList() == null
                || pageList.getResultList().isEmpty()) {
            return;
        }
        List<LabelVo> list = LabelVo.sList2CList(pageList.getResultList());
        vo.setList(list);

    }

    /**
     * 给渠道封装对应的有效分销商列表
     * 
     * @throws Exception
     * 
     */
    public void setChannelCustomerList(ChannelVo vo) throws Exception {

        if (vo == null) {
            return;
        }
        if (vo.getId() == null) {
            return;
        }
        PageList<SysUser> pageList = iuserService.queryPageByObjId(null, null,
                vo.getId(), ChannelMapKeyParam.CHANNEL_USER_RELATION_TYPE);
        if (pageList == null || pageList.getResultList() == null
                || pageList.getResultList().isEmpty()) {
            return;
        }
        List<Customer> list = Customer.sList2CList(pageList.getResultList());
        vo.setClist(list);
    }



}
