package com.pzj.core.customer.microshop;

/**
 * Created by Administrator on 2017-6-8.
 */
public class MicroshopEntityConvert {
    public static MicroshopEntity convertToMicroshopEntity(Microshop microshop) {
        if (microshop == null){
            return null;
        }

        MicroshopEntity microshopEntity = new MicroshopEntity();
        microshopEntity.setId(microshop.id());
        microshopEntity.setMasterId(microshop.masterId());
        microshopEntity.setName(microshop.name());
        microshopEntity.setAvatar(microshop.avatar());
        microshopEntity.setIntro(microshop.intro());
        microshopEntity.setPhoneNum(microshop.phoneNum());

        return microshopEntity;
    }

    public static Microshop convertToMicroshop(MicroshopEntity microshopEntity) {
        if (microshopEntity == null){
            return null;
        }

        Microshop microshop = Microshop.buildMicroshop(microshopEntity.getId(), microshopEntity.getMasterId(),
                microshopEntity.getName(), microshopEntity.getAvatar(), microshopEntity.getIntro(),
                microshopEntity.getPhoneNum());

        return microshop;
    }
}
