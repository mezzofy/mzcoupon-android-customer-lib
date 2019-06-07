package mezzofy.com.mzcouponlib;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import mezzofy.com.libmzcoupon.module.MZCampaign;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MZCampaign mzCampaign=new MZCampaign(getApplicationContext());

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
        }else
            Log.d("Campaigns", mzCampaign.getCampaigns("C1000004", 1, 0.0,0.0).toString());

    }
}
