package com.mezzofy.MzCouponAPI.data;


/**
 * Created by aruna on 9/29/17.
 */

public class WalletData {
    private String walletId;
    private String customerId;
    private String walletCredit;
    private String qrCode;
    private String qrTime;
    private String rewardPoint;
    private String updatedOn;

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getWalletCredit() {
        return walletCredit;
    }

    public void setWalletCredit(String walletCredit) {
        this.walletCredit = walletCredit;
    }

    public String getRewardPoint() {
        return rewardPoint;
    }

    public void setRewardPoint(String rewardPoint) {
        this.rewardPoint = rewardPoint;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getQrTime() {
        return qrTime;
    }

    public void setQrTime(String qrTime) {
        this.qrTime = qrTime;
    }



    public String getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(String updatedOn) {
        this.updatedOn = updatedOn;
    }
}
