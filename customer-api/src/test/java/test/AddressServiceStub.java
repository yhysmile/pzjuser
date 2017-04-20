package test;

import com.pzj.address.entity.Address;
import com.pzj.address.entity.AddressParam;
import com.pzj.address.service.AddressService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.toolkit.Check;
import com.pzj.util.JsonDataUtil;

import java.util.*;

/**
 * Created by Administrator on 2016-10-20.
 */
public class AddressServiceStub implements AddressService {
    HashMap<Long, Address> addressDb = new HashMap<>();

    public AddressServiceStub(){
        List<Address> addressList = JsonDataUtil.readListFromClasspath("/data/addressDb.json",Address.class);
        for (Address address : addressList){
            addressDb.put(address.getId(), address);
        }
    }

    @Override
    public Result<Long> createAddress(Address address, ServiceContext serviceContext) {
        long id = createAddress(address);

        Result<Long> result = new Result<>();
        result.setData(id);
        return result;
    }

    private long createAddress(Address address){
        int size = addressDb.size();
        long id = size + 1;
        address.setId(id);
        addressDb.put(id, address);
        return id;
    }

    @Override
    public Result<Integer> createAddress(List<Address> addressList, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();
        result.setData(0);

        if (!Check.NuNCollections(addressList)){
            for (Address address : addressList){
                createAddress(address);
            }
            result.setData(addressList.size());
        }

        return result;
    }

    @Override
    public Result<Integer> modifyAddress(Address address, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();
        result.setData(0);

        if (address != null){
            if(addressDb.containsKey(address.getId())){
                addressDb.put(address.getId(), address);
                result.setData(1);
            }
        }

        return result;
    }

    @Override
    public Result<Integer> modifyAddress(List<Address> addressList, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();
        result.setData(0);

        if (Check.NuNCollections(addressList)){
            int i = 0;
            for (Address address : addressList) {
                if (addressDb.containsKey(address.getId())) {
                    addressDb.put(address.getId(), address);
                    i++;
                }
            }
            result.setData(i);
        }

        return result;
    }

    @Override
    public Result<Integer> deleteAddress(Long id, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();
        result.setData(0);

        if(addressDb.containsKey(id)){
            addressDb.remove(id);
            result.setData(1);
        }

        return result;
    }

    @Override
    public Result<Integer> deleteAddress(List<Long> ids, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();
        result.setData(0);

        if (Check.NuNCollections(ids)){
            int i = 0;
            for (Long id : ids) {
                if(addressDb.containsKey(id)){
                    addressDb.remove(id);
                    i++;
                }
            }
            result.setData(i);
        }

        return result;
    }

    @Override
    public Result<ArrayList<Address>> queryByParam(AddressParam addressQueryParam, ServiceContext serviceContext) {
        ArrayList<Address> addressList = new ArrayList(addressDb.values());
        Result<ArrayList<Address>> result = new Result<>();
        result.setData(addressList);
        return result;
    }

    @Override
    public Result<PageList<Address>> queryByParam(AddressParam addressQueryParam, PageModel pageModel, ServiceContext serviceContext) {
        ArrayList<Address> addressList = new ArrayList(addressDb.values());
        PageList<Address> pageList = new PageList<>();
        pageList.setResultList(addressList);

        Result<PageList<Address>> result = new Result<>();
        result.setData(pageList);
        return result;
    }

    @Override
    public Result<Address> queryDefault(AddressParam addressQueryParam, ServiceContext serviceContext) {
        Result<Address> result = new Result<>();

        if (addressQueryParam != null){
            Long supplierId = addressQueryParam.getSupplierId();
            Integer type = addressQueryParam.getType();

            Address address = null;
            Iterator<Map.Entry<Long, Address>> iterator = addressDb.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Long, Address> next = iterator.next();
                Address nextValue = next.getValue();
                if (nextValue.getSupplierId() == supplierId && nextValue.getType() == type && nextValue.getIsDefault()){
                    result.setData(address);
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public Result<Integer> asDefault(Long id, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();
        result.setData(0);

        if (id != null){
            Address address = addressDb.get(id);
            if (address != null){
                Long supplierId = address.getSupplierId();
                Integer type = address.getType();

                Iterator<Map.Entry<Long, Address>> iterator = addressDb.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<Long, Address> next = iterator.next();
                    Address nextValue = next.getValue();
                    if (nextValue.getSupplierId() == supplierId && nextValue.getType() == type){
                        nextValue.setIsDefault(false);
                    }
                }
                address.setIsDefault(true);
                result.setData(1);
            }
        }

        return result;
    }
}
