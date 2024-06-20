package com.wg.map_demo.mapview.avp;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.DefaultLifecycleObserver;

import com.wg.map_demo.R;
import com.wg.map_demo.base.BaseMapLayout;
import com.wg.map_demo.mapview.sd.SdNaviListener;

public class AvpLayout extends BaseMapLayout implements SdNaviListener {
    public AvpLayout(@NonNull Context context) {
        this(context, null);
    }

    public AvpLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AvpLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.sd_layout,this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {

    }
}
