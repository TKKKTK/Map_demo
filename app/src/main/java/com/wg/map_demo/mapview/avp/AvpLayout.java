package com.wg.map_demo.mapview.avp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.DefaultLifecycleObserver;

import com.wg.map_demo.R;

public class AvpLayout extends FrameLayout implements DefaultLifecycleObserver {
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
}
