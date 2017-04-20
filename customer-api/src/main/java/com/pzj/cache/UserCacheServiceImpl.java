package com.pzj.cache;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.pzj.base.common.global.KeyParam;
import com.pzj.base.common.global.UserGlobalParam.UserMapKeyParam;
import com.pzj.base.service.sys.cache.UserRedisService;
import com.pzj.customer.entity.Customer;

/**
 * 用户缓存接口实现
 * 
 * @author apple
 *
 */
@Service
public class UserCacheServiceImpl implements UserCacheService {

	@Autowired
	private UserRedisService userRedisService;

	private static Logger logger = LoggerFactory.getLogger(UserCacheServiceImpl.class);

	@Override
	public Customer getUserToken(String token) throws Exception
	{

		String userJson = null;
		Object obj = userRedisService.get(UserMapKeyParam.USER_KEY + token);
		if (obj != null) {
			userJson = (String) obj;
		}

		Customer user = JSON.toJavaObject(JSON.parseObject(userJson),
				Customer.class);

		return user != null ? user : null;
	}

	@Override
	public Boolean putUserCode(String userTel, String userCode, long liveTime)
			throws Exception {

		Long index = null;

		if (StringUtils.isNotEmpty(userTel) && StringUtils.isNotEmpty(userCode)) {
			index = userRedisService.put(KeyParam.User.code(userTel), userCode,
					liveTime);
		} else {
			logger.debug("val->null:" + userTel + ":" + userCode + ":"
					+ liveTime);
		}

		return index != null && index > 0 ? true : false;
	}

	@Override
	public String getUserCode(String userTel) throws Exception {

		String code = null;

		if (StringUtils.isNotEmpty(userTel)) {
			Object obj = userRedisService.get(KeyParam.User.code(userTel));
			if (obj != null) {
				code = (String) obj;
			}
		} else {
			logger.debug("val->null:" + userTel);
		}

		return code;
	}

	public void delUserCode(String key) throws Exception {
		if (StringUtils.isNotBlank(key)) {
			userRedisService.delKey(key);
		}
	}

	public void delToken(String token) throws Exception {
		if (StringUtils.isNotBlank(token)) {
			userRedisService.delKey(UserMapKeyParam.USER_KEY + token);
			logger.info("删除token：{}", token);
		}
	}

	/**
	 * ================================pms====================================
	 */

	/**
	 * pms redis操作字符串，获取
	 */
	@Override
	public String getPmsString(String pmskey) throws Exception

	{

		String json = null;
		Object obj = userRedisService.get(UserMapKeyParam.PMS_KEY + pmskey);
		if (obj != null) {
			json = (String) obj;
		}

		return json;
	}

	/**
	 * pms redis创建字符串
	 */
	@Override
	public Boolean putPmsString(String key, String code, long liveTime)
			throws Exception {

		Long index = null;

		if (StringUtils.isNotEmpty(key) && StringUtils.isNotEmpty(code)) {
			index = userRedisService.put(UserMapKeyParam.PMS_KEY + key, code,
					liveTime);
		} else {
			logger.debug("val->null:" + key + ":" + code + ":" + liveTime);
		}

		return index != null && index > 0 ? true : false;
	}

	/**
	 * 删除pms，redis
	 */
	@Override
	public void delPms(String key) throws Exception {
		if (StringUtils.isNotBlank(key)) {
			userRedisService.delKey(UserMapKeyParam.PMS_KEY + key);
		}
	}
}
