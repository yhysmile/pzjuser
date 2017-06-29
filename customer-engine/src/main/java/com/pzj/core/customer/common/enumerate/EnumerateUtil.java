package com.pzj.core.customer.common.enumerate;

/**
 * Created by Administrator on 2017-5-16.
 */
public class EnumerateUtil {

    public static String valuesString(Enumerate[] enums) {
        if (enums != null && enums.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < enums.length; i++) {
                append(sb, enums[i]);
            }
            return sb.toString();
        }
        return null;
    }

    private static void append(StringBuilder sb, Enumerate areaSeatType){
        sb.append(areaSeatType.getValue());
        sb.append("：");
        sb.append(areaSeatType.getDesc());
        sb.append("；");
    }
}
