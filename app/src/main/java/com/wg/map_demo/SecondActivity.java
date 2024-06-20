package com.wg.map_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.wg.map_demo.base.BaseActivity;
import com.wg.map_demo.data.MapType;
import com.wg.map_demo.fragment.AvpFragment;
import com.wg.map_demo.fragment.SdFragment;

import java.util.HashMap;
import java.util.Map;

public class SecondActivity extends BaseActivity {
    private Map<MapType, Fragment> mMapDataPage;

    private Button avp_btn,sd_btn,seconed_btn;

    @Override
    protected void createPages() {
        mMapDataPage = new HashMap<MapType, Fragment>();
        AvpFragment avpFragment = new AvpFragment();
        SdFragment sdFragment = new SdFragment();
        mMapDataPage.put(MapType.AVP,avpFragment);
        mMapDataPage.put(MapType.SD,sdFragment);
    }

    @Override
    protected void mapTapeChange(MapType mapType) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.map_fragment,mMapDataPage.get(mapType));
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }
    private void initView(){
        avp_btn = findViewById(R.id.avp);
        sd_btn = findViewById(R.id.sd);
        seconed_btn = findViewById(R.id.seconed_btn);

        avp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationInstance.getInstance().getMapTypeViewModel().getMapTypeMutableLiveData().postValue(MapType.AVP);
            }
        });
        sd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationInstance.getInstance().getMapTypeViewModel().getMapTypeMutableLiveData().postValue(MapType.SD);
            }
        });

        seconed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecondActivity.this, FirstActivity.class));
            }
        });
    }
}