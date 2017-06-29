package com.pzj.core.customer.common.work;

import java.util.List;

/**
 * Created by Administrator on 2017-5-8.
 */
public interface UnitOfWork {
    void enable();
    void disable();


    void addEvent(Event event);

    List<Event> commit();

    void rollback();
}
