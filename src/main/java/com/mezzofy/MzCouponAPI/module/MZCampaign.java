package com.mezzofy.MzCouponAPI.module;

import android.content.Context;


import com.google.gson.Gson;
import com.mezzofy.MzCouponAPI.data.CampaignDataModel;
import com.mezzofy.MzCouponAPI.data.CampaignsData;
import com.mezzofy.MzCouponAPI.data.JsonResponseStatus;
import com.mezzofy.MzCouponAPI.data.OvercouponData;
import com.mezzofy.MzCouponAPI.data.Size;
import com.mezzofy.MzCouponAPI.data.CampaignGroupListDataModel;
import com.mezzofy.MzCouponAPI.data.CampaignGroupDataModel;
import com.mezzofy.MzCouponAPI.data.CampaignSearchDataModel;
import com.mezzofy.MzCouponAPI.utills.APIServerException;
import com.mezzofy.MzCouponAPI.utills.CommonModule;
import com.mezzofy.MzCouponAPI.utills.JSONSTRINGS;


import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.List;

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

public class MZCampaign {
    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    private JSONObject jsonobj = null;
    Context context;



    public MZCampaign(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }

    public CampaignsData getCampaigns(int pagesize, double latitude, double longitude) {

        Gson gson = new Gson();
        String campaign = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/campaigns/customercampaigns?status=A&page="+pagesize+"&latitude"+latitude+"&longitude"+longitude);
        CampaignsData sCampaignss = gson.fromJson(campaign, CampaignsData.class);

        return sCampaignss;
    }


    public List<CampaignDataModel> getCampaignsWithFilter(CampaignSearchDataModel campaignSearchModel)throws APIServerException {
        List<CampaignDataModel> resp = null;
        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/campaigns/campaignsearch");


            OkHttpClient client = new OkHttpClient.Builder().build();

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(campaignSearchModel).toString());
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

                CampaignsData campaigns=gson.fromJson(newResponse.body().string(), CampaignsData.class);
                resp=campaigns.getCampaigns();

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

    public CampaignDataModel getCampaignById(String campaignId, double latitude, double longitude) {

        String campaign = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/campaigns/campaigndistance/"+campaignId+"?latitude"+latitude+"&longitude"+longitude);
        CampaignDataModel sCampaignss = gson.fromJson(campaign, CampaignDataModel.class);

        return sCampaignss;
    }
    public CampaignGroupListDataModel getCampaignGroups() {
        List<CampaignGroupDataModel> campaignGroupModels = null;
        Size size=null;

        Gson gson = new Gson();
        String campaigngroup = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/campaigngroups");

        CampaignGroupListDataModel sCampaignss = gson.fromJson(campaigngroup, CampaignGroupListDataModel.class);

        return sCampaignss;
    }


    public int checkProductAvilability(String campaignId, int qty) {

        Gson gson = new Gson();
        String stackqty = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/pos/overcoupon/" + campaignId + "?qty=" + qty);
        OvercouponData Qty = gson.fromJson(stackqty, OvercouponData.class);

        if (Qty != null)
            return Qty.getCouponcount();
        else
            return 1;
    }

    public CampaignsData getCampaignsTop() {

        Gson gson = new Gson();
        String campaign = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) +"api/v1/campaigns/topcoupon");

        CampaignsData sCampaignss = gson.fromJson(campaign, CampaignsData.class);

        return sCampaignss;
    }

//    public String getCampaignsCode() {
//
//        Gson gson = new Gson();
//        String code=null;
//        String campaigncode = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/campaigns/campaigncode");
//        CampaignDataModel sCampaignss = gson.fromJson(campaigncode, CampaignDataModel.class);
//
//        if(sCampaignss!=null)
//            code=sCampaignss.getCampaign().getCampaignCode();
//
//        return code;
//    }
}
