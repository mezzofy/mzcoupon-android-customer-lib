package com.mezzofy.MzCouponAPI.data;

import java.util.List;

public class ChannelLocationDataModel {

    private ChannelLocationData location;
    private List<ChannelPlaylistData> coupongroups;
    private List<ChannelPromotionData> coupons;


    public ChannelLocationData getLocation() {
        return location;
    }

    public void setLocation(ChannelLocationData location) {
        this.location = location;
    }

    public List<ChannelPlaylistData> getCoupongroups() {
        return coupongroups;
    }

    public void setCoupongroups(List<ChannelPlaylistData> coupongroups) {
        this.coupongroups = coupongroups;
    }

    public List<ChannelPromotionData> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<ChannelPromotionData> coupons) {
        this.coupons = coupons;
    }
}
