package mezzofy.com.libmzcoupon.module;

import android.content.Context;

import com.google.gson.Gson;


import java.io.IOException;
import java.net.URL;

import mezzofy.com.libmzcoupon.data.CountryListDataModel;
import mezzofy.com.libmzcoupon.data.CustomerDataModel;
import mezzofy.com.libmzcoupon.data.CustomerDeviceDataModel;
import mezzofy.com.libmzcoupon.data.CustomerGroupDataModel;
import mezzofy.com.libmzcoupon.data.JsonResponseStatus;
import mezzofy.com.libmzcoupon.utills.APIServerException;
import mezzofy.com.libmzcoupon.utills.CommonModule;
import mezzofy.com.libmzcoupon.utills.JSONSTRINGS;
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

public class MZCustomer {
    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    Context context;

    public MZCustomer(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }

    public CustomerDataModel PasswordForgot(CustomerDataModel customermData)  throws APIServerException {

        CustomerDataModel resp = null;
        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/customers/forget");

            OkHttpClient client = new OkHttpClient.Builder().build();

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(customermData).toString());
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

                resp = gson.fromJson(newResponse.body().string(), CustomerDataModel.class);
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

    public CustomerDataModel PasswordChange(CustomerDataModel customerModel)  throws APIServerException{

        CustomerDataModel resp = null;
        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/customers/changepassword");

            OkHttpClient client = new OkHttpClient.Builder().build();

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(customerModel).toString());
            String credential = Credentials.basic(CommonModule.getKey(context),CommonModule.getSecretkey(context));

            Request request = new Request.Builder()
                    .url(url)
                    .header("Authorization", credential)
                    .put(body)
                    .build();

            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                String responseBodyString = response.body().string();

                Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), responseBodyString.getBytes())).build();

                resp = gson.fromJson(newResponse.body().string(), CustomerDataModel.class);
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


    public CustomerDataModel LoginFacebook(CustomerDeviceDataModel userModel) throws APIServerException {

        CustomerDataModel resp = null;
        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/customers/facebookauth");

            OkHttpClient client = new OkHttpClient.Builder().build();

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(userModel).toString());
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

                resp = gson.fromJson(newResponse.body().string(), CustomerDataModel.class);
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


    public CustomerDataModel  LoginPlatform(CustomerDeviceDataModel userModel)  throws APIServerException {

        CustomerDataModel resp = null;
        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/customers/auth");

            OkHttpClient client = new OkHttpClient.Builder().build();
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(userModel).toString());
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
                resp = gson.fromJson(newResponse.body().string(), CustomerDataModel.class);
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



    public CustomerDataModel CustomerUpdate(CustomerDataModel customerModel) throws APIServerException  {

        CustomerDataModel resp = null;
        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/customers/"+customerModel.getCustomer().getCustomerId());

            OkHttpClient client = new OkHttpClient.Builder().build();

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(customerModel).toString());
            String credential = Credentials.basic(CommonModule.getKey(context),CommonModule.getSecretkey(context));

            Request request = new Request.Builder()
                    .url(url)
                    .header("Authorization", credential)
                    .put(body)
                    .build();

            Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                String responseBodyString = response.body().string();

                Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), responseBodyString.getBytes())).build();

                resp = gson.fromJson(newResponse.body().string(), CustomerDataModel.class);
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


    public CustomerDataModel CustomerSignup(CustomerDataModel customermodel) throws APIServerException {


        CustomerDataModel resp = null;
        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/customers");

            OkHttpClient client = new OkHttpClient.Builder().build();

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(customermodel).toString());
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

                resp = gson.fromJson(newResponse.body().string(), CustomerDataModel.class);
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

    public CustomerGroupDataModel GetCustomerGroupById(String customergroupid) {

        String customergroup = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/customergroups/" + customergroupid);
        CustomerGroupDataModel customerGroupmData = gson.fromJson(customergroup, CustomerGroupDataModel.class);

        return customerGroupmData;
    }

    public CountryListDataModel GetCountries() {

        Gson gson = new Gson();
        String res = JSONSTRINGS.getJSONFromUrl1(CommonModule.getplatformpath(context) + "countries");
        CountryListDataModel ret = gson.fromJson(res, CountryListDataModel.class);
        return ret;
    }

}
