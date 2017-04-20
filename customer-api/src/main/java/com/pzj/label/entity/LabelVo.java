package com.pzj.label.entity;

import static com.pzj.util.ServiceUtil.checkEmpty;
import static com.pzj.util.ServiceUtil.checkLengthMax;
import static com.pzj.util.ServiceUtil.checkNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.BaseVO;
import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysLabel;

/**
 * 标签表
 * 
 * @author apple
 * 
 */
public class LabelVo extends BaseVO implements Serializable {

    private static final long serialVersionUID = -939553413661597137L;

    /**
     * 标签名称
     */
    private String name;

    /**
     * 父id
     */
    private Long pid;

    /**
     * 排序
     */
    private Integer sort;
    private Date createDate;
    private String createBy;
    private String updateBy;
    private Date updateDate;
    /**
     * 介绍
     */
    private String remarks;
    /**
     * 使用状态1启用0禁用2删除
     */
    private String flag;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public static SysLabel changeTSysBean(LabelVo label) throws Exception {

        SysLabel sysLabel = new SysLabel();
        sysLabel.setCreateBy(label.getCreateBy());
        sysLabel.setCreateDate(label.getCreateDate());
        sysLabel.setFlag(label.getFlag());
        sysLabel.setId(label.getId());
        sysLabel.setName(label.getName());
        sysLabel.setPid(label.getPid());
        sysLabel.setRemarks(label.getRemarks());
        sysLabel.setSort(label.getSort());
        sysLabel.setUpdateBy(label.getUpdateBy());
        sysLabel.setUpdateDate(label.getUpdateDate());

        return sysLabel;
    }

    public static SysLabel createNew(LabelVo label) throws Exception {
        // 验证
        validData(label);

        // 设置默认参数
        setDefaultData(label);

        // 转换
        return changeTSysBean(label);

    }

    public static LabelVo changeTAPIBean(SysLabel sysLabel) throws Exception {
        if (null == sysLabel) {
            return null;
        }
        
        LabelVo vo = new LabelVo();

        vo.setCreateBy(sysLabel.getCreateBy());
        vo.setCreateDate(sysLabel.getCreateDate());
        vo.setFlag(sysLabel.getFlag());
        vo.setId(sysLabel.getId());
        vo.setName(sysLabel.getName());
        vo.setPid(sysLabel.getPid());
        vo.setRemarks(sysLabel.getRemarks());
        vo.setSort(sysLabel.getSort());
        vo.setUpdateBy(sysLabel.getUpdateBy());
        vo.setUpdateDate(sysLabel.getUpdateDate());
        return vo;
    }

    public static List<SysLabel> cList2SList(List<LabelVo> LabelVoList)
            throws Exception {
        List<SysLabel> SysLabelList = null;
        if (LabelVoList != null) {
            SysLabelList = new ArrayList<SysLabel>();
            for (LabelVo LabelVo : LabelVoList) {
                Long LabelVoId = LabelVo.getId();
                SysLabel SysLabel = null;
                if (LabelVoId == null || LabelVoId < 1) {
                    SysLabel = createNew(LabelVo);
                } else {
                    SysLabel = changeTSysBean(LabelVo);
                }

                SysLabelList.add(SysLabel);
            }
        }
        return SysLabelList;
    }

    public static List<LabelVo> sList2CList(List<SysLabel> sysLabelList)
            throws Exception {
        List<LabelVo> labelVoList = null;
        if (sysLabelList != null) {
            labelVoList = new ArrayList<LabelVo>();
            for (SysLabel sysLabel : sysLabelList) {
                if(null != sysLabel){
                    LabelVo label = changeTAPIBean(sysLabel);
                    if(null != label)
                        labelVoList.add(label);
                }
            }
        }
        return labelVoList;
    }

    /**
     * @param LabelVo
     * @throws ServiceException
     */
    public static void validData(LabelVo labelVo) throws ServiceException {
        checkNull(labelVo, "labelVo不能为null");
        checkEmpty(labelVo.getName(), "labelVo.Name不能为空");

    }

    public static void validDataAll(LabelVo LabelVo) throws ServiceException {
        validData(LabelVo);
        checkLengthMax(LabelVo.getName(), 100, "LabelVo.Name超过最大长度，最大为100");
        checkLengthMax(LabelVo.getCreateBy(), 64, "LabelVo.CreateBy超过最大长度，最大为64");
        checkLengthMax(LabelVo.getUpdateBy(), 64, "LabelVo.UpdateBy超过最大长度，最大为64");
        checkLengthMax(LabelVo.getRemarks(), 255, "LabelVo.Remarks超过最大长度，最大为255");
    }

    protected static void setDefaultData(LabelVo labelVo) {
        if (null == labelVo.getCreateDate()) {
            labelVo.setCreateDate(new Date());
        }
        if (StringUtils.isEmpty(labelVo.getFlag())) {
            labelVo.setFlag("1");
        }
        if (labelVo.getPid() == null) {
            labelVo.setPid(0l);

        }
    }

}
