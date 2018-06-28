# MZCoupon Android SDK


![](http://www.mezzofy.com/images/logoz.png)

This is a repository of our open source Android SDK, and the information presented here serves as a reference manual for our Android SDK. See the [Getting started](https://developer.android.com/guide/slices/getting-started) section for more details.


#### Installation Guide for MZCoupon

In your `build.gradle`: app
```groovy
allprojects {
        repositories {
            maven { url 'https://www.jitpack.io' }
        }
    }
```
```groovy
dependencies {
  compile 'com.github.mezzofy:mzcoupon-android-customer-lib:1.0.0'
}
```
## Initialize MZCoupon

### Configure your AndroidManifest.xml

Note: Provide internet permission. MZCoupon SDK need internet access to talk to Mezzofy APIs.

#### Add your MZCoupon key to your project.

 Edit your manifest file to have the above items
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    android:versionCode="1"
    android:versionName="1.0" >

    <uses-permission android:name="android.permission.INTERNET" />

    <application>
        <!-- Other existing entries -->

        <!-- Add this meta-data below, and change "XXXXX" to your actual live MZCoupon key -->
        <meta-data
            android:name="MerchantId"
            android:value="COM_CODE"/>

        <meta-data
            android:name="credencial_Key"
            android:value="XXXXX"/>

        <meta-data
            android:name="credencial_Secret"
            android:value="X"/>
    </application>
</manifest>
```
***Hints:*** 
*1.Where "COM_CODE" companycode, Credencial Key ("XXXXX") and Credencial Secret ("X") provide by the Merchant*

##### How to get Company Code & AccessToken
Login to Merchant Account 

![](https://s3-ap-southeast-1.amazonaws.com/mzcouponuat/email/merchant_profile.jpg)


### Implementation Guide

**Call Function For Campaign** 

```java
public class Campaign_Module {
  
    MZCampaign campaignModule;

    public Campaign_Module(Context context) {
     
        campaignModule = new MZCampaign(context);
    }


    public List<CampaignmEntity> getCampaignsfromServerAPI(int pagesize, double latitude, double longitude) {

        List<CampaignmEntity> campaignsEntityList = null;
        try {
            CampaignsData campaigns = campaignModule.getCampaigns(pagesize, latitude, longitude);
            if (campaigns != null) {

                CampaignsEntity campaignsEntity = (CampaignsEntity) JsonMapper.mapJsonToObj(campaigns, CampaignsEntity.class);
                campaignsEntityList=campaignsEntity.getCampaigns();

               }

        return campaignsEntityList;
  	 }
	}
```
**Return**

List<CampaignmEntity>

**Call Function For Coupon** 

``` java
public class Coupon_Module {
    MZCoupon couponModule;

    public Coupon_Module(Context context) {
    
        couponModule = new MZCoupon(context);
        
    }


    public List<CustomerCouponmEntity> getcouponlistfromserver(String customerId, String couponstatus, int page) {
        List<CustomerCouponmEntity> customerCouponModelList = null;

        CustomerCouponListDataModel customerCouponListmData = couponModule.getCoupons(customerId, couponstatus, page);
        if (customerCouponListmData != null){}

            customerCouponModelList = customerCouponListmData.getCustomercoupons();

        }

        return customerCouponModelList;
    }
```
**Return**

List<CustomerCouponmEntity>

##### Click here for [Full Implementation Guide](https://github.com/mezzofy/mzcoupon-android-customer-lib)

# Licenses

All source code is licensed under the [MIT License.](https://raw.githubusercontent.com/mezzofy/mzcoupon-ios-customer-lib/master/LICENSE)


### End


