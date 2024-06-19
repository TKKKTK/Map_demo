package com.wg.map_demo.mapview.sd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.amap.api.maps.AMapException;
import com.amap.api.maps.TextureMapView;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.view.RouteOverLay;
import com.wg.map_demo.R;
import com.wg.map_demo.util.ContextUtil;

import java.util.ArrayList;
import java.util.List;

public class SdLayout extends FrameLayout implements DefaultLifecycleObserver,SdNaviListener{
    protected TextureMapView mAMapNaviView;
    protected AMapNavi mAMapNavi;
    protected NaviLatLng mEndLatlng = new NaviLatLng(40.084894,116.603039);
    protected NaviLatLng mStartLatlng = new NaviLatLng(39.825934,116.342972);
    protected final List<NaviLatLng> sList = new ArrayList<NaviLatLng>();
    protected final List<NaviLatLng> eList = new ArrayList<NaviLatLng>();
    protected List<NaviLatLng> mWayPointList;

    NaviLatLng p1 = new NaviLatLng(39.993266, 116.473193);//首开广场
    NaviLatLng p2 = new NaviLatLng(39.917337, 116.397056);//故宫博物院
    NaviLatLng p3 = new NaviLatLng(39.904556, 116.427231);//北京站
    NaviLatLng p4 = new NaviLatLng(39.773801, 116.368984);//新三余公园(南5环)
    NaviLatLng p5 = new NaviLatLng(40.041986, 116.414496);//立水桥(北5环)

    /**
     * 自车位置类
     */
    CarOverlay carOverlay;
    /**
     * 路线Overlay
     */
    RouteOverLay routeOverLay;

    public SdLayout(@NonNull Context context) {
        this(context,null);
    }

    public SdLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SdLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.sd_layout,this);
        mAMapNaviView = view.findViewById(R.id.sd_mapview);
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        try {
            mAMapNavi = AMapNavi.getInstance(ContextUtil.getApp().getApplicationContext());
            mAMapNavi.addAMapNaviListener(this);
            mAMapNavi.setUseInnerVoice(true);

            //设置模拟导航的行车速度
            mAMapNavi.setEmulatorNaviSpeed(75);
            sList.add(p3);
            eList.add(p2);
        } catch (AMapException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onStart(owner);
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        mAMapNaviView.onResume();
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        mAMapNaviView.onPause();
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        mAMapNaviView.onDestroy();
        mAMapNaviView.onDestroy();
        //since 1.6.0 不再在naviview destroy的时候自动执行AMapNavi.stopNavi();请自行执行
        if (mAMapNavi!=null){
            mAMapNavi.stopNavi();
            mAMapNavi.destroy();
        }

        if (carOverlay != null) {
            carOverlay.destroy();
        }

        if (routeOverLay != null) {
            routeOverLay.removeFromMap();
            routeOverLay.destroy();
        }

        if (mAMapNaviView != null) {
            mAMapNaviView.onDestroy();
        }
    }

}
