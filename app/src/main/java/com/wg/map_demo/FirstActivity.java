package com.wg.map_demo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.wg.map_demo.base.BaseActivity;
import com.wg.map_demo.data.DaoSession;
import com.wg.map_demo.data.MapType;
import com.wg.map_demo.data.User;
import com.wg.map_demo.data.UserDao;
import com.wg.map_demo.fragment.AvpFragment;
import com.wg.map_demo.fragment.SdFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstActivity extends BaseActivity {
    private static final String TAG = "FirstActivity";
    private Map<MapType, Fragment> mMapDataPage;

    private Button avp_btn,sd_btn,seconed_btn;

    private int index = 1;

    private MapApplication mapApplication;

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
        setContentView(R.layout.activity_first);
        initView();
        EventBus.getDefault().register(this);
    }
    private void initView(){
        avp_btn = findViewById(R.id.avp);
        sd_btn = findViewById(R.id.sd);
        seconed_btn = findViewById(R.id.seconed_btn);

        avp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationInstance.getInstance().getMapTypeViewModel().getMapTypeMutableLiveData().postValue(MapType.AVP);
                EventBus.getDefault().post(new MessageEvent("切换avp地图"));

                mapApplication = (MapApplication) getApplication();
                DaoSession daoSession = mapApplication.getDaoSession();
                UserDao userDao = daoSession.getUserDao();
                User user = new User();
                user.setId(1L);
                user.setName("田珊珊");
                user.setAge(30);
                userDao.insertOrReplace(user);

                List<User> userList = userDao.loadAll();
                Log.d(TAG, "onClick: ");
            }
        });
        sd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MapTypeEvent event = new MapTypeEvent();
                event.setType(index++);
                EventBus.getDefault().postSticky(event);
                //ApplicationInstance.getInstance().getMapTypeViewModel().getMapTypeMutableLiveData().postValue(MapType.SD);
            }
        });

        seconed_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });
    }

    @Subscribe( threadMode = ThreadMode.MAIN)
    public void onEventEx(MessageEvent messageEvent){
        Log.d(TAG, "onEventEx: " + messageEvent.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}