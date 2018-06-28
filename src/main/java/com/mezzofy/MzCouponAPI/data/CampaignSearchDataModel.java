package com.mezzofy.MzCouponAPI.data;





import java.util.List;

/**
 * Created by aruna on 11/2/17.
 */

public class CampaignSearchDataModel {
    private int page;
    private double latitude;
    private double longitude;
    private List<SiteData> sites;
    private List<CampGrpData> groups;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<SiteData> getSites() {
        return sites;
    }

    public void setSites(List<SiteData> sites) {
        this.sites = sites;
    }

    public List<CampGrpData> getGroups() {
        return groups;
    }

    public void setGroups(List<CampGrpData> groups) {
        this.groups = groups;
    }
}
