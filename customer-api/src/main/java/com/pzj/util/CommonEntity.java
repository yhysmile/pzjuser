package com.pzj.util;

import com.pzj.base.common.BaseVO;

public abstract class CommonEntity extends BaseVO {
    
    /** 删除标记 */
    private String delFlag;

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
    
}
