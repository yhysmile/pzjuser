package com.pzj.core.customer.microshop;

import com.pzj.core.customer.read.MicroshopReadMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017-6-8.
 */
@Component
public class MicroshopReadEngine {
    @Resource
    private MicroshopReadMapper microshopReadMapper;

    public Microshop queryMicroshopByMasterId(Long masterId) {
        if (masterId == null){
            return null;
        }

        MicroshopEntity microshopEntity = microshopReadMapper.selectMicroshopByMasterId(masterId);
        Microshop microshop = MicroshopEntityConvert.convertToMicroshop(microshopEntity);
        return microshop;
    }
}
