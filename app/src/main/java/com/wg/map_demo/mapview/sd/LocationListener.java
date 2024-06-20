package com.wg.map_demo.mapview.sd;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;

public interface LocationListener extends AMapLocationListener {
    @Override
   default void onLocationChanged(AMapLocation aMapLocation){}
}
