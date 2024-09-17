package com.wg.map_demo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wg.map_demo.MessageEvent;
import com.wg.map_demo.R;
import com.wg.map_demo.base.BaseFragment;
import com.wg.map_demo.mapview.avp.AvpLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AvpFragment extends BaseFragment {
    private static final String TAG = "AvpFragment";
    private AvpLayout mAvpLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.avp_fragment,container,false);
        mAvpLayout = view.findViewById(R.id.avp_layout);
        getLifecycle().addObserver(mAvpLayout);
        return view;
    }


    @Subscribe( threadMode = ThreadMode.MAIN)
    public void onEventEx(MessageEvent messageEvent){
        Log.d(TAG, "onEventEx: " + messageEvent.getMessage());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
