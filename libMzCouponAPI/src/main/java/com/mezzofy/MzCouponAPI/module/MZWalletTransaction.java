package com.mezzofy.MzCouponAPI.module;

import android.content.Context;

import com.google.gson.Gson;
import com.mezzofy.MzCouponAPI.data.JsonResponseStatus;
;
import com.mezzofy.MzCouponAPI.data.WalletTxnListDataModel;
import com.mezzofy.MzCouponAPI.data.WalletTxnDataModel;
import com.mezzofy.MzCouponAPI.utills.APIServerException;
import com.mezzofy.MzCouponAPI.utills.CommonModule;
import com.mezzofy.MzCouponAPI.utills.JSONSTRINGS;


import java.io.IOException;

import java.net.URL;

import okhttp3.Credentials;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by aruna on 2/15/18.
 */

public class MZWalletTransaction {
    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    Context context;

    public MZWalletTransaction(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }


    public WalletTxnListDataModel GetWalletTransactions(String customerId, String status, int Pages) {
        WalletTxnListDataModel walletTxnListModel = null;
        String campaign = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/wallettxn?customer_id="+customerId+"&status="+status+"&page"+Pages);
        walletTxnListModel  = gson.fromJson(campaign, WalletTxnListDataModel.class);
        return walletTxnListModel;
    }


    public WalletTxnDataModel WalletTransactionCreate(WalletTxnDataModel walletTxnmData) throws APIServerException {
        WalletTxnDataModel resp = null;
        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/wallettxn");


            OkHttpClient client = new OkHttpClient.Builder().build();

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(walletTxnmData).toString());
            String credential = Credentials.basic(CommonModule.getKey(context),CommonModule.getSecretkey(context));
            Request request = new Request.Builder()
                    .url(url)
                    .header("Authorization", credential)
                    .post(body)
                    .build();

            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                String responseBodyString = response.body().string();
                Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), responseBodyString.getBytes())).build();

                resp=gson.fromJson(newResponse.body().string(), WalletTxnDataModel.class);
            } else {
                ResponseBody responseBody = response.body();
                String responseBodyString = response.body().string();
                Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), responseBodyString.getBytes())).build();
                JsonResponseStatus responsedatastatus = gson.fromJson(newResponse.body().string(), JsonResponseStatus.class);
                throw new APIServerException(responsedatastatus.getMessage(),responsedatastatus.getCode(),responsedatastatus.getDeveloperMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return resp;
    }
}
