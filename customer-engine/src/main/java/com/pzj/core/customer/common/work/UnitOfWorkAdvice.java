package com.pzj.core.customer.common.work;

import com.pzj.core.customer.common.work.support.ThreadUnitOfWork;
import com.pzj.framework.converter.JSONConverter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-6-6.
 */
public class UnitOfWorkAdvice {

    @Resource
    private UnitOfWorkManager unitOfWorkManager;

    private static Logger logger = LoggerFactory.getLogger(UnitOfWorkAdvice.class);

    public Object watchPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnValue;

        UnitOfWork unitOfWork = null;
        try{
            unitOfWork = ThreadUnitOfWork.getOrCreateThreadUnitOfWork();
            unitOfWork.enable();

            returnValue = joinPoint.proceed();

            List<Event> events = unitOfWork.commit();
            logger.info("方法 " + joinPoint.getSignature().getName() + " 发布的所有事件：{}", JSONConverter.toJson(events));
            unitOfWorkManager.publishEvent(events);
        } catch (Throwable throwable){
            if (unitOfWork != null){
                unitOfWork.rollback();
            }
            throw throwable;
        }

        return returnValue;

    }

    public void setUnitOfWorkManager(UnitOfWorkManager unitOfWorkManager) {
        this.unitOfWorkManager = unitOfWorkManager;
    }
}
