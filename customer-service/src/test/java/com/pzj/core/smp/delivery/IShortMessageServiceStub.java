package com.pzj.core.smp.delivery;

import com.pzj.framework.context.Result;

/**
 * Created by Administrator on 2017-4-12.
 */
public class IShortMessageServiceStub implements IShortMessageService{
    @Override
    public Result<Boolean> sendMessage(MessageBean messageBean) {
        Result<Boolean> result = new Result<>();
        result.setData(true);
        return result;
    }
}
