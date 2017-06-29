package com.pzj.common.context;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.framework.context.Result;
import com.pzj.framework.converter.JSONConverter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017-6-6.
 */
public class FacadeServiceAdvice {
    private static Logger logger = LoggerFactory.getLogger(FacadeServiceAdvice.class);

    public Object watchPerformance(ProceedingJoinPoint joinPoint){
        Object returnValue;

        try{
            returnValue = joinPoint.proceed();
        } catch (Throwable throwable){
            Result result = new Result<>();

            if (throwable instanceof CustomerException){
                CustomerException customerException = (CustomerException)throwable;
                result.setErrorCode(customerException.getCode());
                result.setErrorMsg(customerException.getMessage());
            } else {
                result.setErrorCode(CustomerExceptionCode.ERROR.getCode());
                result.setErrorMsg(CustomerExceptionCode.ERROR.getMsg());
            }

            logger.error("调用方法 " + joinPoint.getSignature().getName() + " 出错，入参：{}" , JSONConverter.toJson(joinPoint.getArgs()));
            logger.error(throwable.getMessage(), throwable);

            returnValue = result;
        }

        if (returnValue == null){
            returnValue = new Result<>();
        }

        return returnValue;

    }
}
