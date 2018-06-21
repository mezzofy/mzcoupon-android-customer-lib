package com.mezzofy.MzCouponAPI.data;


/**
 * Created by aruna on 8/18/17.
 */

public class CustomerCouponDataModel {


    private CampaignData campaign;
    private CouponData coupon;
    private String size;

    public CampaignData getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignData campaign) {
        this.campaign = campaign;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public CouponData getCoupon() {
        return coupon;
    }

    public void setCoupon(CouponData coupon) {
        this.coupon = coupon;
    }
}
