package com.mezzofy.MzCouponAPI.module;

import android.content.Context;

import com.google.gson.Gson;
import com.mezzofy.MzCouponAPI.data.PoListDataModel;
import com.mezzofy.MzCouponAPI.utills.CommonModule;
import com.mezzofy.MzCouponAPI.utills.JSONSTRINGS;

/**
 * Created by aruna on 2/15/18.
 */

public class MZPoOrder {
    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    Context context;



    public MZPoOrder(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }

    public PoListDataModel GetOrders(String CustomerId, int offset) {
        PoListDataModel poListmData = null;

        String order = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/pos?customerid="+CustomerId+"&page="+offset);
        poListmData= gson.fromJson(order, PoListDataModel.class);
        return poListmData;
    }

}
