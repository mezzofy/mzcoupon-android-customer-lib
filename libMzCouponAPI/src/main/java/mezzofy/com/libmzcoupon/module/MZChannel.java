package mezzofy.com.libmzcoupon.module;

import android.content.Context;


import com.google.gson.Gson;

import org.json.JSONObject;

import mezzofy.com.libmzcoupon.data.ChannelLocationDataListModel;
import mezzofy.com.libmzcoupon.utills.CommonModule;
import mezzofy.com.libmzcoupon.utills.JSONSTRINGS;

public class MZChannel {

    Gson gson = new Gson();
    JSONSTRINGS jsonstrings;
    private JSONObject jsonobj = null;
    Context context;



    public MZChannel(Context context){
        this.context = context;
        jsonstrings=new JSONSTRINGS(context);
    }

    public ChannelLocationDataListModel getChannelLocationList() {

            String Chennellocation =  jsonstrings.getJSONFromUrl(CommonModule.getUserpath(context) + "api/v1/channellocations");

            ChannelLocationDataListModel sChannelLocationModelList = gson.fromJson(Chennellocation, ChannelLocationDataListModel.class);

            return sChannelLocationModelList;

    }


}
