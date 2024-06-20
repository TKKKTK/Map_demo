package com.wg.map_demo.base;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.DefaultLifecycleObserver;

public abstract class BaseMapLayout extends FrameLayout implements DefaultLifecycleObserver {
    public BaseMapLayout(@NonNull Context context) {
        this(context,null);
    }

    public BaseMapLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseMapLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    public abstract void onCreate(Bundle savedInstanceState);

    public abstract void onSaveInstanceState(@NonNull Bundle outState);
}
