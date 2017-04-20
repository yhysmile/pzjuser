package com.pzj.customer.entity.pms;

import com.pzj.base.entity.query.NumericQueryVo;

public class CustomerNumericQueryVo {

	/** 大于等于 */
	private Double lowerNumeric;
	/** 小于等于 */
	private Double higherNumeric;

	/**
	 * 获取大于等于
	 * 
	 * @return lowerNumeric 大于等于
	 */
	public Double getLowerNumeric() {
		return lowerNumeric;
	}

	/**
	 * 设置大于等于
	 * 
	 * @param lowerNumeric
	 *            大于等于
	 */
	public void setLowerNumeric(Double lowerNumeric) {
		this.lowerNumeric = lowerNumeric;
	}

	/**
	 * 获取小于等于
	 * 
	 * @return higherNumeric 小于等于
	 */
	public Double getHigherNumeric() {
		return higherNumeric;
	}

	/**
	 * 设置小于等于
	 * 
	 * @param higherNumeric
	 *            小于等于
	 */
	public void setHigherNumeric(Double higherNumeric) {
		this.higherNumeric = higherNumeric;
	}

	public NumericQueryVo changeTNumericQueryVo(String paramName) {
		NumericQueryVo vo = new NumericQueryVo(paramName,
				this.getLowerNumeric(), this.getHigherNumeric());
		return vo;
	}

}
