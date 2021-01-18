package com.zql.app.shop.core;

import android.graphics.Color;
import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.MyLocationStyle;
import com.zql.app.shop.R;

import butterknife.BindView;

//带初始化地图的
public abstract class MyMapActivity extends MyActivity {
   /* @BindView(R.id.mapView)
    public MapView mapView;
    public AMap aMap;
    public boolean  isLocation=true;//是否定位
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingMap(mapView, savedInstanceState);
    }
    *//**
     * 加载地图
     *
     * @param mapView            地图控件
     * @param savedInstanceState 保存状态
     *//*
    public void loadingMap(MapView mapView, Bundle savedInstanceState) { //地图
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        aMap = mapView.getMap();
        setUpMap();//加载地图配置信息
    }

    *//**
     * 设置地图属性
     *//*
    private void setUpMap() {
        MyLocationStyle myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        if (isLocation) {
            myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_MAP_ROTATE);//定位一次移动到地图中心点
            myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
            myLocationStyle.strokeColor(Color.argb(0, 0, 0, 0));// 设置圆形的边框颜色
            myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));// 设置圆形的填充颜色
            aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
            aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
        }
        aMap.getUiSettings().setMyLocationButtonEnabled(false);// 设置默认定位按钮是否显示
//        aMap.getUiSettings().setZoomControlsEnabled(false);//不显示缩放
        aMap.getUiSettings().setRotateGesturesEnabled(false);//设置倾斜手势不可用
        aMap.getUiSettings().setScaleControlsEnabled(false);
        aMap.getUiSettings().setZoomControlsEnabled(false);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        if (mapView!=null) {
            mapView.onDestroy();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        if (mapView!=null) {
            mapView.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        if (mapView!=null) {
            mapView.onPause();
        }
    }*/
}
