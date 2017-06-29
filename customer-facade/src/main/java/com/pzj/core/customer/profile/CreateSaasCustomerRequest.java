package com.pzj.core.customer.profile;

/**
 * Created by mf-pc on 2017/6/27.
 */
public class CreateSaasCustomerRequest extends CreateCustomerRequest{
    /**
     * 企业logo
     */
    private String logo;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
