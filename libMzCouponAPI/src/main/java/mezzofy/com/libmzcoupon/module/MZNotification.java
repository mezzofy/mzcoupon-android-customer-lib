package mezzofy.com.libmzcoupon.module;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONObject;

import mezzofy.com.libmzcoupon.data.NotificationListDataModel;
import mezzofy.com.libmzcoupon.utills.CommonModule;
import mezzofy.com.libmzcoupon.utills.JSONSTRINGS;


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
