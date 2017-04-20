package com.pzj.common.error;

import com.pzj.framework.context.Result;

import java.util.HashMap;

/**
 * Created by Administrator on 2016-12-5.
 */
public class UserErrorCode {
    private int errorCode;
    private String errorMessage;

    private static final HashMap<Integer, UserErrorCode> errorDict = new HashMap<>(1);

    private UserErrorCode(int errorCode, String errorMessage){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    private static UserErrorCode create(int errorCode, String errorMessage){
        UserErrorCode userErrorCode = new UserErrorCode(errorCode, errorMessage);
        errorDict.put(errorCode, userErrorCode);
        return userErrorCode;
    }

    public static void setResultError(Result result, UserErrorCode userErrorCode){
        if (result != null && userErrorCode != null){
            result.setErrorCode(userErrorCode.getErrorCode());
            result.setErrorMsg(userErrorCode.getErrorMessage());
        }
    }

    /**
     * 修改、创建用户时，用户为null错误
     */
    public static final UserErrorCode User_Null = create(14000, "用户数据不能为空");
    /**
     * 用户ID为错误
     */
    public static final UserErrorCode User_Id_Null = create(14001, "用户ID不能为空");
    /**
     * 用户的创建人不能为null
     */
    public static final UserErrorCode User_CreateBy_Null = create(14002, "用户的创建人不能为空");
    /**
     * 用户的更新人不能为null
     */
    public static final UserErrorCode User_UpdateBy_Null = create(14003, "用户的更新人不能为空");
    /**
     * 指定的用户不存在
     */
    public static final UserErrorCode User_Not_Exist = create(14100, "指定的用户不存在");
    /**
     * 用户无需审核
     */
    public static final UserErrorCode User_Not_Need_Audit = create(14101, "用户无需审核");
    /**
     * 用户无需资质审核
     */
    public static final UserErrorCode User_Not_Need_QualificationAudit = create(14102, "用户无需资质审核");
    /**
     * 用户微信信息为空
     */
    public static final UserErrorCode Wechat_Null = create(14130, "微店信息为空");
    /**
     * 用户微信所属id为空
     */
    public static final UserErrorCode Wechat_Id_Null = create(14131, "微店id为空");
    /**
     * 用户微信所属用户id为空
     */
    public static final UserErrorCode Wechat_UserId_Null = create(14132, "微店所属用户id为空");
    /**
     * 用户微信openid为空
     */
    public static final UserErrorCode Wechat_Openid_Null = create(14133, "微信openid为空");
    /**
     * 用户微信唯一标识为空，至少要有id、userId、openid这3个中的一个
     */
    public static final UserErrorCode Wechat_UniquelyId_Null = create(14134, "用户微信唯一标识为空，至少要有id、userId、openid这3个中的一个");


    public static final UserErrorCode Channel = create(14201, "");

    public static final UserErrorCode Contacts_NUll = create(14150, "联系人不能为空");


    public static final UserErrorCode User_Exception = create(14999, "用户服务内部错误");
}
