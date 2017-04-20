/*
 * ProductInfo.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-30 created
 */
package com.pzj.base.entity.product;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.global.GlobalDict;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.query.DateQueryParam;

/**
 * 产品信息表 票之家公司 ----------------------* 2015-09-30created
 */
public class ProductInfo extends BaseEntity implements Serializable {

    private static final long    serialVersionUID = 8831749413415617509L;

    /**
     * 扩展属性，不持久化，产品组id集合
     */
    private List<Long>           ids;

    /**
     * 扩展属性，不持久化，产品id集合
     */
    private List<Long>           subIds;

    /**
     * 扩展属性，不持久化，产品id集合
     */
    private String               searchKey;

    /**
     * 扩展属性，只在程序中使用
     */
    private String               tempNo;

    /** 备注名称 */
    private String               name;

    /** 产品类别1，普通 ，2，剧场 3，定向返利产品 ，4，普通票联票子票5，积分票联票子票 */
    private Integer              productType;

    /**
     * 多个产品类别:
     * 常量 ：GlobalDict.ProductCategory
     * 只用于查询
     */
    private List<Integer>        productTypes;

    /** 缩略图 */
    private String               releaseThurl;

    /** 开始时间 */
    private String               startTime;

    /** 结束时间 */
    private String               endTime;

    /** 内部序号 */
    private String               productNo;

    /** 当日时间节点 */
    private Integer              hourNode;

    /**  */
    private Integer              minutesNode;

    /** 总库存 */
    private Integer              productSumRepertory;

    /** 可用库存 */
    private Integer              productUsableRepertory;

    /**  */
    private String               createBy;

    /**  */
    private java.util.Date       createDate;

    /**  */
    private String               updateBy;

    /**  */
    private java.util.Date       updateDate;

    /** 排序 */
    private Integer              sort;

    /** 使用状态1启用0禁用2删除 */
    private String               flag;

    /** 介绍 */
    private String               remarks;

    /** 组合名称 */
    private String               combinationName;

    /** 组合产品编号 */
    private String               combinationCode;

    /** 短信模板 */
    private String               reeaseMessage;

    /** 产品介绍 */
    private String               reeaseInfo;

    private String               supplierId;

    /**
     * 游玩时间的开始时间的方式
     */
    private Integer              playtimeMode;

    /**
     * 游玩时间的数量
     */
    private Integer              playtimeValue;

    /**
     * 游玩时间的单位
     */
    private Integer              playtimeUnit;

    /**
     * 领票类型
     * <br/>
     * 请参考常量{@link GlobalDict.GainType}
     */
    private Integer              gainType;

    /**
     * 领票人数限制，如果为-1表示不限制
     */
    private Integer              gainPeopleNum;

    /**
     * 同取票人领票时间范围单位
     * <br/>
     * 请参考{@link GlobalParam.DateTime} 中的常量
     */
    private Integer              gainPeopleTimeLimitUnit;

    /**
     * 同取票人领票时间范围数量
     */
    private Integer              gainPeopleTimeLimitValue;

    /**
     * 同取票人领票时间范围值，如果为-1，则不限制
     */
    private Integer              gainPeopleTimePurchaseNum;

    /**
     * 同订单最小起定量
     */
    private Integer              minPurchaseNumInOrder;

    /**
     * 产品是否需要绑定景点
     */
    private Integer              isNeedScenic;
    /**
     * 场次名称
     */
    private String               rondaName;
    /**
     * 入园方式
     */
    private String               checkInType;
    /**
     * 入园地址
     */
    private String               checkinAddress;
    /**
     * 产品销售开始日期
     */
    private Date                 saleStartDate;
    /**
     * 产品销售结束日期
     */
    private Date                 saleEndDate;
    /**
     * 下单是否填写游玩时间
     */
    private Integer              isNeedPlaytime;
    /**
     * 不填写游玩时间下单计算时间类型
     */
    private Integer              noPlaytimeOrdertimeType;
    /**
     * 游玩时间/下单后时间数值
     */
    private Integer              ordertimeValue;
    /**
     * 游玩时间/下单后时间单位
     */
    private Integer              ordertimeUnit;
    /**
     * 一句话特色
     */
    private String               oneWordFeature;
    /**
     * 产品详情
     */
    private String               productInfoDetail;
    /**
     * 预订须知
     */
    private String               orderInfo;
    /**
     * 费用说明
     */
    private String               expenseInfo;
    /**
     * 销售技巧
     */
    private String               salesmanship;
    /**
     * 重要条款
     */
    private String               importantClause;
    /**
     * 注意事项
     */
    private String               attentions;
    /**
     * 使用方法
     */
    private String               useMethod;
    /**
     * 产品可用开始日期
     */
    private Date                 startDate;
    /**
     * 产品可用结束日期
     */
    private Date                 endDate;
    /**
     * 产品图片列表
     */
    private String               photoinfoId;
    /**
     * SKU分组类型（父产品、 组合产品）
     */
    private String               skuGrouping;
    /**
     * URL
     */
    private String               moreInfoUrl;
    /**
     * 省
     */
    private String               province;
    /**
     * 市
     */
    private String               city;
    /**
     * 县
     */
    private String               county;

    /**
     * 通用端产品上skuId
     * 
     */
    private String               skuId;

    /**
     * 唯一索引
     */
    private Integer              hashCode;

    /**
     * 产品销售日期段查询
     */
    private DateQueryParam       saleDateQuery;

    /**
     * 产品可用日期查询
     */
    private DateQueryParam       availableDateQuery;

    /** 设置 短信模板 */
    public void setReeaseMessage(String reeaseMessage) {
        this.reeaseMessage = reeaseMessage;
    }

    /** 得到 短信模板 */
    public String getReeaseMessage() {
        return reeaseMessage;
    }

    /** 设置 产品介绍 */
    public void setReeaseInfo(String reeaseInfo) {
        this.reeaseInfo = reeaseInfo;
    }

    /** 得到 产品介绍 */
    public String getReeaseInfo() {
        return reeaseInfo;
    }

    /** 设置 备注名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 得到 备注名称 */
    public String getName() {
        return name;
    }

    /** 设置 产品类别1，普通 ，2，剧场 3，定向返利产品 ，4，普通票联票子票5，积分票联票子票 */
    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    /** 得到 产品类别1，普通 ，2，剧场 3，定向返利产品 ，4，普通票联票子票5，积分票联票子票 */
    public Integer getProductType() {
        return productType;
    }

    /** 设置 缩略图 */
    public void setReleaseThurl(String releaseThurl) {
        this.releaseThurl = releaseThurl;
    }

    /** 得到 缩略图 */
    public String getReleaseThurl() {
        return releaseThurl;
    }

    /** 设置 开始时间 */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /** 得到 开始时间 */
    public String getStartTime() {
        return startTime;
    }

    /** 设置 结束时间 */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /** 得到 结束时间 */
    public String getEndTime() {
        return endTime;
    }

    /** 设置 内部序号 */
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    /** 得到 内部序号 */
    public String getProductNo() {
        return productNo;
    }

    /** 设置 当日时间节点 */
    public void setHourNode(Integer hourNode) {
        this.hourNode = hourNode;
    }

    /** 得到 当日时间节点 */
    public Integer getHourNode() {
        return hourNode;
    }

    /** 设置 */
    public void setMinutesNode(Integer minutesNode) {
        this.minutesNode = minutesNode;
    }

    /** 得到 */
    public Integer getMinutesNode() {
        return minutesNode;
    }

    /** 设置 总库存 */
    public void setProductSumRepertory(Integer productSumRepertory) {
        this.productSumRepertory = productSumRepertory;
    }

    /** 得到 总库存 */
    public Integer getProductSumRepertory() {
        return productSumRepertory;
    }

    /** 设置 可用库存 */
    public void setProductUsableRepertory(Integer productUsableRepertory) {
        this.productUsableRepertory = productUsableRepertory;
    }

    /** 得到 可用库存 */
    public Integer getProductUsableRepertory() {
        return productUsableRepertory;
    }

    /** 设置 */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /** 得到 */
    public String getCreateBy() {
        return createBy;
    }

    /** 设置 */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    /** 得到 */
    public java.util.Date getCreateDate() {
        return createDate;
    }

    /** 设置 */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /** 得到 */
    public String getUpdateBy() {
        return updateBy;
    }

    /** 设置 */
    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    /** 得到 */
    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    /** 设置 排序 */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /** 得到 排序 */
    public Integer getSort() {
        return sort;
    }

    /** 设置 使用状态1启用0禁用2删除 */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /** 得到 使用状态1启用0禁用2删除 */
    public String getFlag() {
        return flag;
    }

    /** 设置 介绍 */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /** 得到 介绍 */
    public String getRemarks() {
        return remarks;
    }

    /** 设置 组合名称 */
    public void setCombinationName(String combinationName) {
        this.combinationName = combinationName;
    }

    /** 得到 组合名称 */
    public String getCombinationName() {
        return combinationName;
    }

    /** 设置 组合产品编号 */
    public void setCombinationCode(String combinationCode) {
        this.combinationCode = combinationCode;
    }

    /** 得到 组合产品编号 */
    public String getCombinationCode() {
        return combinationCode;
    }

    /** 扩展属性，不持久化，id集合 */
    public List<Long> getIds() {
        return ids;
    }

    /** 扩展属性，不持久化，id集合 */
    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    /** 扩展属性，只在程序中使用 */
    public String getTempNo() {
        return tempNo;
    }

    /** 扩展属性，只在程序中使用 */
    public void setTempNo(String tempNo) {
        this.tempNo = tempNo;
    }

    /** supplierId */
    public String getSupplierId() {
        return supplierId;
    }

    /** supplierId */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("name:").append(this.getName()).append(",");
        strBuff.append("productType:").append(this.getProductType()).append(",");
        strBuff.append("releaseThurl:").append(this.getReleaseThurl()).append(",");
        strBuff.append("startTime:").append(this.getStartTime()).append(",");
        strBuff.append("endTime:").append(this.getEndTime()).append(",");
        strBuff.append("productNo:").append(this.getProductNo()).append(",");
        strBuff.append("hourNode:").append(this.getHourNode()).append(",");
        strBuff.append("minutesNode:").append(this.getMinutesNode()).append(",");
        strBuff.append("productSumRepertory:").append(this.getProductSumRepertory()).append(",");
        strBuff.append("productUsableRepertory:").append(this.getProductUsableRepertory())
            .append(",");
        strBuff.append("createBy:").append(this.getCreateBy()).append(",");
        strBuff.append("createDate:").append(this.getCreateDate()).append(",");
        strBuff.append("updateBy:").append(this.getUpdateBy()).append(",");
        strBuff.append("updateDate:").append(this.getUpdateDate()).append(",");
        strBuff.append("sort:").append(this.getSort()).append(",");
        strBuff.append("flag:").append(this.getFlag()).append(",");
        strBuff.append("remarks:").append(this.getRemarks()).append(",");
        strBuff.append("combinationName:").append(this.getCombinationName()).append(",");
        strBuff.append("combinationCode:").append(this.getCombinationCode());
        strBuff.append("reeaseMessage:").append(this.getReeaseMessage()).append(",");
        strBuff.append("reeaseInfo:").append(this.getReeaseInfo()).append(",");
        strBuff.append("supplierId:").append(this.getSupplierId()).append(",");
        strBuff.append("}");
        return strBuff.toString();
    }

    public Integer getPlaytimeMode() {
        return playtimeMode;
    }

    public void setPlaytimeMode(Integer playtimeMode) {
        this.playtimeMode = playtimeMode;
    }

    public Integer getPlaytimeValue() {
        return playtimeValue;
    }

    public void setPlaytimeValue(Integer playtimeValue) {
        this.playtimeValue = playtimeValue;
    }

    public Integer getPlaytimeUnit() {
        return playtimeUnit;
    }

    public void setPlaytimeUnit(Integer playtimeUnit) {
        this.playtimeUnit = playtimeUnit;
    }

    public Integer getGainType() {
        return gainType;
    }

    public void setGainType(Integer gainType) {
        this.gainType = gainType;
    }

    public Integer getGainPeopleNum() {
        return gainPeopleNum;
    }

    public void setGainPeopleNum(Integer gainPeopleNum) {
        this.gainPeopleNum = gainPeopleNum;
    }

    public Integer getGainPeopleTimeLimitUnit() {
        return gainPeopleTimeLimitUnit;
    }

    public void setGainPeopleTimeLimitUnit(Integer gainPeopleTimeLimitUnit) {
        this.gainPeopleTimeLimitUnit = gainPeopleTimeLimitUnit;
    }

    public Integer getGainPeopleTimeLimitValue() {
        return gainPeopleTimeLimitValue;
    }

    public void setGainPeopleTimeLimitValue(Integer gainPeopleTimeLimitValue) {
        this.gainPeopleTimeLimitValue = gainPeopleTimeLimitValue;
    }

    public Integer getMinPurchaseNumInOrder() {
        return minPurchaseNumInOrder;
    }

    public void setMinPurchaseNumInOrder(Integer minPurchaseNumInOrder) {
        this.minPurchaseNumInOrder = minPurchaseNumInOrder;
    }

    public Integer getGainPeopleTimePurchaseNum() {
        return gainPeopleTimePurchaseNum;
    }

    public void setGainPeopleTimePurchaseNum(Integer gainPeopleTimePurchaseNum) {
        this.gainPeopleTimePurchaseNum = gainPeopleTimePurchaseNum;
    }

    public Integer getIsNeedScenic() {
        return isNeedScenic;
    }

    public void setIsNeedScenic(Integer isNeedScenic) {
        this.isNeedScenic = isNeedScenic;
    }

    public String getRondaName() {
        return rondaName;
    }

    public void setRondaName(String rondaName) {
        this.rondaName = rondaName;
    }

    public String getCheckInType() {
        return checkInType;
    }

    public void setCheckInType(String checkInType) {
        this.checkInType = checkInType;
    }

    public String getCheckinAddress() {
        return checkinAddress;
    }

    public void setCheckinAddress(String checkinAddress) {
        this.checkinAddress = checkinAddress;
    }

    public Date getSaleStartDate() {
        return saleStartDate;
    }

    public void setSaleStartDate(Date saleStartDate) {
        this.saleStartDate = saleStartDate;
    }

    public Date getSaleEndDate() {
        return saleEndDate;
    }

    public void setSaleEndDate(Date saleEndDate) {
        this.saleEndDate = saleEndDate;
    }

    public Integer getIsNeedPlaytime() {
        return isNeedPlaytime;
    }

    public void setIsNeedPlaytime(Integer isNeedPlaytime) {
        this.isNeedPlaytime = isNeedPlaytime;
    }

    public Integer getNoPlaytimeOrdertimeType() {
        return noPlaytimeOrdertimeType;
    }

    public void setNoPlaytimeOrdertimeType(Integer noPlaytimeOrdertimeType) {
        this.noPlaytimeOrdertimeType = noPlaytimeOrdertimeType;
    }

    public Integer getOrdertimeValue() {
        return ordertimeValue;
    }

    public void setOrdertimeValue(Integer ordertimeValue) {
        this.ordertimeValue = ordertimeValue;
    }

    public Integer getOrdertimeUnit() {
        return ordertimeUnit;
    }

    public void setOrdertimeUnit(Integer ordertimeUnit) {
        this.ordertimeUnit = ordertimeUnit;
    }

    public String getOneWordFeature() {
        return oneWordFeature;
    }

    public void setOneWordFeature(String oneWordFeature) {
        this.oneWordFeature = oneWordFeature;
    }

    public String getProductInfoDetail() {
        return productInfoDetail;
    }

    public void setProductInfoDetail(String productInfoDetail) {
        this.productInfoDetail = productInfoDetail;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getExpenseInfo() {
        return expenseInfo;
    }

    public void setExpenseInfo(String expenseInfo) {
        this.expenseInfo = expenseInfo;
    }

    public String getSalesmanship() {
        return salesmanship;
    }

    public void setSalesmanship(String salesmanship) {
        this.salesmanship = salesmanship;
    }

    public String getImportantClause() {
        return importantClause;
    }

    public void setImportantClause(String importantClause) {
        this.importantClause = importantClause;
    }

    public String getAttentions() {
        return attentions;
    }

    public void setAttentions(String attentions) {
        this.attentions = attentions;
    }

    public String getUseMethod() {
        return useMethod;
    }

    public void setUseMethod(String useMethod) {
        this.useMethod = useMethod;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPhotoinfoId() {
        return photoinfoId;
    }

    public void setPhotoinfoId(String photoinfoId) {
        this.photoinfoId = photoinfoId;
    }

    public String getSkuGrouping() {
        return skuGrouping;
    }

    public void setSkuGrouping(String skuGrouping) {
        this.skuGrouping = skuGrouping;
    }

    public String getMoreInfoUrl() {
        return moreInfoUrl;
    }

    public void setMoreInfoUrl(String moreInfoUrl) {
        this.moreInfoUrl = moreInfoUrl;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public List<Long> getSubIds() {
        return subIds;
    }

    public void setSubIds(List<Long> subIds) {
        this.subIds = subIds;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public Integer getHashCode() {
        return hashCode;
    }

    public void setHashCode(Integer hashCode) {
        this.hashCode = hashCode;
    }

    public DateQueryParam getSaleDateQuery() {
        return saleDateQuery;
    }

    public void setSaleDateQuery(DateQueryParam saleDateQuery) {
        this.saleDateQuery = saleDateQuery;
    }

    public List<Integer> getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(List<Integer> productTypes) {
        this.productTypes = productTypes;
    }

    public DateQueryParam getAvailableDateQuery() {
        return availableDateQuery;
    }

    public void setAvailableDateQuery(DateQueryParam availableDateQuery) {
        this.availableDateQuery = availableDateQuery;
    }
}