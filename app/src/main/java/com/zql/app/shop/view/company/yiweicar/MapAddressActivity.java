package com.zql.app.shop.view.company.yiweicar;

import android.content.Intent;
import android.os.Bundle;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.shop.IConst;
import com.zql.app.shop.R;
import com.zql.app.shop.core.MyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MapAddressActivity extends MyActivity implements AMap.OnMapLoadedListener, AMap.OnCameraChangeListener {

    @BindView(R.id.map)
    MapView map;
    private AMap aMap;
    CameraPosition position;
    @Override
    public int getLayout() {
        return R.layout.activity_map_address;
    }


    @Override
    public void initData() {
        super.initData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadingMap(map,savedInstanceState);
    }

    @OnClick(R.id.tv_cofirm_address)
    public void onViewClicked() {
        Intent intent = new Intent();
        intent.putExtra("p",position);
        setResult(999,intent);
        finish();
    }

    /**
     * 加载地图
     *
     * @param mapView            地图控件
     * @param savedInstanceState 保存状态
     */
    public void loadingMap(MapView mapView, Bundle savedInstanceState) { //地图
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        aMap = mapView.getMap();
        setUpMap();//加载地图配置信息
        aMap.setOnCameraChangeListener(this);
        aMap.setOnMapLoadedListener(this);//地图加载完成监听


    }
    /**
     * 设置地图属性
     */
    private void setUpMap() {
        MyLocationStyle myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE_NO_CENTER);//定位一次移动到地图中心点
        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.getUiSettings().setMyLocationButtonEnabled(false);// 设置默认定位按钮是否显示
//        aMap.getUiSettings().setZoomControlsEnabled(false);//不显示缩放
        aMap.getUiSettings().setRotateGesturesEnabled(false);//设置倾斜手势不可用
        aMap.getUiSettings().setScaleControlsEnabled(false);
        aMap.getUiSettings().setZoomControlsEnabled(false);
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        aMap.setMyLocationEnabled(true);//  设置为true表示启动显示定位蓝点 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false

    }

    @Override
    public void onCameraChange(CameraPosition cameraPosition) {


    }

    @Override
    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        position=cameraPosition;

        if (aMap!=null) {
            aMap.clear();
            MarkerOptions position = new MarkerOptions().position(cameraPosition.target);
            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.fromResource(R.mipmap.ic_my_loc_text);
            Marker myPositionMarker = aMap.addMarker(position.icon(bitmapDescriptor).snippet("-2").title("我的位置"));
            myPositionMarker.setInfoWindowEnable(false);
        }
    }

    @Override
    public void onMapLoaded() {
        aMap.moveCamera(CameraUpdateFactory.zoomTo(IConst.BASE.DEFAULT_ZOOM));
    }
}
