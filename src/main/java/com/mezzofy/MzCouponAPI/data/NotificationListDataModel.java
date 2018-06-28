package com.mezzofy.MzCouponAPI.data;

import java.util.List;

/**
 * Created by aruna on 11/14/17.
 */

public class NotificationListDataModel {

    private List<NotificationDataModel> notifications;

    private SizeDataModel size;

    public List<NotificationDataModel> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<NotificationDataModel> notifications) {
        this.notifications = notifications;
    }

    public SizeDataModel getSize() {
        return size;
    }

    public void setSize(SizeDataModel size) {
        this.size = size;
    }
}
