package com.pzj.core.customer.common.exception;

import java.util.List;

/**
 * Created by Administrator on 2017-4-24.
 */
public enum ThrowOrCollect {

    /**
     * 抛出异常
     */
    Throw {
        @Override
        public void thorco(final Throwable throwable, List<Throwable> throwables){
            throw new CustomerException(throwable);
        }

        @Override
        public void thorco(CustomerException customerException, List<Throwable> throwables) {
            throw customerException;
        }
    },

    /**
     * 收集异常到集合当中
     */
    Collect {
        @Override
        public void thorco(Throwable throwable, List<Throwable> throwables) {
            throwables.add(throwable);
        }

        @Override
        public void thorco(CustomerException customerException, List<Throwable> throwables) {
            throwables.add(customerException);
        }
    };

    public abstract void thorco(Throwable throwable, List<Throwable> throwables);

    public abstract void thorco(CustomerException customerException, List<Throwable> throwables);

}
