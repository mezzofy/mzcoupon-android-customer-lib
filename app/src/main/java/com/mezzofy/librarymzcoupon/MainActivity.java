package com.mezzofy.librarymzcoupon;


import android.app.Activity;
import android.os.Bundle;

import com.mezzofy.MzCouponAPI.data.CampaignsData;
import com.mezzofy.MzCouponAPI.module.MZCampaign;

public class MainActivity extends Activity {

    private MZCampaign mzCampaign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mzCampaign=new MZCampaign(getApplicationContext());



        CampaignsData campaignsData=mzCampaign.getCampaigns(1,0,0);
    }
}
