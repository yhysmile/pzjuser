package com.pzj.core.customer.microshop;

/**
 * Created by Administrator on 2017-6-8.
 */
public class MicroshopModelConvert {
    public static MicroshopInfo convertToMicroshopInfo(Microshop microshop) {
        if (microshop == null){
            return null;
        }

        MicroshopInfo microshopInfo = new MicroshopInfo();
        microshopInfo.setId(microshop.id());
        microshopInfo.setMasterId(microshop.masterId());
        microshopInfo.setName(microshop.name());
        microshopInfo.setAvatar(microshop.avatar());
        microshopInfo.setIntro(microshop.intro());
        microshopInfo.setPhoneNum(microshop.phoneNum());

        return microshopInfo;
    }
}
