package com.wg.map_demo.mapview.sd;

import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.model.AMapCalcRouteResult;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviRouteNotifyData;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;

/**
 * 实现此接口只用重写需要的方法即可
 */
public interface SdNaviListener extends AMapNaviListener {
    @Override
    default void onInitNaviFailure() {
    }


    @Override
    default void onInitNaviSuccess() {
    }

    @Override
    default void onStartNavi(int i) {
    }

    @Override
    default void onTrafficStatusUpdate() {
    }

    @Override
    default void onLocationChange(AMapNaviLocation aMapNaviLocation) {
    }

    @Override
    default void onGetNavigationText(int i, String s) {
    }

    @Override
    default void onGetNavigationText(String s) {
    }

    @Override
    default void onEndEmulatorNavi() {
    }

    @Override
    default void onArriveDestination() {
    }

    @Override
    default void onCalculateRouteFailure(int i) {
    }

    @Override
    default void onReCalculateRouteForYaw() {
    }

    @Override
    default void onReCalculateRouteForTrafficJam() {
    }

    @Override
    default void onArrivedWayPoint(int i) {
    }

    @Override
    default void onGpsOpenStatus(boolean b) {
    }

    @Override
    default void onNaviInfoUpdate(NaviInfo naviInfo) {
    }

    @Override
    default void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfos) {
    }

    @Override
    default void updateIntervalCameraInfo(AMapNaviCameraInfo aMapNaviCameraInfo, AMapNaviCameraInfo aMapNaviCameraInfo1, int i) {
    }

    @Override
    default void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfos) {
    }

    @Override
    default void showCross(AMapNaviCross aMapNaviCross) {
    }

    @Override
    default void hideCross() {
    }

    @Override
    default void showModeCross(AMapModelCross aMapModelCross) {
    }

    @Override
    default void hideModeCross() {
    }

    @Override
    default void showLaneInfo(AMapLaneInfo[] aMapLaneInfos, byte[] bytes, byte[] bytes1) {
    }

    @Override
    default void showLaneInfo(AMapLaneInfo aMapLaneInfo) {
    }

    @Override
    default void hideLaneInfo() {
    }

    @Override
    default void onCalculateRouteSuccess(int[] ints) {
    }

    @Override
    default void notifyParallelRoad(int i) {
    }

    @Override
    default void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfos) {
    }

    @Override
    default void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {

    }

    @Override
    default void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {

    }

    @Override
    default void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {

    }

    @Override
    default void onPlayRing(int i) {
    }

    @Override
    default void onCalculateRouteSuccess(AMapCalcRouteResult aMapCalcRouteResult) {
    }

    @Override
    default void onCalculateRouteFailure(AMapCalcRouteResult aMapCalcRouteResult) {
    }

    @Override
    default void onNaviRouteNotify(AMapNaviRouteNotifyData aMapNaviRouteNotifyData) {
    }

    @Override
    default void onGpsSignalWeak(boolean b) {
    }
}
