package com.pzj.base.service.sys;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysLabel;
import com.pzj.base.entity.SysUser;
import com.pzj.framework.context.Result;
import com.pzj.framework.entity.QueryResult;

;

public interface IChannelService extends IBaseUserService<SysChannel> {

	/**
	 * 添加渠道及渠道标签关系信息
	 * 
	 * @param channel
	 *            渠道实体
	 * 
	 * @param channelLabelList
	 *            渠道标签实体列表
	 * 
	 * @return 渠道主键Id
	 */
	Long addChannelAndAuth(SysChannel channel, List<SysLabel> channelLabelList);

	/**
	 * 编辑保存渠道及渠道标签关系信息
	 * 
	 * @param vo
	 *            渠道实体
	 * 
	 * @param records
	 *            渠道标签实体列表
	 * 
	 * @return 更新条数
	 * 
	 */
	Long saveChannelAndChannelLabel(SysChannel vo, List<SysLabel> records, boolean isNeedUpdate);

	/**
	 * 编辑保存渠道及渠道分销商关系信息
	 * 
	 * @param vo
	 *            渠道实体
	 * 
	 * @param records
	 *            分销商实体列表
	 * 
	 * @return 更新条数
	 * 
	 */
	Integer saveChannelAndUser(SysChannel vo, List<SysUser> records, boolean isNeedUpdate);

	/**
	 * 通过关系表中的objId获取标签分页集合
	 * 
	 */
	PageList<SysChannel> queryPageByObjId(PageModel pager, SysChannel record, Long objId, String refType);

	/**
	 * 通过关系表中的refId获取标签分页集合
	 * 
	 */

	PageList<SysChannel> queryPageByRefId(PageModel pager, SysChannel record, Long refId, String refType);

	/**
	 * 定制查询 根据渠道信息和产品Id分页获取与产品Id未关联的渠道列表
	 * 
	 */
	PageList<SysChannel> queryPageNotByProductId(PageModel pager, SysChannel record, Long productId);

	/**
	 *
	 * 通过供应商ID查询其所有的渠道信息
	 */
	PageList<SysChannel> queryPageBySupplierId(PageModel pager, Long supplierId);

	/**
	 * 通用渠道参数和分销商id查询渠道列表
	 * 
	 */
	List<SysChannel> queryPageByUserId(PageModel pager, SysChannel param, Long userId);

	/**
	 * 通过政策id集合获取有效渠道集合
	 */
	List<SysChannel> findValidChannelsByIds(List<Long> channelIds);

	/**
	 * 查询渠道，同时如果指定了分销商参数，那么渠道必须包含符合条件的分销商。
	 * @param channelParam
	 * @param distributorParam
	 * @param pageModel
	 * @return
	 */
	Result<QueryResult<SysChannel>> queryChannelContainUser(SysChannel channelParam, SysUser distributorParam, PageModel pageModel, List<Long> tmpDelIds, List<Long> tmpAddIds);

	/**
	 * 查询用户关联的渠道，根据已关联的not in 未关联的
	 * @param channelParam
	 * @param distributorParam
	 * @param pageModel
	 * @return
	 */
	Result<QueryResult<SysChannel>> queryChannelsUserNotJoin(SysChannel channelParam, SysUser distributorParam, PageModel pageModel,List<Long> channelIds);

	/**
	 * 用户或者渠道批量操作关系
	 * @param objectId
	 * @param addObjectIds
	 * @param delObjectIds
	 * @param operId
	 * @return
	 */
	Result<Boolean> modifyChannelUserOwned(Long objectId, List<Long> addObjectIds, List<Long> delObjectIds,
			Long operId,Long supplierId,String operType);
}
