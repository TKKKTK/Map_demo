package com.wg.map_demo;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.navi.NaviSetting;
import com.amap.api.services.core.ServiceSettings;
import com.wg.map_demo.data.DaoMaster;
import com.wg.map_demo.data.DaoSession;

public class MapApplication extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        //定位隐私政策同意
        AMapLocationClient.updatePrivacyShow(this,true,true);
        AMapLocationClient.updatePrivacyAgree(this,true);
        //地图隐私政策同意
        MapsInitializer.updatePrivacyShow(this,true,true);
        MapsInitializer.updatePrivacyAgree(this,true);
        //导航隐私政策同意
        NaviSetting.updatePrivacyShow(this, true, true);
        NaviSetting.updatePrivacyAgree(this, true);
        //搜索隐私政策同意
        ServiceSettings.updatePrivacyShow(this,true,true);
        ServiceSettings.updatePrivacyAgree(this,true);

        initDreenDao();
    }

    /**
     * greendao数据库初始化
     */
    private void initDreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "demo.db");
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    /**
     * 获取 DaoSession
     */
    public DaoSession getDaoSession() {
        return daoSession;
    }
}
