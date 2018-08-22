package mezzofy.com.libmzcoupon.module;

import android.content.Context;

import com.google.gson.Gson;


import java.io.IOException;
import java.net.URL;

import mezzofy.com.libmzcoupon.data.JsonResponseStatus;
import mezzofy.com.libmzcoupon.data.PaymentListDataModel;
import mezzofy.com.libmzcoupon.data.PoData;
import mezzofy.com.libmzcoupon.data.PomData;
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

public class MZPayment {
    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    Context context;



    public MZPayment(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }

    public PaymentListDataModel GetPayments() {

        String payment = jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/payments/paymentdtls?page=1");
        PaymentListDataModel paymentListmData= gson.fromJson(payment, PaymentListDataModel.class);
        return paymentListmData;
    }

    public PoData RequestChargeCoupons(PomData pomData)throws APIServerException {

        PomData resp=null;

        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/pos/paypal");
            OkHttpClient client = new OkHttpClient.Builder().build();

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),gson.toJson(pomData).toString());
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

                resp=gson.fromJson(newResponse.body().string(), PomData.class);
            }
            else
            {
                ResponseBody responseBody = response.body();
                String responseBodyString = response.body().string();
                Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), responseBodyString.getBytes())).build();
                JsonResponseStatus responsedatastatus=gson.fromJson(newResponse.body().string(), JsonResponseStatus.class);
                throw new APIServerException(responsedatastatus.getMessage(),responsedatastatus.getCode(),responsedatastatus.getDeveloperMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp.getPo();
    }

    public PoData RequestFreeCoupon(PomData pomData) throws APIServerException{

        PomData resp=null;

        try {

            URL url = new URL(CommonModule.getUserpath(context) + "api/v1/pos");
            OkHttpClient client = new OkHttpClient.Builder().build();

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),gson.toJson(pomData).toString());
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

                resp=gson.fromJson(newResponse.body().string(), PomData.class);
            }
            else
            {
                ResponseBody responseBody = response.body();
                String responseBodyString = response.body().string();
                Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), responseBodyString.getBytes())).build();
                JsonResponseStatus responsedatastatus=gson.fromJson(newResponse.body().string(), JsonResponseStatus.class);
                throw new APIServerException(responsedatastatus.getMessage(),responsedatastatus.getCode(),responsedatastatus.getDeveloperMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resp.getPo();
    }



//    public PaymentDetailDataModel PaymentUpdate(PaymentDetailDataModel paymentDetailmData)throws APIServerException {
//
//        PaymentDetailDataModel resp = null;
//
//        try {
//
//            URL url = new URL(CommonModule.getUserpath(context) + "payments");
//            OkHttpClient client = new OkHttpClient.Builder().build();
//            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), gson.toJson(paymentDetailmData).toString());
//            String credential = Credentials.basic(CommonModule.getKey(context),CommonModule.getSecretkey(context));
//            Request request = new Request.Builder()
//                    .url(url)
//                    .header("Authorization", credential)
//                    .put(body)
//                    .build();
//
//            Response response = client.newCall(request).execute();
//
//            if (response.isSuccessful()) {
//                ResponseBody responseBody = response.body();
//                String responseBodyString = response.body().string();
//                Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), responseBodyString.getBytes())).build();
//
//                resp = gson.fromJson(newResponse.body().string(), PaymentDetailDataModel.class);
//
//            } else
//            {
//                ResponseBody responseBody = response.body();
//                String responseBodyString = response.body().string();
//                Response newResponse = response.newBuilder().body(ResponseBody.create(responseBody.contentType(), responseBodyString.getBytes())).build();
//                JsonResponseStatus responsedatastatus=gson.fromJson(newResponse.body().string(), JsonResponseStatus.class);
//                throw new APIServerException(responsedatastatus.getMessage(),responsedatastatus.getCode(),responsedatastatus.getDeveloperMessage());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return resp;
//    }

}
