package com.mezzofy.MzCouponAPI.data;


/**
 * Created by aruna on 7/25/17.
 */

public class CustomerDeviceData {
    private String custDeviceId;
    private String customerId;
    private String deviceToken;
    private String deviceName;
    private String deviceUuid;
    private String updatedOn;

    public String getCustDeviceId() {
        return custDeviceId;
    }

    public void setCustDeviceId(String custDeviceId) {
        this.custDeviceId = custDeviceId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceUuid() {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }

    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }
}
