package com.mezzofy.MzCouponAPI.module;

import android.content.Context;


import com.google.gson.Gson;
import com.mezzofy.MzCouponAPI.data.JsonResponseStatus;
import com.mezzofy.MzCouponAPI.data.CustomerCouponListDataModel;
import com.mezzofy.MzCouponAPI.data.CustomerCouponDataModel;
import com.mezzofy.MzCouponAPI.data.GiftcouponDataModel;
import com.mezzofy.MzCouponAPI.data.MassCouponDataModel;
import com.mezzofy.MzCouponAPI.data.SiteDataModel;
import com.mezzofy.MzCouponAPI.data.StockData;
import com.mezzofy.MzCouponAPI.data.StockDataModel;
import com.mezzofy.MzCouponAPI.utills.APIServerException;
import com.mezzofy.MzCouponAPI.utills.CommonModule;
import com.mezzofy.MzCouponAPI.utills.JSONSTRINGS;

import org.json.JSONObject;

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
 * Created by aruna on 2/14/18.
 */

public class MZCoupon {
    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    private JSONObject jsonobj = null;
    Context context;



    public MZCoupon(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }

    public CustomerCouponListDataModel getCoupons(String customerId, String couponstatus, int page) {

        String campaign = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/customercoupons?customerid="+customerId+"&status="+couponstatus+"&page="+page);

        CustomerCouponListDataModel customerCouponListmData = gson.fromJson(campaign, CustomerCouponListDataModel.class);

        return customerCouponListmData;
    }

    public MassCouponDataModel getMassCouponDetail(String siteId, String refId) {
        MassCouponDataModel massCouponmData = null;

        String coupon = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/massrefer/"+refId+"?siteid="+siteId);

        massCouponmData = gson.fromJson(coupon, MassCouponDataModel.class);

        return massCouponmData;
    }

    public CustomerCouponDataModel getCouponById(String CouponId) {
        CustomerCouponDataModel customerCouponmData = null;

        String coupon = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/coupons/"+CouponId);

        customerCouponmData = gson.fromJson(coupon, CustomerCouponDataModel.class);

        return customerCouponmData;
    }

    public SiteDataModel checkSitePass(String sitepass) {
        SiteDataModel sitemData = null;

        Gson gson = new Gson();
        String coupon = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/sites/sitepass/"+sitepass);

        sitemData = gson.fromJson(coupon, SiteDataModel.class);

        return sitemData;
    }



    public int getredeamstockfromserver(String CouponId,String CamId) {
        StockDataModel stockModel = null;

        int stockqty;

        Gson gson = new Gson();
        String coupon = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + " api/v1/orders/redeamstock/"+CamId+"?couponid="+CouponId);

        stockModel = gson.fromJson(coupon, StockDataModel.class);

        if(stockModel!=null)
            stockqty= stockModel.getStock().getStockqty();
        else
            stockqty= 0;
        return stockqty;
    }



    public CustomerCouponListDataModel getCouponsByStatus(String customerId,int page) {

        Gson gson = new Gson();
        String campaign = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/customercoupons/customercampaigns?customerid="+customerId+"&status=A"+"&page="+page);

        CustomerCouponListDataModel customerCouponListModel = gson.fromJson(campaign, CustomerCouponListDataModel.class);

        return customerCouponListModel;
    }

    public CustomerCouponListDataModel getCouponsByCampiagn(String Campaignid, String CustomerId, String couponstatus, int page) {
        Gson gson = new Gson();
        String campaign = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/customercoupons/campaign/"+Campaignid+"?customerid="+CustomerId+"&status="+couponstatus+"&page="+page);


        CustomerCouponListDataModel customerCouponListModel = gson.fromJson(campaign, CustomerCouponListDataModel.class);

        return customerCouponListModel;
    }


    public StockDataModel ReleaseCouponStockByCampaignId(String CampaignId,String CouponId){
        Gson gson = new Gson();
        String Stockdata = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/orders/releasestock/"+CampaignId+"?couponid="+CouponId);


        StockDataModel stockDataModel = gson.fromJson(Stockdata, StockDataModel.class);

        return stockDataModel;
    }



    public GiftcouponDataModel SendGiftCoupon(GiftcouponDataModel giftcouponModel) throws APIServerException {
        GiftcouponDataModel resp = null;
        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/customercoupons/sharecoupon");


            OkHttpClient client = new OkHttpClient.Builder().build();

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(giftcouponModel).toString());
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

                resp=gson.fromJson(newResponse.body().string(), GiftcouponDataModel.class);

            }else{
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


//    public CustomerCouponListDataModel getActivecoupon(String customerId, int page) {
//        Gson gson = new Gson();
//        String campaign = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/customercoupons/campaigns?customerid="+customerId+"&status=A&page="+page);
//
//        CustomerCouponListDataModel customerCouponListModel = gson.fromJson(campaign, CustomerCouponListDataModel.class);
//
//        return customerCouponListModel;
//    }

}
