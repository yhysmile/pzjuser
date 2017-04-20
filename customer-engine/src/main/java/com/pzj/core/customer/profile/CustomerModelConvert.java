package com.pzj.core.customer.profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-4-12.
 */
public class CustomerModelConvert {

    public static ResellerEntity convertToResellerEntity(QueryCustomerLessInfoRequest param) {
        if (param == null) {
            return null;
        }

        ResellerEntity resellerEntity = new ResellerEntity();
        boolean hasParam = false;

        if (param.getName() != null && param.getName().trim() != ""){
            resellerEntity.setName("%"+ param.getName() + "%");
            hasParam = true;
        }
        List<Long> ids = param.getIds();
        if (ids != null && !ids.isEmpty()) {
            resellerEntity.setUserIds(ids);
            hasParam = true;
        }

        if (hasParam) {
            return resellerEntity;
        }

        return null;
    }

    public static List<QueryCustomerLessInfoResponse> convertToQueryCustomerLessInfoResponse(List<ResellerEntity> resellerEntities) {
        if (resellerEntities == null){
            return null;
        }
        List<QueryCustomerLessInfoResponse> list = new ArrayList<>(resellerEntities.size());

        for (ResellerEntity resellerEntity : resellerEntities) {
            if (resellerEntity != null) {
                list.add(convertToQueryCustomerLessInfoResponse(resellerEntity));
            }
        }

        return list;
    }

    public static QueryCustomerLessInfoResponse convertToQueryCustomerLessInfoResponse(ResellerEntity resellerEntity) {
        if (resellerEntity == null) {
            return null;
        }
        QueryCustomerLessInfoResponse response = new QueryCustomerLessInfoResponse();
        response.setId(resellerEntity.getId());
        response.setName(resellerEntity.getName());
        return response;
    }
}
