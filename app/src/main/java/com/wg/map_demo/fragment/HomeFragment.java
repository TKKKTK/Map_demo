package com.wg.map_demo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.wg.map_demo.ApplicationInstance;
import com.wg.map_demo.FirstActivity;
import com.wg.map_demo.R;
import com.wg.map_demo.base.BaseFragment;
import com.wg.map_demo.data.MapType;
import com.wg.map_demo.mapview.sd.Sdlayout;

public class HomeFragment extends BaseFragment {
    private Sdlayout homeSdlayout;

    private Button entry_btn;

    private View root;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.home_fragment,container,false);
        initView();
        initEvent();
        homeSdlayout.onCreate(savedInstanceState);
        getLifecycle().addObserver(homeSdlayout);
        return root;
    }

    private void initView(){
        homeSdlayout = root.findViewById(R.id.home_sd_layout);
        entry_btn = root.findViewById(R.id.entry_btn);
    }

    private void initEvent(){
        entry_btn.setOnClickListener((View view)-> {
              ApplicationInstance.getInstance().getMapTypeViewModel().getMapTypeMutableLiveData().setValue(MapType.SD);
              startActivity(new Intent(getActivity(), FirstActivity.class));
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        homeSdlayout.onSaveInstanceState(outState);
    }
}
