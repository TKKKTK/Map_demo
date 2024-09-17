package com.wg.map_demo.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wg.map_demo.FirstActivity;
import com.wg.map_demo.MapTypeEvent;
import com.wg.map_demo.R;
import com.wg.map_demo.base.BaseFragment;
import com.wg.map_demo.mapview.sd.Sdlayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SdFragment extends BaseFragment {
    private static final String TAG = "SdFragment";
    private Sdlayout mSdLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sd_fragment,container,false);
        mSdLayout = view.findViewById(R.id.sd_layout);
        mSdLayout.onCreate(savedInstanceState);
        //把Fragment的生命周期观察添加给sdLayout
        getLifecycle().addObserver(mSdLayout);
//        if (getActivity() instanceof FirstActivity){
//            mSdLayout.registerEvent();
//        }
        return view;
    }




    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mSdLayout.onSaveInstanceState(outState);
    }
}
