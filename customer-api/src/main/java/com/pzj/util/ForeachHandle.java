package com.pzj.util;

public interface ForeachHandle<S,E> {
    @SuppressWarnings("rawtypes")
    public final static ForeachHandle NULL = new ForeachHandle(){

        @Override
        public void handle(Object s, Object e) {
        }
    };

    void handle(S s, E e);
}
