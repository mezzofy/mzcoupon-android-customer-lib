package mezzofy.com.libmzcoupon.module;

import android.content.Context;

import com.google.gson.Gson;

import mezzofy.com.libmzcoupon.data.WalletDataModel;
import mezzofy.com.libmzcoupon.utills.CommonModule;
import mezzofy.com.libmzcoupon.utills.JSONSTRINGS;


/**
 * Created by aruna on 2/15/18.
 */

public class MZTransaction {
    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    Context context;



    public MZTransaction(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }

    public WalletDataModel GetCustomerTransactions(String customerId) {
        WalletDataModel walletmData = null;

        Gson gson = new Gson();
        String campaign = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/wallet/balance/"+customerId);

        walletmData  = gson.fromJson(campaign, WalletDataModel.class);

        return walletmData;
    }
}
