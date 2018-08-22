package mezzofy.com.libmzcoupon.module;

import android.content.Context;

import com.google.gson.Gson;

import mezzofy.com.libmzcoupon.data.MerchantDataModel;
import mezzofy.com.libmzcoupon.utills.CommonModule;
import mezzofy.com.libmzcoupon.utills.JSONSTRINGS;

/**
 * Created by aruna on 2/15/18.
 */

public class MZMerchant {
    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    Context context;



    public MZMerchant(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }

    public MerchantDataModel GetMerchantById(String merchantId) {

        String merchant = JSONSTRINGS.getJSONFromUrl1(CommonModule.getplatformpath(context) + "merchants/" + merchantId);
        MerchantDataModel merchantmodel = gson.fromJson(merchant, MerchantDataModel.class);

        return merchantmodel;

    }
}
