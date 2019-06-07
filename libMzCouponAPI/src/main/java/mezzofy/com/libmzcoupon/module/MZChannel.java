package com.mezzofy.MzCouponAPI.module;

import android.content.Context;

import com.google.gson.Gson;
import com.mezzofy.MzCouponAPI.data.ChannelLocationDataListModel;
import com.mezzofy.MzCouponAPI.utills.CommonModule;
import com.mezzofy.MzCouponAPI.utills.JSONSTRINGS;

import org.json.JSONObject;

public class MZChannel {

    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    private JSONObject jsonobj = null;
    Context context;



    public MZChannel(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }

    public ChannelLocationDataListModel getChannelLocationList() {

            String Chennellocation =  jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/channellocations");

            ChannelLocationDataListModel sChannelLocationModelList = gson.fromJson(Chennellocation, ChannelLocationDataListModel.class);

            return sChannelLocationModelList;

    }


}
