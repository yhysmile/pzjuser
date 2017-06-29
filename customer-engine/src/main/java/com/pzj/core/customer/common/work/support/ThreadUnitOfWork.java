package com.pzj.core.customer.common.work.support;


import com.pzj.core.customer.common.work.Event;
import com.pzj.core.customer.common.work.UnitOfWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017-5-9.
 */
public class ThreadUnitOfWork implements UnitOfWork {

    private static final ThreadLocal<ThreadUnitOfWork> threadLocal = new ThreadLocal<>();

    public static ThreadUnitOfWork getOrCreateThreadUnitOfWork(){
        ThreadUnitOfWork threadUnitOfWork = threadLocal.get();
        if (threadUnitOfWork == null){
            threadUnitOfWork = new ThreadUnitOfWork();
            threadLocal.set(threadUnitOfWork);
        }
        return threadUnitOfWork;
    }

    private List<Event> evnets = new ArrayList<>();

    private boolean isAble = true;

    @Override
    public void enable() {
        isAble = true;
    }

    @Override
    public void disable() {
        isAble = false;
    }

    @Override
    public void addEvent(Event event) {
        if (isAble) {
            evnets.add(event);
        }
    }

    @Override
    public List<Event> commit() {
        List<Event> es = Collections.unmodifiableList(evnets);
        evnets = new ArrayList<>();
        return es;
    }

    @Override
    public void rollback() {
        evnets.clear();
    }
}
