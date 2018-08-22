package mezzofy.com.libmzcoupon.module;

import android.content.Context;

import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

import mezzofy.com.libmzcoupon.data.SiteDataModel;
import mezzofy.com.libmzcoupon.data.SiteListDataModel;
import mezzofy.com.libmzcoupon.utills.CommonModule;
import mezzofy.com.libmzcoupon.utills.JSONSTRINGS;

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
