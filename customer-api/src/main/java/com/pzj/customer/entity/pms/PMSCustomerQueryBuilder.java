package com.pzj.customer.entity.pms;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.query.NumericQueryParam;
import com.pzj.base.entity.query.NumericQueryVo;
import com.pzj.common.DateQueryVo;
import com.pzj.util.KeyValueVo;

public class PMSCustomerQueryBuilder {
    public final static PMSCustomerQueryBuilder builder = new PMSCustomerQueryBuilder();

    /**************************************
     * end_pms客栈的特有属性字段
     * 
     * @throws Exception
     **********************************************/
    public SysUser changeQueryTSysUser(PMSCustomerQueryVo vo) throws Exception {
        if (vo == null) {
            return null;
        }
        SysUser user = new SysUser();
        user.setAddress(vo.getAddress());
        user.setBelongScenicId(vo.getBelongScenicId());
        user.setCity(vo.getCity());
        user.setCounty(vo.getCounty());
        user.setHotelFacility(KeyValueVo.getString(vo.getHotelFacility()));
        user.setHotelFeature(KeyValueVo.getString(vo.getHotelFeature()));

        user.setHotelMapLatitude(vo.getHotelMapLatitude());
        user.setHotelMapLongitude(vo.getHotelMapLongitude());

        user.setQueryHotelType(vo.getQueryHotelType());
        user.setNotifyUpdateState(vo.getNotifyUpdateState());
        user.setProvince(vo.getProvince());
        user.setRegion(vo.getRegion());
        user.setScenicInfo(KeyValueVo.getString(vo.getScenicInfo()));
        if (StringUtils.isNotBlank(vo.getSearchRemark())) {
            user.setSearchRemark(vo.getSearchRemark() + "%");
        }

        user.setCheckStatus(vo.getCheckStatus());
        user.setIsRoot(vo.getIsRoot());
        user.setAccountState(vo.getAccountState());

        user.setQueryIdList(vo.getQueryIdList());

        user.setQueryDateList(DateQueryVo.cList2SList(vo.getQueryDateList()));

        // start数值查询参数封装********************************************************************************//
        List<NumericQueryVo> numericList = getNumericQueryParam(vo);
        user.setQueryNumericList(numericList);

        // end数值查询参数封装********************************************************************************//

        return user;

    }

    private List<NumericQueryVo> getNumericQueryParam(PMSCustomerQueryVo vo) {

        if (vo == null) {
            return null;
        }
        List<NumericQueryVo> resultList = new ArrayList<NumericQueryVo>();
        if (vo.getHotelNum() != null) {
            CustomerNumericQueryVo hotelNum = vo.getHotelNum();

            resultList.add(hotelNum.changeTNumericQueryVo(NumericQueryParam.SysUserNumericQuery.hotelNum));
        }

        if (vo.getTreatPeopelNum() != null) {
            CustomerNumericQueryVo treatPeopelNum = vo.getTreatPeopelNum();
            resultList.add(treatPeopelNum.changeTNumericQueryVo(NumericQueryParam.SysUserNumericQuery.treatPeopelNum));
        }

        if (resultList.isEmpty()) {
            return null;
        }
        return resultList;
    }
}
