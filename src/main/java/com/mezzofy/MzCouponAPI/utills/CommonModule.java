package com.mezzofy.MzCouponAPI.utills;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class CommonModule {

    static String ProductionServervalues=null;

    public static String getlocal() {
        return "http://172.16.25.16:8080/admin/";
    }

    public static String getplatformpath(Context context) {


        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
//            String myApiKey = bundle.getString("my_api_key");
            ProductionServervalues=bundle.getString("Production_Server");
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("err", "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e) {
            Log.e("err", "Failed to load meta-data, NullPointer: " + e.getMessage());
        }


        if(ProductionServervalues!=null && ProductionServervalues.equals("NO"))
            return "http://platform.uat.mezzofy.com/api/v1/";
        else
            return "http://platform.mezzofy.com/api/v1/";
    }

    public static String getUserpath(Context context) {
        String MerchantId =null;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
           MerchantId = bundle.getString("MerchantId");
            ProductionServervalues=bundle.getString("Production_Server");

        } catch (PackageManager.NameNotFoundException e) {
            Log.e("err", "Failed to load meta-data, NameNotFound: " + e.getMessage());
        } catch (NullPointerException e) {
            Log.e("err", "Failed to load meta-data, NullPointer: " + e.getMessage());
        }


        if(ProductionServervalues!=null && ProductionServervalues.equals("NO"))
          return "http://"+ MerchantId+".uat.mezzofy.com/";
        else
            return "http://"+ MerchantId+".mezzofy.com/";

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

        return credencial_Secret;
    }


}
