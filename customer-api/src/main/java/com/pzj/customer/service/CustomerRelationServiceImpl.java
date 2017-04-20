package com.pzj.customer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.service.sys.IUserService;
import com.pzj.framework.context.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUserRelation;
import com.pzj.base.service.sys.ISysUserRelationService;
import com.pzj.customer.entity.CustomerRelation;

@Service
public class CustomerRelationServiceImpl implements CustomerRelationService {

    @Autowired
    private ISysUserRelationService sysUserRelationService;

    @Autowired
    private IUserService userService;

    @Override
    public void insertBatch(Long userId, List<Long> relIdList, String relType) {
        insertBatch(userId, relIdList, relType, null);
    }

    @Override
    public void insertBatch(Long userId, List<Long> relIdList, String relType, Long createBy) {
        List<SysUserRelation> relList = createSysUserRelations(userId, relIdList, relType, createBy);
        if (relList == null) return;
        sysUserRelationService.insertBatch(relList);
    }

    private List<SysUserRelation> createSysUserRelations(Long userId, List<Long> relIdList, String relType, Long createBy) {
        if (userId == null || relIdList == null || StringUtils.isEmpty(relType)) {
            return null;
        }

        List<SysUserRelation> relList = new ArrayList<>(relIdList.size());

        Date currentDate = new Date();
        for (Long relId : relIdList) {
            SysUserRelation rel = new SysUserRelation();
            rel.setUserId(userId);
            rel.setRelUserId(relId);
            rel.setRelType(relType);
            rel.setCreateBy(createBy);
            rel.setCreateDate(currentDate);
            relList.add(rel);
        }
        return relList;
    }

    @Override
    public void deleteBatch(Long userId, List<Long> relIdList, String relType) {
        List<SysUserRelation> relList = createSysUserRelations(userId, relIdList, relType, null);
        if (relList == null) return;
        sysUserRelationService.delAuthBatch(relList);
    }

    public PageList<CustomerRelation> queryPageByParamMap(PageModel pager, CustomerRelation vo) throws Exception {
        PageList<SysUserRelation> userRelList = sysUserRelationService.queryAuthPageByParamMap(pager, CustomerRelationUtil.convert2Entity(vo));

        PageList<CustomerRelation> resultList = new PageList<>();

        resultList.setPageBean(userRelList.getPageBean());

        if (userRelList.getResultList() != null) {
            List<CustomerRelation> voList = CustomerRelationUtil.convert2VoList(userRelList.getResultList());
            resultList.setResultList(voList);
        }

        return resultList;
    }

    @Override
    public void bindingSupplierAndDirctSingDistributors(Long userId, List<Long> relIdList, Long createBy) {
        bindBatch(userId, relIdList, UserGlobalDict.UserRelation.SUPPLIER_DIRECTS_RESELLER, createBy);
    }

    private void bindBatch(Long userId, List<Long> relIdList, String relType, Long createBy) {
        List<SysUserRelation> relList = createSysUserRelations(userId, relIdList, relType, createBy);
        if (relList == null) return;
        sysUserRelationService.createBatchNoRepeat(relList);
    }

    @Override
    public void unbundingSupplierAndDirctSingDistributors(Long userId, List<Long> relIdList) {
        deleteBatch(userId, relIdList, UserGlobalDict.UserRelation.SUPPLIER_DIRECTS_RESELLER);
    }

    @Override
    public Result<Boolean> unbundingSupplierAndDirctSingDistributors(Long supplierId, Long distributorsId) {
        return userService.unbundingSupplierAndDirctSingDistributors(supplierId, distributorsId);
    }
}
