package com.pzj.channel.service;

import java.util.List;

import com.pzj.base.common.BaseApiService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.customer.entity.Customer;

public interface ChannelService extends BaseApiService<ChannelVo> {
    /**
     * 批量创建渠道
     */
    public Long createBatch(List<ChannelVo> voList) throws Exception;

    /**
     * 获取渠道下的标签
     */
    public ChannelVo getChannelLabelList(Long id) throws Exception;

    /**
     * 获取渠道下的分销商
     * 
     */
    public ChannelVo getChannelCustomerList(Long id) throws Exception;

    /**
     * 根据分销商Id和渠道参数分页查询渠道集合列表
     */
    public PageList<ChannelVo> queryPageByCustomerId(PageModel pager,
            ChannelVo vo, Long customerId) throws Exception;

    /**
     * 批量修改渠道状态
     */
    public Integer updateBatchChannelPrimaryKey(List<Long> ids, String flag);

    /**
     * 更新渠道标签
     * 
     * @param vo
     *            渠道实体
     * @return 更新条数
     * @throws Exception
     * 
     */
    public Integer saveChannelLabel(ChannelVo vo) throws Exception;

    /**
     * 更新渠道分销商
     * 
     * @param vo
     *            渠道实体
     * @return 更新条数
     * @throws Exception
     * 
     */
    public Integer saveChannelCustomer(ChannelVo vo) throws Exception;
    /**
     * 根据供应商ID获取该供应商创建的所有渠道
     */
    public PageList<ChannelVo> queryPageBySupplierId(PageModel pager, Long supplierId) throws Exception;

    /**
     * 移除渠道
     *
     * 实际更新其状态为删除状态。
     * @param channelId
     * @return
     */
    boolean removeChannel(Long channelId);

    /**
     * 绑定渠道与分销商
     *
     * @param channelId
     * @param distributorsIds
     * @return
     */
    boolean bindingDistributors(Long channelId, List<Long> distributorsIds, Long supplierId);

    /**
     * 解绑渠道与分销商
     * @param channelId
     * @param distributorsIds
     * @return
     */
    boolean unbundingDistributors(Long channelId, List<Long> distributorsIds, Long supplierId);

    /**
     * 查询渠道，同时如果指定了分销商参数，那么渠道必须包含符合条件的分销商。
     * @param channelParam
     * @param distributorParam
     * @param pageModel
     * @return
     */
    PageList<ChannelVo> queryChannelContainDistributor(ChannelVo channelParam, Customer distributorParam, PageModel pageModel);
}
