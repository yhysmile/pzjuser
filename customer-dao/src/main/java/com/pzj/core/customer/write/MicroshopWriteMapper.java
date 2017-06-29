package com.pzj.core.customer.write;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.core.customer.microshop.MicroshopEntity;

/**
 * Created by Administrator on 2017-6-8.
 */
@MyBatisDao
public interface MicroshopWriteMapper {
	MicroshopEntity selectMicroshopByMasterId(Long masterId);

	int updateMicroshop(MicroshopEntity microshop);

	int insertMicroshop(MicroshopEntity microshop);

	MicroshopEntity selectMicroshopById(Long id);
}
