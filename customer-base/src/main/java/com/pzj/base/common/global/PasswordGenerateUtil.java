package com.pzj.base.common.global;

import com.pzj.base.common.security.MD5Utils;

public class PasswordGenerateUtil {

    public static String generatePassword(Long id, String loginName,
            String passwd) {
        if (id == null || loginName == null || passwd == null)
            return null;

        StringBuffer sb = new StringBuffer();
        loginName = loginName.toLowerCase();
        sb.append(loginName.substring(0, 1)).append(passwd.substring(0, 2))
                .append(loginName.substring(1, 2))
                .append(passwd.substring(2, 6)).append(id)
                .append(loginName.substring(2, 4))
                .append(passwd.substring(6, passwd.length()))
                .append(loginName.substring(4, loginName.length()));
        String password = MD5Utils.getMD5DigestHex(sb.toString());
        return password;
    }
    
    public static String generatePasswordTwice(Long id, String loginName,
            String passwd) {
        String pwd = generatePassword(id,loginName,passwd);
        return generatePassword(id,loginName,pwd);
    }

    /**
     * 生成6位随机密码
     * @return
     */
    public static String generate6BitPassword(){
        int pass = (int)((Math.random()*9+1)*100000);
        return String.valueOf(pass);
    }

    /**
     * 密码的短信通知内容
     * @param supplierName 供应商名称
     * @param loginName 注册用户（分销商）的登录名
     * @param clearPassword 密码（没加密的）
     * @param appUrl app下载地址
     * @return
     */
    public static String passwordNoticeMessage(String supplierName, String loginName, String clearPassword, String appUrl){
        String message = String.format("您好，%1$s为您注册了账号 %2$s，初始密码为 %3$s，请及时修改密码以确保账号安全。App下载地址：%4$s",
                supplierName, loginName, clearPassword, appUrl);
        return message;
    }

    
    public static void main(String[] args) {
    	
        System.out.println(generatePassword(2216619736565867L,"dongchf","12345678"));
        
        System.out.println(generatePasswordTwice(2216619736565865l,"dongchunfu","123456"));
        System.out.println(passwordNoticeMessage("wlq", "wuliqing", "12345", "123"));
    }
}
