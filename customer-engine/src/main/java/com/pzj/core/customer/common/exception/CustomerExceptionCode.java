package com.pzj.core.customer.common.exception;

/**
 * Created by Administrator on 2017-2-16.
 * 用户服务错误码
 */
public enum CustomerExceptionCode {
	ERROR(14999, "失败"), //
	PARAMETER_EMPTY(14998, "参数为空"), //
	DATASOURCE_EMPTY(14997, "数据源dataSource为空"), //
	MODIFY_DATA_EMPTY(14996, "没有可修改的数据"), //

	//用户扩展信息模块 14001-14019
	CONVERT_EXTENDS_ERROR(14001, "用户扩展信息数据转换失败"), //
	ADD_EXTENDS_ERROR(14002, "新增用户扩展信息失败"), //
	EDIT_EXTENDS_ERROR(14003, "修改用户扩展信息失败"), //
	QUERY_EXTENDS_ERROR(14004, "查询用户扩展信息失败"), //

	//渠道、用户关系管理模块 14020-14039
	MODIFY_LABEL_ERROR(14020, "管理渠道关联失败"), //

	//用户基本信息 14040-14059
	OPER_DATA_NULL(14040, "操作人信息为空"), //
	LOGINNAME_EXIST(14041, "用户名已经存在"), //

	// 渠道
	CHANNEL_NULL(14060, "渠道为空"), //
	CHANNEL_NOT_EXIST(14061, "渠道不存在"), //
	CHANNEL_DELETED(14062, "渠道已经被删除"), //
	CHANNEL_ID_NULL(14063, "渠道id为空"), //
	CHANNEL_NAME_NULL(14064, "渠道名称为空"), //

	// 子账号
	OPERATOR_NULL(14080, "操作人不存在"), //
	OPERATOR_NOT_EXIST(14081, "操作人不存在"), //
	OPERATOR_DISABLE(14082, "操作人状态不可用"), //
	OPERATOR_ID_NULL(14083, "操作人id为空"), //
	OPERATOR_SUPPLIER_MISMATCH(14084, "当前操作人不可以操作其它主账号用户的数据"), //

	// Visitor客户
	VISITOR_NOT_EXIST(14100, "客户的名称不能为空"), //
	VISITOR_ID_NULL(14101, "客户的名称不能为空"), //
	VISITOR_NAME_NULL(14102, "客户的名称不能为空"), //
	VISITOR_OPERATOR_NULL(14103, "客户的名称不能为空"), //
	VISITOR_NO_UPDATE(14104, "客户没有可更新的信息"), //

	// 供应商、分销商用户
	CUSTOMER_CREATE_PARAM_NULL(14120, "创建时用户信息不能为空"),
	CUSTOMER_BATCH_CREATE_ERROR(14127, "批量创建失败，具体原因请查返回数据中的错误报告", "导入完成。总数量%1$s条，本次成功导入%2$s条，具体见导入结果报告"),
	CUSTOMER_BATCH_REFEREE_CODE_NULL(14127, "批量创建失败，具体原因请查返回数据中的错误报告"),

	// 销售人员
	SALESMAN_NULL(14140, "销售人员为空"), //
	SALESMAN_NOT_EXIST(14141, "销售人员不存在"), //
	SALESMAN_DELETED(14142, "销售人员已经被删除"), //
	SALESMAN_DISABLE(14143, "销售人员不可用"), //
	SALESMAN_ID_NULL(14144, "销售人员的id为空"), //
	SALESMAN_NULL_NAME(14145, "销售人员的名称为空"), //
	SALESMAN_NULL_PHONE(14146, "销售人员的手机号为空"), //
	SALESMAN_REFEREE_CODE_NOT_EXIST(14147, "销售人员的推荐码无效"), //
	SALESMAN_REFEREE_CODE_MULTIPLE(14148, "发现多个销售人员有相同的推荐码", "发现多个销售人员有相同的推荐码，推荐码为 %1$s。"), //
	SALESMAN_SUPPLIER_MISMATCH(14148, "推荐码的销售人员不属于当前主账号", "推荐码的销售人员不属于当前主账号，推荐码为 %1$s，操作人为 %2$s，当前主账号ID为： %3$s。"), //

	// 银行卡
	BANKCARD_NULL(14160, "银行卡为空"), //
	BANKCARD_NOT_EXIST(14161, "银行卡不存在"), //
	BANKCARD_DELETED(14161, "银行卡已经被删除"), //
	BANKCARD_DISABLE(14161, "银行卡不可用"), //
	BANKCARD_NULL_ID(14161, "银行卡id为空"), //
	BANKCARD_NULL_ACCOUNT_HOLDER(14161, "银行卡开户人为空"), //
	BANKCARD_NULL_ID_NUM(14161, "银行卡身份证号为空"), //
	BANKCARD_NULL_BANK(14161, "银行卡银行名称为空"), //
	BANKCARD_NULL_CARD_NUM(14161, "银行卡卡号为空"), //

	;

	private int code;
	private String msg;
	private String template;

	CustomerExceptionCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	CustomerExceptionCode(int code, String msg, String template) {
		this(code, msg);
		this.template = template;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public String getTemplate() {
		return template;
	}

	public String getTemplateMessage(Object... args) {
		if (args == null || args.length == 0)
			return getMsg();

		return String.format(getTemplate(), args);
	}
}
