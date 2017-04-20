package com.pzj.customer.service;

import java.util.List;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.customer.entity.CustomerRelation;
import com.pzj.framework.context.Result;

public interface CustomerRelationService {
    /**
     * 批量新增,修改也用这个接口 每次保存前会根据userId和relType删除以前的数据 关联类型（1供应商关系，2常用部门）
     * 
     */
    void insertBatch(Long userId, List<Long> relIdList, String relType);
    /**
     * 批量新增,修改也用这个接口 每次保存前会根据userId和relType删除以前的数据 关联类型（1供应商关系，2常用部门）
     *
     */
    void insertBatch(Long userId, List<Long> relIdList, String relType, Long createBy);

    /**
     * 
     * @param userId
     * @param relId
     * @param relType
     */
    void deleteBatch(Long userId, List<Long> relId, String relType);

    PageList<CustomerRelation> queryPageByParamMap(PageModel pager,
            CustomerRelation vo) throws Exception;

    /**
     * 绑定供应商与直签分销商
     * @param userId 供应商id
     * @param relIdList 分销商id集合
     * @param createBy 创建人id
     */
    void bindingSupplierAndDirctSingDistributors(Long userId, List<Long> relIdList, Long createBy);

    /**
     * 解绑供应商与直签分销商
     * @param userId 供应商id
     * @param relIdList 分销商id集合
     */
    void unbundingSupplierAndDirctSingDistributors(Long userId, List<Long> relIdList);

    Result<Boolean> unbundingSupplierAndDirctSingDistributors(Long supplierId, Long distributorsId);
}
