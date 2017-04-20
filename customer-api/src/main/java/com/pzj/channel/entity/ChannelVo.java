package com.pzj.channel.entity;

import static com.pzj.util.ServiceUtil.checkNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.BaseVO;
import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysChannel;
import com.pzj.customer.entity.Customer;
import com.pzj.label.entity.LabelVo;

/**
 * 渠道
 * 
 * @author apple
 * 
 */
public class ChannelVo extends BaseVO implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = -2362855056191370339L;
    
    /**
     * 查询参数：根据id集合查询
     * */
    private List<Long> queryIds;
    
    /**
     * 渠道名称
     */
    private String name;
    /**
     * 渠道负责人
     */
    private String channelPrincipal;
    /**
     * 市
     */
    private String city;
    /**
     * 县
     */
    private String county;
    /**
     * 省
     */
    private String province;

    /** 渠道简拼 */
    private String spell;

    /** 创建日期 */
    private Date createDate;

    /** 创建日期结束范围（只用于查询） */
    private Date createDateEnd;
    /**
     * 使用状态1启用0禁用2删除
     */
    private String flag;
    /**
     * 排序
     */
    private Integer sort;

    /** 更新日期 */
    private Date updateDate;

    /** 更新人 */
    private String updateBy;

    /** 创建人 */
    private String createBy;
    /**
     * 备注
     */
    private String remark;
    /**
     * 渠道类型
     */
    private String channelType;
    /**
     * 分销渠道类别
     */
    private String channelCategory;

    /**
     * 数据来源
     */
    private String dataSource;

    /**
     * 创建供应商ID
     */
    private Long supplierId;

    /**
     * 标签集合
     */
    private List<LabelVo> list;

    /**
     * 分销商集合
     */
    private List<Customer> clist;

    /**
     * 获取分销商集合
     * 
     * @return clist 分销商集合
     */
    public List<Customer> getClist() {
        return clist;
    }

    /**
     * 设置分销商集合
     * 
     * @param clist
     *            分销商集合
     */
    public void setClist(List<Customer> clist) {
        this.clist = clist;
    }

    /**
     * 渠道来源，有系统默认给出，如在景区就是供应商来源，在平台就是系统设定
     */
    private String ChannelSource;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannelPrincipal() {
        return channelPrincipal;
    }

    public void setChannelPrincipal(String channelPrincipal) {
        this.channelPrincipal = channelPrincipal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelCategory() {
        return channelCategory;
    }

    public void setChannelCategory(String channelCategory) {
        this.channelCategory = channelCategory;
    }

    public List<LabelVo> getList() {
        return list;
    }

    public void setList(List<LabelVo> list) {
        this.list = list;
    }

    public String getChannelSource() {
        return ChannelSource;
    }

    public void setChannelSource(String channelSource) {
        ChannelSource = channelSource;
    }

    /**
     * 获取数据来源
     * 
     * @return dataSource 数据来源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 设置数据来源
     * 
     * @param dataSource
     *            数据来源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取创建供应商ID
     * 
     * @return supplierId 创建供应商ID
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     * 设置创建供应商ID
     * 
     * @param supplierId
     *            创建供应商ID
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
    
    
    

    public List<Long> getQueryIds() {
		return queryIds;
	}

	public void setQueryIds(List<Long> queryIds) {
		this.queryIds = queryIds;
	}

	public static SysChannel changeTSysBean(ChannelVo vo){
        if (vo == null) {
            return null;
        }
        SysChannel sysBean = new SysChannel();
        sysBean.setChannelCategory(vo.getChannelCategory());
        sysBean.setChannelPrincipal(vo.getChannelPrincipal());
        sysBean.setChannelType(vo.getChannelType());
        sysBean.setCity(vo.getCity());
        sysBean.setCounty(vo.getCounty());
        sysBean.setCreateBy(vo.getCreateBy());
        sysBean.setCreateDate(vo.getCreateDate());
        sysBean.setDataSource(vo.getDataSource());
        sysBean.setDelFlag(vo.getFlag());
        sysBean.setId(vo.getId());
        sysBean.setName(vo.getName());
        sysBean.setProvince(vo.getProvince());
        sysBean.setRemark(vo.getRemark());
        sysBean.setSort(vo.getSort());
        sysBean.setSpell(vo.getSpell());
        sysBean.setUpdateBy(vo.getUpdateBy());
        sysBean.setUpdateDate(vo.getUpdateDate());
        sysBean.setSupplierId(vo.getSupplierId());
        sysBean.setQueryIds(vo.getQueryIds());
        sysBean.setCreateDateEnd(vo.getCreateDateEnd());

        return sysBean;
    }

    public static SysChannel createNew(ChannelVo vo) throws Exception {
        // 验证
        validData(vo);

        // 设置默认参数
        setDefaultData(vo);

        // 转换
        return changeTSysBean(vo);

    }

    public static ChannelVo changeTChannelVo(SysChannel sysBean) {
        if (sysBean == null) {
            return null;
        }
        ChannelVo vo = new ChannelVo();
        vo.setChannelCategory(sysBean.getChannelCategory());
        vo.setChannelPrincipal(sysBean.getChannelPrincipal());
        vo.setChannelType(sysBean.getChannelType());
        vo.setCity(sysBean.getCity());
        vo.setCounty(sysBean.getCounty());
        vo.setCreateBy(sysBean.getCreateBy());
        vo.setCreateDate(sysBean.getCreateDate());
        vo.setDataSource(sysBean.getDataSource());
        vo.setFlag(sysBean.getDelFlag());
        vo.setId(sysBean.getId());
        vo.setName(sysBean.getName());
        vo.setProvince(sysBean.getProvince());
        vo.setRemark(sysBean.getRemark());
        vo.setSort(sysBean.getSort());
        vo.setSpell(sysBean.getSpell());
        vo.setUpdateBy(sysBean.getUpdateBy());
        vo.setUpdateDate(sysBean.getUpdateDate());
        vo.setSupplierId(sysBean.getSupplierId());
        vo.setCreateDateEnd(sysBean.getCreateDateEnd());
        return vo;
    }

    public static List<SysChannel> cList2SList(List<ChannelVo> channelList)
            throws Exception {
        List<SysChannel> list = null;
        if (channelList != null) {
            list = new ArrayList<SysChannel>();
            for (ChannelVo vo : channelList) {
                Long channelId = vo.getId();
                SysChannel sysChannel = null;
                if (channelId == null || channelId < 1) {
                    sysChannel = createNew(vo);
                } else {
                    sysChannel = changeTSysBean(vo);
                }

                list.add(sysChannel);
            }
        }
        return list;
    }

    public static List<ChannelVo> sList2CList(List<SysChannel> channelList){
        List<ChannelVo> list = null;
        if (channelList != null) {
            list = new ArrayList<ChannelVo>();
            for (SysChannel record : channelList) {
                ChannelVo vo = changeTChannelVo(record);
                list.add(vo);
            }
        }
        return list;
    }

    public static void validData(ChannelVo vo) throws ServiceException {
        checkNull(vo, "渠道实体不能为null");
        // checkEmpty(vo.getName(), "渠道名称不能为空");
        // checkEmpty(vo.getChannelPrincipal(), "渠道负责人不能为空");
    }

    protected static void setDefaultData(ChannelVo vo) {
        if (null == vo.getCreateDate()) {
            vo.setCreateDate(new Date());
        }
        if (StringUtils.isEmpty(vo.getFlag())) {
            vo.setFlag("1");
        }
        if (null == vo.getCreateDate()) {
            vo.setCreateDate(new Date());
        }
        if (null == vo.getSort()) {
            vo.setSort(0);
        }
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }
}
