package com.mezzofy.MzCouponAPI.data;


import java.util.List;

/**
 * Created by aruna on 8/18/17.
 */

public class CustomerCouponListDataModel {

    private List<CustomerCouponDataModel> customercoupons;

    private SizeDataModel size;

    public List<CustomerCouponDataModel> getCustomercoupons() {
        return customercoupons;
    }

    public void setCustomercoupons(List<CustomerCouponDataModel> customercoupons) {
        this.customercoupons = customercoupons;
    }

    public SizeDataModel getSize() {
        return size;
    }

    public void setSize(SizeDataModel size) {
        this.size = size;
    }
}
