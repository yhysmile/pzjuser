package com.pzj.core.customer.visitor;

import com.pzj.base.common.global.GlobalParam;
import com.pzj.core.customer.profile.VisitorEntity;
import com.pzj.core.customer.write.VisitorWriteMapper;
import com.pzj.framework.idgen.IDGenerater;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2017-2-23.
 */
@Service("clientWriteEngine")
public class VisitorWriteEngine {
    @Resource
    private VisitorWriteMapper visitorWriteMapper;

    @Resource
    private IDGenerater idGenerater;


    public void createVisitor(VisitorEntity visitorEntity){
        if (visitorEntity.getCreateDate() == null){
            visitorEntity.setCreateDate(new Date());
        }

        long newId = idGenerater.nextId();
        visitorEntity.setId(newId);
        visitorEntity.setStatus(GlobalParam.FLAG.start());

        visitorWriteMapper.insert(visitorEntity);
    }

    public void modifyVisitor(VisitorEntity visitorEntity){
        if (visitorEntity.getUpdateDate() == null){
            visitorEntity.setUpdateDate(new Date());
        }

        visitorWriteMapper.update(visitorEntity);
    }

    public void deleteVisitor(Long id, Long operator){
        VisitorEntity visitorEntity = new VisitorEntity();
        visitorEntity.setId(id);
        visitorEntity.setUpdateBy(operator);
        visitorEntity.setUpdateDate(new Date());
        visitorEntity.setStatus(GlobalParam.FLAG.del());

        visitorWriteMapper.update(visitorEntity);
    }
}
