package com.wg.map_demo;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.wg.map_demo.data.MapTypeViewModel;

/**
 * 用于创建和持有全局作用域的ViewModel
 */
public class ApplicationInstance implements ViewModelStoreOwner {
    private final static ApplicationInstance sInstance = new ApplicationInstance();
    private final ViewModelScope mViewModelScope = new ViewModelScope();
    private ViewModelStore mAppViewModelStore;
    private MapTypeViewModel mMapTypeViewModel;

    private ApplicationInstance() {
    }

    public static ApplicationInstance getInstance() {
        return sInstance;
    }

    public MapTypeViewModel getMapTypeViewModel() {
        if (mMapTypeViewModel == null){
            mMapTypeViewModel = mViewModelScope.getApplicationScopeViewModel(MapTypeViewModel.class);
        }
        return mMapTypeViewModel;
    }

    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        if (mAppViewModelStore == null){
            mAppViewModelStore = new ViewModelStore();
        }
        return mAppViewModelStore;
    }
}
