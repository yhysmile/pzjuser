package com.pzj.core.customer.microshop;

import com.pzj.core.customer.operator.Creator;
import com.pzj.framework.context.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017-6-8.
 */
@Service("microshopService")
public class MicroshopServiceImpl implements MicroshopService {
    @Resource
    private MicroshopReadEngine microshopReadEngine;
    @Resource
    private MicroshopWriteEngine microshopWriteEngine;

    @Override
    public Result<Boolean> modifyMicroshop(Long microshopId, MicroshopContent microshopContent, Long modifierId) {
        boolean modify = microshopWriteEngine.modifyMicroshop(microshopId, microshopContent.getName(),
                microshopContent.getAvatar(), microshopContent.getIntro(), microshopContent.getPhoneNum(), modifierId);
        return new Result<>(modify);
    }

    @Override
    public Result<Boolean> createDefaultMicroshopt(Long masterId, String defaultPhoneNum, Long creatorId) {
        Creator creator = new Creator(creatorId);
        Microshop microshop = microshopWriteEngine.createNewDefaultMicroshop(masterId, defaultPhoneNum, creator);
        return new Result<>(microshop == null);
    }

    @Override
    public Result<MicroshopInfo> queryMicroshopByMasterId(Long masterId) {
        Microshop microshop = microshopReadEngine.queryMicroshopByMasterId(masterId);
        MicroshopInfo microshopInfo = MicroshopModelConvert.convertToMicroshopInfo(microshop);
        return new Result<>(microshopInfo);
    }
}
