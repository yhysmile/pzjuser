package com.pzj.customer.entity.pms;

import java.io.Serializable;
import java.util.List;

import com.pzj.common.DateQueryVo;
import com.pzj.util.KeyValueVo;

public class PMSCustomerQueryVo implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 2440458097074279559L;
    /************************************** start_pms客栈的特有属性字段 **********************************************/
    /** 客栈所属景区Id */
    private Long belongScenicId;
    /** 客栈类型列表 */
    private List<Integer> queryHotelType;

    /** 客栈地图 :经度 */
    private Double hotelMapLongitude;

    /** 客栈地图 ：纬度 */
    private Double hotelMapLatitude;

    /** 客栈区域 */
    private String region;

    /** 客栈附近景区 */
    private List<KeyValueVo> scenicInfo;

    /** 客栈房间数 */
    private CustomerNumericQueryVo hotelNum;

    /** 客栈可接待人数 */
    private CustomerNumericQueryVo treatPeopelNum;

    /** 新建/查询参数：客栈设施 */
    private List<KeyValueVo> hotelFacility;

    /** 客栈特点 */
    private List<KeyValueVo> hotelFeature;

    /** pms用户更新通知状态 ：1 目前与业务段数据一致 2 需要更新业务端数据 */
    private String notifyUpdateState;

    /** 查询参数： 时间段 */
    private List<DateQueryVo> queryDateList;

    /** 查询参数： 全文检索 */
    private String searchRemark;

    /** 省 */
    private String province;

    /** 市 */
    private String city;

    /** 县 */
    private String county;

    /** 供应商ID */
    private Long supplierPk;

    /** 分销商地址 */
    private String address;

    /** 查询参数：id集合 */
    private List<Long> queryIdList;

    /**
     * 审核状态
     */
    private String checkStatus;

    /**
     * 是否是主帐户
     */
    private String isRoot;

    /** 用户状态 1 正常、0禁用 */
    private Integer accountState;

    /**
     * 获取
     * 
     * @return belongScenicId
     */
    public Long getBelongScenicId() {
        return belongScenicId;
    }

    /**
     * 设置
     * 
     * @param belongScenicId
     */
    public void setBelongScenicId(Long belongScenicId) {
        this.belongScenicId = belongScenicId;
    }

    /**
     * 获取客栈类型
     * 
     * @return queryHotelType 客栈类型
     */
    public List<Integer> getQueryHotelType() {
        return queryHotelType;
    }

    /**
     * 设置客栈类型
     * 
     * @param queryHotelType
     *            客栈类型
     */
    public void setQueryHotelType(List<Integer> queryHotelType) {
        this.queryHotelType = queryHotelType;
    }

    /**
     * 获取客栈地图:经度
     * 
     * @return hotelMapLongitude 客栈地图:经度
     */
    public Double getHotelMapLongitude() {
        return hotelMapLongitude;
    }

    /**
     * 设置客栈地图:经度
     * 
     * @param hotelMapLongitude
     *            客栈地图:经度
     */
    public void setHotelMapLongitude(Double hotelMapLongitude) {
        this.hotelMapLongitude = hotelMapLongitude;
    }

    /**
     * 获取客栈地图：纬度
     * 
     * @return hotelMapLatitude 客栈地图：纬度
     */
    public Double getHotelMapLatitude() {
        return hotelMapLatitude;
    }

    /**
     * 设置客栈地图：纬度
     * 
     * @param hotelMapLatitude
     *            客栈地图：纬度
     */
    public void setHotelMapLatitude(Double hotelMapLatitude) {
        this.hotelMapLatitude = hotelMapLatitude;
    }

    /**
     * 获取客栈区域
     * 
     * @return region 客栈区域
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置客栈区域
     * 
     * @param region
     *            客栈区域
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 获取客栈附近景区
     * 
     * @return scenicInfo 客栈附近景区
     */
    public List<KeyValueVo> getScenicInfo() {
        return scenicInfo;
    }

    /**
     * 设置客栈附近景区
     * 
     * @param scenicInfo
     *            客栈附近景区
     */
    public void setScenicInfo(List<KeyValueVo> scenicInfo) {
        this.scenicInfo = scenicInfo;
    }

    /**
     * 获取客栈房间数
     * 
     * @return hotelNum 客栈房间数
     */
    public CustomerNumericQueryVo getHotelNum() {
        return hotelNum;
    }

    /**
     * 设置客栈房间数
     * 
     * @param hotelNum
     *            客栈房间数
     */
    public void setHotelNum(CustomerNumericQueryVo hotelNum) {
        this.hotelNum = hotelNum;
    }

    /**
     * 获取客栈可接待人数
     * 
     * @return treatPeopelNum 客栈可接待人数
     */
    public CustomerNumericQueryVo getTreatPeopelNum() {
        return treatPeopelNum;
    }

    /**
     * 设置客栈可接待人数
     * 
     * @param treatPeopelNum
     *            客栈可接待人数
     */
    public void setTreatPeopelNum(CustomerNumericQueryVo treatPeopelNum) {
        this.treatPeopelNum = treatPeopelNum;
    }

    /**
     * 获取新建查询参数：客栈设施
     * 
     * @return hotelFacility 新建查询参数：客栈设施
     */
    public List<KeyValueVo> getHotelFacility() {
        return hotelFacility;
    }

    /**
     * 设置新建查询参数：客栈设施
     * 
     * @param hotelFacility
     *            新建查询参数：客栈设施
     */
    public void setHotelFacility(List<KeyValueVo> hotelFacility) {
        this.hotelFacility = hotelFacility;
    }

    /**
     * 获取客栈特点
     * 
     * @return hotelFeature 客栈特点
     */
    public List<KeyValueVo> getHotelFeature() {
        return hotelFeature;
    }

    /**
     * 设置客栈特点
     * 
     * @param hotelFeature
     *            客栈特点
     */
    public void setHotelFeature(List<KeyValueVo> hotelFeature) {
        this.hotelFeature = hotelFeature;
    }

    /**
     * 获取pms用户更新通知状态：1目前与业务段数据一致2需要更新业务端数据
     * 
     * @return notifyUpdateState pms用户更新通知状态：1目前与业务段数据一致2需要更新业务端数据
     */
    public String getNotifyUpdateState() {
        return notifyUpdateState;
    }

    /**
     * 设置pms用户更新通知状态：1目前与业务段数据一致2需要更新业务端数据
     * 
     * @param notifyUpdateState
     *            pms用户更新通知状态：1目前与业务段数据一致2需要更新业务端数据
     */
    public void setNotifyUpdateState(String notifyUpdateState) {
        this.notifyUpdateState = notifyUpdateState;
    }

    /**
     * 获取查询参数：时间段
     * 
     * @return queryDateList 查询参数：时间段
     */
    public List<DateQueryVo> getQueryDateList() {
        return queryDateList;
    }

    /**
     * 设置查询参数：时间段
     * 
     * @param queryDateList
     *            查询参数：时间段
     */
    public void setQueryDateList(List<DateQueryVo> queryDateList) {
        this.queryDateList = queryDateList;
    }

    /**
     * 获取查询参数：全文检索
     * 
     * @return searchRemark 查询参数：全文检索
     */
    public String getSearchRemark() {
        return searchRemark;
    }

    /**
     * 设置查询参数：全文检索
     * 
     * @param searchRemark
     *            查询参数：全文检索
     */
    public void setSearchRemark(String searchRemark) {
        this.searchRemark = searchRemark;
    }

    /**
     * 获取省
     * 
     * @return province 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     * 
     * @param province
     *            省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市
     * 
     * @return city 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     * 
     * @param city
     *            市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取县
     * 
     * @return county 县
     */
    public String getCounty() {
        return county;
    }

    /**
     * 设置县
     * 
     * @param county
     *            县
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 获取分销商地址
     * 
     * @return address 分销商地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置分销商地址
     * 
     * @param address
     *            分销商地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public Long getSupplierPk() {
        return supplierPk;
    }

    public void setSupplierPk(Long supplierPk) {
        this.supplierPk = supplierPk;
    }

    /**
     * 获取查询参数：id集合
     * 
     * @return queryIdList 查询参数：id集合
     */
    public List<Long> getQueryIdList() {
        return queryIdList;
    }

    /**
     * 设置查询参数：id集合
     * 
     * @param queryIdList
     *            查询参数：id集合
     */
    public void setQueryIdList(List<Long> queryIdList) {
        this.queryIdList = queryIdList;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getIsRoot() {
        return isRoot;
    }

    public void setIsRoot(String isRoot) {
        this.isRoot = isRoot;
    }

    public Integer getAccountState() {
        return accountState;
    }

    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
    }

}
