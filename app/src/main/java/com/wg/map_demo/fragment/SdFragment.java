package com.wg.map_demo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wg.map_demo.R;
import com.wg.map_demo.base.BaseFragment;
import com.wg.map_demo.mapview.sd.Sdlayout;

public class SdFragment extends BaseFragment {
    private Sdlayout mSdLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sd_fragment,container,false);
        mSdLayout = view.findViewById(R.id.sd_layout);
        mSdLayout.onCreate(savedInstanceState);
        //把Fragment的生命周期观察添加给sdLayout
        getLifecycle().addObserver(mSdLayout);
        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mSdLayout.onSaveInstanceState(outState);
    }
}
