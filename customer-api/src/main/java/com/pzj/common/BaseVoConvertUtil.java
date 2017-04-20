package com.pzj.common;

import java.util.ArrayList;
import java.util.List;

import com.pzj.base.common.ServiceException;

public abstract class BaseVoConvertUtil<A, S> {
    public abstract S convertTSysBean(A vo);

    public abstract A convertTApiBean(S vo);

    public abstract S convertTSysBeanForIU(A vo) throws Exception;

    public abstract S convertTSysBeanForS(A vo) throws Exception;

    public List<S> convertListTSysBeanForIU(List<A> voList) throws Exception {

        if (voList == null) {
            return null;
        }
        List<S> list = new ArrayList<S>();

        for (A vo : voList) {
            list.add(convertTSysBeanForIU(vo));
        }

        return list;
    }

    public List<A> convertListTApiBean(List<S> voList) throws Exception {

        if (voList == null)
            return null;

        List<A> list = new ArrayList<A>();

        for (S vo : voList) {
            list.add(convertTApiBean(vo));
        }

        return list;
    }

    public abstract void validData(A vo) throws ServiceException;

}
