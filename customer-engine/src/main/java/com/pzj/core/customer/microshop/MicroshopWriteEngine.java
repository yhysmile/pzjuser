package com.pzj.core.customer.microshop;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.operator.Creator;
import com.pzj.core.customer.operator.Modifier;
import com.pzj.core.customer.utils.UserConfig;
import com.pzj.core.customer.write.MicroshopWriteMapper;
import com.pzj.framework.idgen.IDGenerater;

/**
 * Created by Administrator on 2017-6-8.
 */
@Component
public class MicroshopWriteEngine {
	@Resource
	private MicroshopWriteMapper microshopWriteMapper;
	@Resource
	private IDGenerater idGenerater;
	@Resource
	private UserConfig userConfig;

	private boolean doCreateMicroshop(Microshop microshop, Creator creator) {
		if (microshop == null) {
			return false;
		}
		MicroshopEntity microshopEntity = MicroshopEntityConvert.convertToMicroshopEntity(microshop);
		if (microshopEntity.getId() == null) {
			microshopEntity.setId(idGenerater.nextId());
		}
		if (creator != null) {
			microshopEntity.setCreateDate(creator.createDate());
		}
		if (microshopEntity.getCreateDate() == null) {
			microshopEntity.setCreateDate(new Date());
		}
		int insert = microshopWriteMapper.insertMicroshop(microshopEntity);
		return insert == 1;
	}

	private boolean doModifyMicroshop(Microshop microshop, Modifier modifier) {
		if (microshop == null || microshop.id() == null) {
			return false;
		}
		MicroshopEntity microshopEntity = MicroshopEntityConvert.convertToMicroshopEntity(microshop);
		if (modifier != null) {
			microshopEntity.setUpdateDate(modifier.modifyDate());
		}
		if (microshopEntity.getUpdateDate() == null) {
			microshopEntity.setUpdateDate(new Date());
		}
		int update = microshopWriteMapper.updateMicroshop(microshopEntity);
		return update == 1;
	}

	/**
	 * 构建一个新的、具有默认值的微店
	 * @param masterId 主账号id
	 * @param defaultPhoneNum 默认的手机号
	 * @return
	 */
	public Microshop buildNewDefaultMicroshop(Long masterId, String defaultPhoneNum) {
		String defaultAvatar = userConfig.getMicroshopDefaultAvatar();
		String defaultIntro = userConfig.getMicroshopDefaultIntro();
		String defaultName = userConfig.getMicroshopDefaultName();
		long microshopId = idGenerater.nextId();

		Microshop microshop = Microshop.buildMicroshop(microshopId, masterId, defaultName, defaultAvatar, defaultIntro,
				defaultPhoneNum);

		return microshop;
	}

	public Microshop findMicroshopByMasterId(Long masterId) {
		if (masterId == null){
			return null;
		}

		MicroshopEntity microshopEntity = microshopWriteMapper.selectMicroshopByMasterId(masterId);
		Microshop microshop = MicroshopEntityConvert.convertToMicroshop(microshopEntity);
		return microshop;
	}

	/**
	 * 创建一个新的、具有默认值的微店
	 * @param masterId 主账号id
	 * @param defaultPhoneNum 默认的手机号
	 * @param creator 创建人信息
	 * @return
	 */
	public Microshop createNewDefaultMicroshop(Long masterId, String defaultPhoneNum, Creator creator) {
		createNewDefaultMicroshop_check(masterId, defaultPhoneNum);

		Microshop microshop = findMicroshopByMasterId(masterId);

		if (microshop != null){
			throw new CustomerException(CustomerExceptionCode.MICROSHOP_EXISTED);
		}

		microshop = buildNewDefaultMicroshop(masterId, defaultPhoneNum);

		boolean create = doCreateMicroshop(microshop, creator);
		if (create) {
			return microshop;
		}
		return null;
	}

	private void createNewDefaultMicroshop_check(Long masterId, String defaultPhoneNum) {
		if (masterId == null){
			throw new CustomerException(CustomerExceptionCode.MICROSHOP_NULL_ID);
		}
		if (defaultPhoneNum == null){
			throw new CustomerException(CustomerExceptionCode.MICROSHOP_NULL_PHONENUM);
		}
	}

	public Microshop findMicroshopById(Long id) {
		MicroshopEntity microEntity = microshopWriteMapper.selectMicroshopById(id);
		Microshop microshop = null;
		if (null != microEntity) {
			microshop = Microshop.buildMicroshop(microEntity.getId(), microEntity.getMasterId(), microEntity.getName(),
					microEntity.getAvatar(), microEntity.getIntro(), microEntity.getPhoneNum());
		}

		return microshop;
	}

	public boolean modifyMicroshop(Long microshopId, String name, String avatar, String intro, String phoneNum,
			Long modifierId) {
		modifyMicroshopCheck(microshopId, name, avatar, intro, phoneNum, modifierId);

		Microshop microshop = findMicroshopById(microshopId);
		if (microshop == null) {
			throw new CustomerException();
		}

		microshop.changeName(name);
		microshop.changeAvatar(avatar);
		microshop.changeIntro(intro);
		microshop.changePhoneNun(phoneNum);

		Modifier modifier = new Modifier(modifierId);

		return doModifyMicroshop(microshop, modifier);
	}

	private void modifyMicroshopCheck(Long microshopId, String name, String avatar, String intro, String phoneNum,
			Long modifierId) {
		if (null == microshopId || microshopId.longValue() <= 0) {
			throw new CustomerException(CustomerExceptionCode.MICROSHOP_NULL_ID);
		}
		if (null == modifierId || modifierId.longValue() <= 0) {
			throw new CustomerException(CustomerExceptionCode.MICROSHOP_NULL_MODIFY_USERID);
		}
	}

}
