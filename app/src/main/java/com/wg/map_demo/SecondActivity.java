package com.wg.map_demo;

import android.os.Bundle;

import com.wg.map_demo.base.BaseActivity;
import com.wg.map_demo.data.MapType;

public class SecondActivity extends BaseActivity {
    @Override
    protected void createPages() {

    }

    @Override
    protected void mapTapeChange(MapType mapType) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

}