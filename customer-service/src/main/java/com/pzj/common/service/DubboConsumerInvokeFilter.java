package com.pzj.common.service;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.pzj.common.log.LogSession;
import com.pzj.framework.context.ServiceContext;

/**
 * Created by Administrator on 2016-10-17.
 */
@Activate // 对filter进行分组，filter在消费端生效还是服务端生效
public class DubboConsumerInvokeFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(DubboConsumerInvokeFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        // dubbo调用相关信息
        String serviceName = invoker.getInterface().getName();
        Class serviceType = invoker.getInterface();//调用的类
        String methodName = invocation.getMethodName();//调用的方法
        Class[] parameterTypes = invocation.getParameterTypes();//调用的方法的参数类型
        Object[] argumentValues = invocation.getArguments();//调用的方法的参数值

        String logId = null;

        if (argumentValues != null){
            Object argumentValue = argumentValues[argumentValues.length - 1];
            if (argumentValue instanceof ServiceContext){
                ServiceContext serviceContext = (ServiceContext) argumentValue;
                LogSession.logBegin(serviceContext);
                logId = serviceContext.getLogId();
            }
        }

        RpcInvocation rpcInvocation = (RpcInvocation) invocation;

        if (logger.isDebugEnabled()){
            logger.debug("日志ID：{}；{} 方法调用开始，参数为 {}" , logId, methodName, JSON.toJSONString(argumentValues));
        }

        // 根据dubbo扩展需求设置附加数据（设置id用于全链路追踪，保证id在调用链上的传递）
        // rpcInvocation.setAttachment(GLOBAL_REQUEST_ID_KEY, globalRequestId);// 设置全局请求id，用于追踪一次http请求发起的所有dubbo请求。
        // rpcInvocation.setAttachment(NODE_REQUEST_ID_KEY, nodeRequestId);// 设置节点请求id，用于追踪一个节点发起的dubbo请求

        // String globalRequestId = rpcInvocation.getAttachment(GLOBAL_REQUEST_ID_KEY);// 获取附加数据，消费端设置的服务端可以获取到。请求id可以放到线程变量里，以便业务上做记录
        // String nodeRequestId = rpcInvocation.getAttachment(NODE_REQUEST_ID_KEY);

        long startTime=System.currentTimeMillis();//记录开始时间

        // 交给下级调用，RPC调用
        Result result = invoker.invoke(invocation);
        long endTime=System.currentTimeMillis();//记录结束时间，统计服务耗时

        if (logger.isDebugEnabled()){
            logger.debug("日志ID：{}；{} 方法调用结束，结果为 {}" , logId ,methodName, JSON.toJSONString(result));
            logger.debug("日志ID：{}；{} 方法调用时间为 {}" , logId, methodName, endTime - startTime);
        }

        LogSession.logEnd();

        result.getException();// 如果服务方有异常可以拿到
        // 调用信息异步记录：写日志/发mq/写DB.....
        return result;
    }
}
