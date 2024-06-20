package com.wg.map_demo.mapview.sd;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.MyLocationStyle;
import com.wg.map_demo.R;
import com.wg.map_demo.base.BaseMapLayout;
import com.wg.map_demo.util.ContextUtil;

public class Sdlayout extends BaseMapLayout implements SdNaviListener, LocationListener, LocationSource {
    private TextureMapView textureMapView;

    private AMap aMap;

    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;
    //声明定位蓝点信息
    MyLocationStyle myLocationStyle;

    private OnLocationChangedListener mListener;


    private UiSettings mUiSettings;//定义一个UiSettings对象

    public Sdlayout(@NonNull Context context) {
        this(context, null);
    }

    public Sdlayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Sdlayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.home_sd_layout,this);
        textureMapView = findViewById(R.id.home_sd_map);
    }
    public void onCreate(Bundle savedInstanceState){
        textureMapView.onCreate(savedInstanceState);
        initMap();
        initLocation();
        initLocationStyle();
        //开启定位
        startLocation();
    }

    private void initMap(){
        //初始化地图控制器对象
        if (aMap == null) {
            aMap = textureMapView.getMap();
        }
        // 设置定位监听
        aMap.setLocationSource(this);
        // 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setMyLocationEnabled(true);
        mUiSettings = aMap.getUiSettings();//实例化UiSettings类对象
        //设置缩放按钮是否隐藏
        mUiSettings.setZoomControlsEnabled(false);
        mUiSettings.setCompassEnabled(true);
        mUiSettings.setMyLocationButtonEnabled(true);
    }

    /**
     * 初始化定位相关信息
     * @throws Exception
     */
    private void initLocation(){
        try {
            mLocationClient = new AMapLocationClient(ContextUtil.getApp());
            mLocationClient.setLocationListener(this);
            mLocationOption = new AMapLocationClientOption();
            /**
             * 设置定位场景，目前支持三种场景（签到、出行、运动，默认无场景）
             */
            mLocationOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport);

            //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            //设置定位间隔,单位毫秒,默认为2000ms，最低1000ms。
            mLocationOption.setInterval(1000);
            //设置是否返回地址信息（默认返回地址信息）
            mLocationOption.setNeedAddress(true);
            //单位是毫秒，默认30000毫秒，建议超时时间不要低于8000毫秒。
            mLocationOption.setHttpTimeOut(20000);
            //关闭缓存机制
            mLocationOption.setLocationCacheEnable(false);


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 初始化定位蓝点信息
     */
    private void initLocationStyle(){
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(1000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，地图依照设备方向旋转，定位点会跟随设备移动。（1秒1次定位）
        myLocationStyle.anchor(0.5f, 0.5f);//设置定位蓝点图标的锚点方法。
        myLocationStyle.showMyLocation(true); //是否显示定位蓝点
        myLocationStyle.strokeColor(Color.argb(1,0,0,0));//设置定位蓝点精度圆圈的边框颜色的方法。
        myLocationStyle.radiusFillColor(Color.argb(1,0,0,0));//设置定位蓝点精度圆圈的填充颜色的方法。
        myLocationStyle.strokeWidth(0.0f);//设置定位蓝点精度圈的边框宽度的方法。
        //myLocationStyle.myLocationIcon(new BitmapDescriptor()); //自定义定位图标
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        //aMap.getUiSettings().setMyLocationButtonEnabled(true);设置默认定位按钮是否显示，非必需设置。
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
    }

    /**
     * 启动定位
     */
    private void startLocation(){
        //给定位客户端对象设置定位参数
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.stopLocation();
        //启动定位
        mLocationClient.startLocation();
    }



    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        textureMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        textureMapView.onPause();
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        textureMapView.onResume();
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        textureMapView.onDestroy();
    }

    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        LocationListener.super.onLocationChanged(aMapLocation);
        if (mListener != null&&aMapLocation != null) {
            if (aMapLocation != null
                    &&aMapLocation.getErrorCode() == 0) {
                mListener.onLocationChanged(aMapLocation);// 显示系统小蓝点
            } else {
                String errText = "定位失败," + aMapLocation.getErrorCode()+ ": " + aMapLocation.getErrorInfo();
                Log.e("AmapErr",errText);
            }
        }

        Log.d("MainActivity", "onLocationChanged: 纬度==>" + aMapLocation.getLatitude() + "经度==>" + aMapLocation.getLongitude());
    }

    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        mListener = onLocationChangedListener;
    }

    @Override
    public void deactivate() {
        if (mLocationClient != null){
            mLocationClient.stopLocation();
            mLocationClient.onDestroy();
        }
    }
}
