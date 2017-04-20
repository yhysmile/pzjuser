package com.pzj.dict.entity;

import static com.pzj.util.ServiceUtil.checkNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.SysDict;

public class Dict implements Serializable, Comparable<Dict> {

    private static final long serialVersionUID = -6768267570999255954L;

    /** 主键ID */
    private Long id;

    /** 显示名称 */
    private String label;

    /** 值 */
    private String value;

    /** 类型 */
    private String type;

    /** 纬度 */
    private String description;

    /** 排序 */
    private Integer sort;

    /** 创建时间 */
    private Date createDate;

    /** 创建人 */
    private String createBy;

    /** 更新人 */
    private String updateBy;

    /** 更新时间 */
    private Date updateDate;

    /** 介绍 */
    private String remarks;

    /** 状态 */
    private String delFlag;

    /** 数据源 */
    private String dataSource;

    /**
     * 获取主键ID
     * 
     * @return id 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键ID
     * 
     * @param id
     *            主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取显示名称
     * 
     * @return label 显示名称
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置显示名称
     * 
     * @param label
     *            显示名称
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * 获取值
     * 
     * @return value 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置值
     * 
     * @param value
     *            值
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取类型
     * 
     * @return type 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     * 
     * @param type
     *            类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取纬度
     * 
     * @return description 纬度
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置纬度
     * 
     * @param description
     *            纬度
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取排序
     * 
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     * 
     * @param sort
     *            排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取创建时间
     * 
     * @return createDate 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     * 
     * @param createDate
     *            创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取创建人
     * 
     * @return createBy 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     * 
     * @param createBy
     *            创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取更新人
     * 
     * @return updateBy 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     * 
     * @param updateBy
     *            更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     * 
     * @return updateDate 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     * 
     * @param updateDate
     *            更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取介绍
     * 
     * @return remarks 介绍
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置介绍
     * 
     * @param remarks
     *            介绍
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取状态
     * 
     * @return delFlag 状态
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置状态
     * 
     * @param delFlag
     *            状态
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取数据源
     * 
     * @return dataSource 数据源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 设置数据源
     * 
     * @param dataSource
     *            数据源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public static SysDict createNewSysDict(Dict dict) throws Exception {
        checkNull(dict, "Dict不能为null");
        if (null == dict.getId()) {
            // 验证
            validData(dict);

            // 设置默认参数
            setDefaultData(dict);
        }
        // 转换
        return changeTSysDict(dict);
    }

    public static SysDict changeTSysDict(Dict dict) throws Exception {
        SysDict sysDict = new SysDict();
        sysDict.setId(dict.getId());
        sysDict.setCreateBy(dict.getCreateBy());
        sysDict.setCreateDate(dict.getCreateDate());
        sysDict.setDataSource(dict.getDataSource());
        sysDict.setDelFlag(dict.getDelFlag());
        sysDict.setDescription(dict.getDescription());
        sysDict.setDictId(dict.getId());
        sysDict.setLabel(dict.getLabel());
        sysDict.setRemarks(dict.getRemarks());
        sysDict.setSort(dict.getSort());
        sysDict.setType(dict.getType());
        sysDict.setUpdateBy(dict.getUpdateBy());
        sysDict.setUpdateDate(dict.getUpdateDate());
        sysDict.setValue(dict.getValue());
        return sysDict;
    }

    public static Dict sysDict2Dict(SysDict sysDict) throws Exception {
        Dict dict = new Dict();
        dict.setId(sysDict.getId());
        dict.setCreateBy(sysDict.getCreateBy());
        dict.setCreateDate(sysDict.getCreateDate());
        dict.setDataSource(sysDict.getDataSource());
        dict.setDelFlag(sysDict.getDelFlag());
        dict.setDescription(sysDict.getDescription());
        dict.setLabel(sysDict.getLabel());
        dict.setRemarks(sysDict.getRemarks());
        dict.setSort(sysDict.getSort());
        dict.setType(sysDict.getType());
        dict.setUpdateBy(sysDict.getUpdateBy());
        dict.setUpdateDate(sysDict.getUpdateDate());
        dict.setValue(sysDict.getValue());
        return dict;

    }

    public static List<SysDict> cList2SList(List<Dict> dictList)
            throws Exception {
        List<SysDict> sysDictList = null;
        if (dictList != null) {
            sysDictList = new ArrayList<SysDict>();
            for (Dict dict : dictList) {
                SysDict sysDict = createNewSysDict(dict);
                sysDictList.add(sysDict);
            }
        }
        return sysDictList;
    }

    public static List<Dict> sList2CList(List<SysDict> sysDictList)
            throws Exception {
        List<Dict> dictList = null;
        if (sysDictList != null) {
            dictList = new ArrayList<Dict>();
            for (SysDict sysDict : sysDictList) {
                Dict dict = sysDict2Dict(sysDict);
                dictList.add(dict);
            }
        }
        return dictList;
    }

    public static String validData(Dict dict) {
        if (dict == null) {
            return "字典实体不能为空";
        }
        if (StringUtils.isBlank(dict.getLabel())) {
            return "字典名称不能为空";
        }
        if (StringUtils.isBlank(dict.getValue())) {
            return "字典值不能为空";
        }
        if (StringUtils.isBlank(dict.getType())) {
            return "字典类型不能为空";
        }

        return null;
    }

    protected static void setDefaultData(Dict dict) {
        if (null == dict.getCreateDate()) {
            dict.setCreateDate(new Date());
        }
        if (StringUtils.isEmpty(dict.getDelFlag())) {
            dict.setDelFlag(String.valueOf(GlobalParam.FLAG.start()));
        }
    }

    public int compareTo(Dict o) {
        int i = 0;
        if (o == null) {
            i = 1;
        } else {
            if (this.getSort() == null) {
                i =  1;
            } else if (o.getSort() == null) {
                i =  -1;
            }

            if (i == 0){
                if (this.getSort() > o.getSort()) {
                    i =  1;
                } else if(this.getSort() < o.getSort()){
                    i =  -1;
                } else if (this.getId() > o.getId()){
                    i =  1;
                } else {
                    i =  -1;
                }
            }
        }
        System.out.println("====== " + i);
        return i;
    }

}
