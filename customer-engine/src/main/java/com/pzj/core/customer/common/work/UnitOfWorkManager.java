package com.pzj.core.customer.common.work;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017-6-6.
 */
public class UnitOfWorkManager {
    private static Logger logger = LoggerFactory.getLogger(UnitOfWorkManager.class);

    private int poolSize = 10;

    private ExecutorService executorService;

    private List<EventListener> eventListeners = Collections.EMPTY_LIST;

    public UnitOfWorkManager(){

    }

    public void init(){
        executorService = Executors.newFixedThreadPool(poolSize);
    }

    public void publishEvent(List<Event> events){
        if (events == null || events.isEmpty()){
            return;
        }

        for (Event event : events){
            for (EventListener eventListener : eventListeners){
                EventHandler eventHandler = createEventHandler(event, eventListener);
                executorService.submit(eventHandler);
            }
        }
    }

    private EventHandler createEventHandler(Event event, EventListener eventListener){
        EventHandler eventHandler = new EventHandler();
        eventHandler.event = event;
        eventHandler.eventListener = eventListener;
        return eventHandler;
    }

    private static class EventHandler implements Runnable {
        private static Logger logger = LoggerFactory.getLogger(EventHandler.class);
        String requestId;
        Event event;
        EventListener eventListener;
        @Override
        public void run() {
            try {
                eventListener.handleEvent(event);
            } catch (Throwable throwable) {
                logger.error(throwable.getMessage(), throwable);
            }
        }
    }

    public int getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public List<EventListener> getEventListeners() {
        return eventListeners;
    }

    public void setEventListeners(List<EventListener> eventListeners) {
        this.eventListeners = eventListeners;
    }
}
