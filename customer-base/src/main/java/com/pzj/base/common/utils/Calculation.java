package com.pzj.base.common.utils;

import java.math.BigDecimal;

/**
 * 金额计算
 * 
 * @author LiZheng
 * 
 */
public class Calculation {

	public static BigDecimal getPrice(BigDecimal price) {
		return price.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
}
