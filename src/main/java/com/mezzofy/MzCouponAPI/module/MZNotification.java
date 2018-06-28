package com.mezzofy.MzCouponAPI.module;

import android.content.Context;

import com.google.gson.Gson;
import com.mezzofy.MzCouponAPI.data.NotificationListDataModel;
import com.mezzofy.MzCouponAPI.utills.CommonModule;
import com.mezzofy.MzCouponAPI.utills.JSONSTRINGS;

import org.json.JSONObject;


/**
 * Created by aruna on 2/15/18.
 */

public class MZNotification {
    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    private JSONObject jsonobj = null;
    Context context;



    public MZNotification(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }
    public NotificationListDataModel GetNotifications(String CustomerId, int Page) {

        Gson gson = new Gson();
        String notification = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/notifications?customerid="+CustomerId+"&page="+Page);
        NotificationListDataModel notificationListModel = gson.fromJson(notification, NotificationListDataModel.class);


        return notificationListModel;

    }

}
