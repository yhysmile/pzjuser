package com.pzj.cache;

import com.pzj.customer.entity.Customer;

/**
 * 用户缓存接口
 * 
 * @author apple
 *
 */
public interface UserCacheService {

	/**
	 * 获取token，从缓存读取用户信息
	 * 
	 * @return
	 */
	public Customer getUserToken(String token) throws Exception;;

	/**
	 * 存储验证码到缓存
	 * 
	 * @param user
	 * @return
	 */
	public Boolean putUserCode(String userTel, String userCode, long liveTime)
			throws Exception;;

	/**
	 * 获取验证码
	 * 
	 * @return
	 */
	public String getUserCode(String userTel) throws Exception;

	public void delUserCode(String key) throws Exception;

	public void delToken(String token) throws Exception;

	public String getPmsString(String pmskey) throws Exception;

	public Boolean putPmsString(String key, String code, long liveTime)
			throws Exception;

	public void delPms(String key) throws Exception;

}
