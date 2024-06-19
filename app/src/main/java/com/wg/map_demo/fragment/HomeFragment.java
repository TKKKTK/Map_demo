package com.wg.map_demo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.TextureMapView;
import com.amap.api.navi.NaviSetting;
import com.amap.api.services.core.ServiceSettings;
import com.wg.map_demo.R;
import com.wg.map_demo.base.BaseFragment;
import com.wg.map_demo.mapview.sd.HomeSdlayout;
import com.wg.map_demo.util.ContextUtil;

public class HomeFragment extends BaseFragment {
    private HomeSdlayout homeSdlayout;
     private TextureMapView textureMapView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
//        textureMapView = view.findViewById(R.id.home_sd_map);
//
//        textureMapView.onCreate(savedInstanceState);
//        textureMapView.getMap().getUiSettings().setZoomControlsEnabled(false);
//        textureMapView.getMap().setOnMapLoadedListener(new AMap.OnMapLoadedListener() {
//            @Override
//            public void onMapLoaded() {
//            }
//        });
        homeSdlayout = view.findViewById(R.id.home_sd_layout);
        homeSdlayout.onCreate(savedInstanceState);
        getLifecycle().addObserver(homeSdlayout);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //textureMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        //textureMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //textureMapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //textureMapView.onSaveInstanceState(outState);
    }
}
