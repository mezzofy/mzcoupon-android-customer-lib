package com.mezzofy.MzCouponAPI.utills;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import com.mezzofy.MzCouponAPI.module.MZCampaign;

import static android.R.attr.key;

public class CommonModule {

    static SharedPreferences settings;

    public CommonModule(Context context) {
        settings = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String getlocal() {
        return "http://172.16.25.16:8080/admin/";
    }

    public static String getplatformpath(Context context) {

        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            String myApiKey = bundle.getString("my_api_key");
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("err", "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e) {
            Log.e("err", "Failed to load meta-data, NullPointer: " + e.getMessage());
        }

        return "http://platform.uat.mezzofy.com/api/v1/";
    }

    public static String getUserpath(Context context) {
        String MerchantId =null;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
           MerchantId = bundle.getString("MerchantId");

        } catch (PackageManager.NameNotFoundException e) {
            Log.e("err", "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e) {
            Log.e("err", "Failed to load meta-data, NullPointer: " + e.getMessage());
        }

        Log.d("MerchantId", "" + "http://"+ MerchantId+".uat.mezzofy.com/");
        settings = PreferenceManager.getDefaultSharedPreferences(context);
        String flage=settings.getString("Credencialflag",null);

        if(flage!=null && flage.equals("Yes"))
            MerchantId=settings.getString("MerchantId",null);

        return "http://"+ MerchantId+".uat.mezzofy.com/";

    }

    public static String getKey(Context context) {

        String credencial_Key =null;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            credencial_Key = bundle.getString("credencial_Key");

        } catch (PackageManager.NameNotFoundException e) {
            Log.e("err", "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e) {
            Log.e("err", "Failed to load meta-data, NullPointer: " + e.getMessage());
        }
        settings = PreferenceManager.getDefaultSharedPreferences(context);
        String flage=settings.getString("Credencialflag",null);

        if(flage!=null && flage.equals("Yes"))
            credencial_Key=settings.getString("Credencialkey",null);

        return credencial_Key;


    }

    public static String getSecretkey(Context context) {
        String credencial_Secret =null;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            credencial_Secret = bundle.getString("credencial_Secret");

        } catch (PackageManager.NameNotFoundException e) {
            Log.e("err", "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e) {
            Log.e("err", "Failed to load meta-data, NullPointer: " + e.getMessage());
        }
        settings = PreferenceManager.getDefaultSharedPreferences(context);
        String flage=settings.getString("Credencialflag",null);

        if(flage!=null && flage.equals("Yes"))
            credencial_Secret=settings.getString("Credencialsecret",null);

        return credencial_Secret;
    }


}
