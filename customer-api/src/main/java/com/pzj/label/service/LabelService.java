package com.pzj.label.service;

import java.util.List;

import com.pzj.base.common.BaseApiService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.customer.entity.Customer;
import com.pzj.label.entity.LabelVo;

/**
 * 标签api接口
 * 
 * @author apple
 * 
 */
public interface LabelService extends BaseApiService<LabelVo> {

    /**
     * 获取标签集合，通过不同参数，查询不同纬度下的数据
     * 
     * @return
     */
    List<LabelVo> labelList(LabelVo vo) throws Exception;

    /**
     * 根据渠道Id和标签多参数分页查询标签列表
     * 
     */
    PageList<LabelVo> queryPageByChannelId(PageModel pager, LabelVo vo,
            Long channelId) throws Exception;

    /**
     * 根据分销商Id和标签多参数分页查询标签列表
     * 
     */
    PageList<LabelVo> queryPageByCustomerId(PageModel pager, LabelVo vo,
            Long customerId) throws Exception;

    /**
     * <h3>查询用户的标签
     * <p>
     * 根据用户ID，查询此用户的所有关联的标签。
     * 
     * @param customerId
     *            用户id
     * @return 标签集合
     * @throws Exception
     */
    List<LabelVo> findByCustomer(Long customerId) throws Exception;

   

}
