package com.zql.app.shop.view.fragment.common;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.CoordinateConverter;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.core.CommonOutCallBack;
import com.zql.app.lib.util.ListUtil;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.map.LocationTask;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.lib.util.validator.ValidatorUtil;
import com.zql.app.shop.R;

import com.zql.app.shop.core.TbiBaseFragment;
import com.zql.app.shop.entity.KeyValueCheck;


import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/31 0031.
 */
@ContentView(R.layout.fragment_hotel_map)
public class MapHotelFragment extends TbiBaseFragment implements AMap.OnMapLoadedListener {

    @ViewInject(R.id.map)
    MapView map;
    @ViewInject(R.id.tv_address)
    TextView tvAddress;
    @ViewInject(R.id.btn_navigation)
    TextView btn_navigation;
    private AMap aMap;
    private String lat;
    private String lon;
    private String latBaidu;
    private String lonBaidu;
    private String latGd;
    private String lonGd;
    private String address;
    private String hotelName;

    private List<KeyValueCheck> navigationList = new ArrayList<>();
    private LocationTask locationTask;
    private String hotelAddress;


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        map.onCreate(savedInstanceState);


        if (getArguments() != null) {
            Bundle bundle = getArguments();
            lat = bundle.getString("lat");
            lon = bundle.getString("lon");
            address = bundle.getString("address");
            ValidatorUtil.setTextVal(tvAddress, address);
            hotelName = bundle.getString("name");
        }

        LogMe.e("经纬度---" + lat + "---" + lon);
        if (Validator.isEmpty(lat) || Validator.isEmpty(lon)) {
            btn_navigation.setVisibility(View.GONE);
        }
        setUpMap();
        if(savedInstanceState!=null){
            this.latBaidu=savedInstanceState.getString("latitudeBaidu");
            this.lonBaidu=savedInstanceState.getString("longitudeBaidu");
            lat = savedInstanceState.getString("latitudeGoogle");
            lon = savedInstanceState.getString("longitudeGoogle");
            this.hotelName = savedInstanceState.getString("hotelName");
            this.hotelAddress = savedInstanceState.getString("hotelAddress");
            setData(latBaidu,latBaidu,lat,lon,hotelAddress,hotelName);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        map.onSaveInstanceState(outState);
        outState.putString("latitudeBaidu",latBaidu);
        outState.putString("longitudeBaidu",lonBaidu);
        outState.putString("latitudeGoogle",latBaidu);
        outState.putString("longitudeGoogle",lonBaidu);
        outState.putString("hotelName",hotelName);
        outState.putString("hotelAddress",hotelAddress);
    }



    public void setData(String latitudeBaidu, String longitudeBaidu,String latitudeGoogle, String longitudeGoogle, String hotelAddress, String hotelName) {
//    if(getArguments()!=null) {
//        Bundle bundle = getArguments();
//        lat = bundle.getString("lat");
//        lon = bundle.getString("lon");
//        address = bundle.getString("address");
//        ValidatorUtil.setTextVal(tvAddress,address);
//        this.hotelName = bundle.getString("name");
//    }
        this.latBaidu=latitudeBaidu;
        this.lonBaidu=longitudeBaidu;
        lat = latitudeGoogle;
        lon = longitudeGoogle;
        this.hotelName = hotelName;
        this.hotelAddress=hotelAddress;

        ValidatorUtil.setTextVal(tvAddress, hotelAddress);
        LogMe.e("经纬度---" + lat + "---" + lon);
        if (Validator.isEmpty(lat) || Validator.isEmpty(lon)) {
            btn_navigation.setVisibility(View.GONE);
        }else {
            btn_navigation.setVisibility(View.VISIBLE);
        }
        //地图加载完成\
        if (Validator.isNotEmpty(lat) && Validator.isNotEmpty(lon)) {
            aMap.moveCamera(CameraUpdateFactory.zoomTo(15));
//            LatLng latLng = convert(lat, lon, CoordinateConverter.CoordType.GOOGLE);
            latGd=lat+"";
            lonGd=lon+"";
//            addMarkerToMap(latLng, null, address, R.mipmap.ic_hotel_sel, true);
            aMap.moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(Double.valueOf(lat),Double.valueOf(lon))));
        }
    }

    /**
     * 设置地图属性
     */
    private void setUpMap() {
        aMap = map.getMap();
        MyLocationStyle myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE);//定位一次移动到地图中心点
//        myLocationStyle.interval(2000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
//        aMap.getUiSettings().setMyLocationButtonEnabled(true);// 设置默认定位按钮是否显示
//        aMap.getUiSettings().setLogoPosition(AMapOptions.LOGO_POSITION_BOTTOM_LEFT);
        aMap.getUiSettings().setZoomControlsEnabled(false);//不显示缩放
        aMap.getUiSettings().setRotateGesturesEnabled(false);//设置倾斜手势不可用
//        aMap.setMyLocationEnabled(true);//  设置为true表示启动显示定位蓝点 设置为true表示显示定位层并可触发定位，false表示隐藏定位层并不可触发定位，默认是false
        aMap.setOnMapLoadedListener(this);//地图加载完成监听
//        aMap.setOnCameraChangeListener(this);

    }




    @Override
    public void onMapLoaded() {

    }

    //经纬度坐标系转化
    private LatLng convert(String lat, String lon, CoordinateConverter.CoordType coordType) {
        LatLng latLng = new LatLng(Double.valueOf(lat), Double.valueOf(lon));
        CoordinateConverter converter = new CoordinateConverter(ctx);
        // CoordType.GPS 待转换坐标类型
        converter.from(coordType);
        // sourceLatLng待转换坐标点 LatLng类型
        converter.coord(latLng);
        // 执行转换操作
        LatLng latLng1 = converter.convert();
        return latLng1;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Event(R.id.btn_navigation)
    private void lookMap(View view) {

    }


    private void addMarkerToMap(LatLng latLng, String title, String snippet, int resid, boolean isShowInfo) {
        Marker marker = aMap.addMarker(new MarkerOptions().anchor(0.5f, 0.5f)
                .position(latLng)
                .title(title)
                .snippet(snippet)
        );
        if (resid > 0) {
            marker.setIcon(BitmapDescriptorFactory.fromResource(resid));
//            marker.setIcon(null);
        }


    }

    /***
     * 是否安装腾讯地图
     * @return
     */
    public boolean isHaveTencentMap() {
        try {
            if (!new File("/data/data/" + "com.tencent.map").exists()) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }





    //启动百度
    public void openBaidu(String lat, String lon) {
        //现在返回的就是百度坐标
        Intent intent = null;
        try {
            intent = Intent.getIntent("intent://map/direction?" +
                    //"origin=latlng:"+"34.264642646862,108.95108518068&" +   //起点  此处不传值默认选择当前位置
                    "destination=latlng:" + lat + "," + lon + "|name:我的目的地" +        //终点
                    "&mode=driving&" +          //导航路线方式
                    "region=北京" +           //
                    "&src=商旅家#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
            startActivity(intent); //启动调用
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //启动高德
    public void openGd(String lat, String lon) {
        LatLng convert = convert(lat, lon, CoordinateConverter.CoordType.BAIDU);
        Intent intent = null;
        try {
            intent = Intent.getIntent("androidamap://navi?sourceApplication=商旅家&poiname=我的目的地&lat=" + convert.latitude + "&lon=" + convert.longitude + "&dev=0");
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    private void toMap(String lat, String lon, String hotelName) {
        try {
            Uri mUri = Uri.parse("geo:" + lat + ",-" + lon + "?q=" + hotelName);
//            Uri mUri = Uri.parse(("geo:q=" + hotelName).trim());
            Intent mIntent = new Intent(Intent.ACTION_VIEW, mUri);
            startActivity(mIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
