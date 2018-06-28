package com.mezzofy.MzCouponAPI.module;

import android.content.Context;

import com.google.gson.Gson;

import com.mezzofy.MzCouponAPI.data.SiteListDataModel;
import com.mezzofy.MzCouponAPI.data.SiteDataModel;
import com.mezzofy.MzCouponAPI.utills.CommonModule;
import com.mezzofy.MzCouponAPI.utills.JSONSTRINGS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aruna on 2/27/18.
 */

public class MZSite {
    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    Context context;



    public MZSite(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }

    public List<SiteDataModel> GetMerchantSites(){
        List<SiteDataModel> sitelst = new ArrayList<SiteDataModel>();

        int totalpage = 1;
        for (int i = 1; i <= totalpage; i++) {
            String val = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/sites?page="+i);
            SiteListDataModel siteListmData = gson.fromJson(val, SiteListDataModel.class);

            if (siteListmData != null) {
                totalpage = siteListmData.getSize().getPagesize();
                sitelst.addAll(siteListmData.getSites());
            }
        }

        if (sitelst.size() > 0)
            return sitelst;
        else
            return sitelst = null;

    }

}
