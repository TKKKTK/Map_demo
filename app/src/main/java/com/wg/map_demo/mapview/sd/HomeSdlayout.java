package com.wg.map_demo.mapview.sd;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

import com.amap.api.maps.AMap;
import com.amap.api.maps.TextureMapView;
import com.wg.map_demo.R;

public class HomeSdlayout extends FrameLayout implements DefaultLifecycleObserver,SdNaviListener{
    private TextureMapView textureMapView;

    public HomeSdlayout(@NonNull Context context) {
        this(context, null);
    }

    public HomeSdlayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeSdlayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.home_sd_layout,this);
        textureMapView = findViewById(R.id.home_sd_map);
    }
    public void onCreate(Bundle savedInstanceState){
        textureMapView.onCreate(savedInstanceState);
        final AMap aMap = textureMapView.getMap();
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
}
