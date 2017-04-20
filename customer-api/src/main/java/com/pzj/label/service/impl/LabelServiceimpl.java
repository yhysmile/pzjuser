package com.pzj.label.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.UserGlobalParam;
import com.pzj.base.common.global.UserGlobalParam.LabelRelationType;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.service.sys.ILabelService;
import com.pzj.label.entity.LabelVo;
import com.pzj.label.service.LabelService;

/**
 * 标签对外接口
 * 
 * @author apple
 * 
 */
@Service
public class LabelServiceimpl implements LabelService {

    // 创建日志对象
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ILabelService ilabelService;

    /**
     * 创建新标签或标签类
     */
    public Long create(LabelVo vo) throws Exception {
        Long num = 0l;
        try {
            if (vo == null) {
                logger.error("接口方法[LabelService.create],参数vo不能为空");
                return num;
            }
            SysLabel label = LabelVo.createNew(vo);
            num = ilabelService.insert(label);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return num;
    }

    /**
     * 编辑，逻辑删除时用此接口
     */

    public Integer update(LabelVo vo) throws Exception {

        int num = 0;
        try {
            if (vo == null) {
                logger.error("接口方法[LabelService.save],参数vo不能为空");
                return num;
            }
            Long id = vo.getId();
            if (id == null || id < 1) {
                logger.error("接口方法[LabelService.save],参数vo的id不能为空");
                return num;
            }
            SysLabel label = LabelVo.changeTSysBean(vo);
            num = ilabelService.updateByPrimaryKey(label);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;

        }
        return num;
    }

    /**
     * 通过单个id查询标签对象
     */
    @Override
    public LabelVo getById(Long id) throws Exception {

        LabelVo bean = null;
        try {
            if (id == null || id < 1) {
                logger.error("接口方法[LabelService.getById],参数id不能为空");
            }
            SysLabel sysBean = ilabelService.getById(id);
            if (sysBean != null) {
                bean = LabelVo.changeTAPIBean(sysBean);
            }
        } catch (Exception e) {

            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }
        return bean;
    }

    public PageList<LabelVo> queryPageByParamMap(PageModel pager, LabelVo vo)
            throws Exception {
        PageList<LabelVo> list = new PageList<LabelVo>();
        try {
            SysLabel sysBean = LabelVo.changeTSysBean(vo);
            PageList<SysLabel> pageList = ilabelService.queryPageByParamMap(
                    pager, sysBean);

            List<LabelVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysLabel> records = pageList.getResultList();
                voList = LabelVo.sList2CList(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    /**
     * 获取标签集合，通过不同参数，查询不同纬度下的数据
     * 
     * @return
     */
    public List<LabelVo> labelList(LabelVo vo) throws Exception {

        List<LabelVo> returnList = null;
        try {
            if (vo == null) {
                logger.error("接口方法[LabelService.labelList],参数vo不能为空");
                return null;
            }
            SysLabel sysBean = LabelVo.changeTSysBean(vo);
            List<SysLabel> sysList = ilabelService.findListByParams(sysBean);
            if (sysList == null || sysList.isEmpty()) {
                return returnList;
            }
            returnList = LabelVo.sList2CList(sysList);

        } catch (Exception e) {
            logger.error(e.toString());
            throw e;
        }
        return returnList;
    }

    public PageList<LabelVo> queryPageByChannelId(PageModel pager, LabelVo vo,
            Long channelId) throws Exception {
        PageList<LabelVo> list = new PageList<LabelVo>();
        try {
            if (channelId == null || channelId < 1) {
                logger.error("接口方法[LabelService.queryPageByChannelId],参数channelId不能为空");
                return list;
            }
            SysLabel sysBean = LabelVo.changeTSysBean(vo);
            PageList<SysLabel> pageList = ilabelService
                    .queryPageByObjId(
                            pager,
                            sysBean,
                            channelId,
                            UserGlobalParam.ChannelMapKeyParam.CHANNEL_LABEL_RELATION_TYPE);

            List<LabelVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysLabel> records = pageList.getResultList();
                voList = LabelVo.sList2CList(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    public PageList<LabelVo> queryPageByCustomerId(PageModel pager, LabelVo vo,
            Long customerId) throws Exception {
        PageList<LabelVo> list = new PageList<LabelVo>();
        try {
            if (customerId == null || customerId < 1) {
                logger.error("接口方法[LabelService.queryPageByCustomerId],参数customerId不能为空");
                return list;
            }
            SysLabel sysBean = LabelVo.changeTSysBean(vo);
            PageList<SysLabel> pageList = ilabelService
                    .queryPageByObjId(
                            pager,
                            sysBean,
                            customerId,
                            UserGlobalParam.ChannelMapKeyParam.USER_LABEL_RELATION_TYPE);

            List<LabelVo> voList = null;
            if (pageList != null && (!pageList.isEmpty())) {
                List<SysLabel> records = pageList.getResultList();
                voList = LabelVo.sList2CList(records);
            }
            list.setResultList(voList);
            list.setPageBean(pageList.getPageBean());

        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
            throw e;
        }

        return list;
    }

    @Override
    public List<LabelVo> findByCustomer(Long customerId) throws Exception {
        if (null == customerId) {
            return null;
        }

        // 封装查询条件
        SysLabelRelationKey key = new SysLabelRelationKey();
        // 设置用户id
        key.setObjId(customerId.toString());
        // 设置关系类型为“用户与标签”的类型
        key.setRelType(LabelRelationType.UserType);

        // 调用服务查询数据
        // List<SysLabelRelationKey> sysLabelList =
        // labelRelationService.findByRelation(key);
        List<SysLabel> sysLabelList = ilabelService.findByRelation(key);

        // 转换SysLabel类型为LabelVo类型
        List<LabelVo> result = LabelVo.sList2CList(sysLabelList);

        return result;
    }

}
