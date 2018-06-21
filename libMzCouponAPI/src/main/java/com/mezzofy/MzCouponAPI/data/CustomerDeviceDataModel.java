package com.mezzofy.MzCouponAPI.data;


/**
 * Created by aruna on 7/25/17.
 */

public class CustomerDeviceDataModel {
    private CustomerDeviceData device;
    private CustomerData customer;

    public CustomerDeviceData getDevice() {
        return device;
    }

    public void setDevice(CustomerDeviceData device) {
        this.device = device;
    }

    public CustomerData getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerData customer) {
        this.customer = customer;
    }
}
