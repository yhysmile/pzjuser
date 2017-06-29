package com.pzj.core.customer.read;

import com.pzj.core.customer.microshop.MicroshopEntity;

/**
 * Created by Administrator on 2017-6-8.
 */
public interface MicroshopReadMapper {
    MicroshopEntity selectMicroshopByMasterId(Long masterId);
}
