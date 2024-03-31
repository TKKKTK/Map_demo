package com.wg.map_demo;

import android.app.Application;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.navi.NaviSetting;
import com.amap.api.services.core.ServiceSettings;

public class MapApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //定位隐私政策同意
        AMapLocationClient.updatePrivacyShow(this,true,true);
        AMapLocationClient.updatePrivacyAgree(this,true);
        //地图隐私政策同意
//        MapsInitializer.updatePrivacyShow(this,true,true);
//        MapsInitializer.updatePrivacyAgree(this,true);
        //导航隐私政策同意
//        NaviSetting.updatePrivacyShow(this, true, true);
//        NaviSetting.updatePrivacyAgree(this, true);
        //搜索隐私政策同意
        ServiceSettings.updatePrivacyShow(this,true,true);
        ServiceSettings.updatePrivacyAgree(this,true);
    }
}
