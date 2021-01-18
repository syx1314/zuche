/**
 * Project Name:Android_Car_Example
 * File Name:RegeocodeTask.java
 * Package Name:com.amap.api.car.example
 * Date:2015年4月2日下午6:24:53
 */

package com.zql.app.lib.util.map;

import android.content.Context;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.zql.app.lib.core.CommonCallback;

import java.util.List;

/**
 * ClassName:RegeocodeTask <br/>
 * Function: 简单的封装的逆地理编码功能 <br/>
 * Date: 2015年4月2日 下午6:24:53 <br/>
 *
 * @author yiyi.qi
 * @see
 * @since JDK 1.6
 */
public class RegeocodeTask implements OnGeocodeSearchListener {
    private static final float SEARCH_RADIUS = 50;
    private CommonCallback<PositionEntity> mOnLocationGetListener;

    private GeocodeSearch mGeocodeSearch;
    private String locationName;

    public RegeocodeTask(Context context) {
        mGeocodeSearch = new GeocodeSearch(context);
        mGeocodeSearch.setOnGeocodeSearchListener(this);
    }

    public void search(double latitude, double longitude) {
        RegeocodeQuery regecodeQuery = new RegeocodeQuery(new LatLonPoint(
                latitude, longitude), SEARCH_RADIUS, GeocodeSearch.AMAP);
        mGeocodeSearch.getFromLocationAsyn(regecodeQuery);
    }

    public void search(String locationName, String cityName) {
        this.locationName = locationName;
        GeocodeQuery regeocodeQuery = new GeocodeQuery(locationName, cityName);
        mGeocodeSearch.getFromLocationNameAsyn(regeocodeQuery);
    }

    public void setOnLocationGetListener(
            CommonCallback<PositionEntity> onLocationGetListener) {
        mOnLocationGetListener = onLocationGetListener;
    }

    @Override
    public void onGeocodeSearched(GeocodeResult arg0, int arg1) {
        if (arg1 == 1000) {
            if (locationName.equals(arg0.getGeocodeQuery().getLocationName())) {
                List<GeocodeAddress> geocodeAddressList = arg0.getGeocodeAddressList();
                GeocodeAddress geocodeAddress = geocodeAddressList.get(0);
                PositionEntity entity = new PositionEntity();
                entity.city=geocodeAddress.getCity();
                entity.latitue = geocodeAddress.getLatLonPoint().getLatitude();
                entity.longitude = geocodeAddress.getLatLonPoint().getLongitude();
                mOnLocationGetListener.onCallBack(entity);
            }
        }
    }

    @Override
    public void onRegeocodeSearched(RegeocodeResult regeocodeReult,
                                    int resultCode) {
        if (regeocodeReult != null
                && regeocodeReult.getRegeocodeAddress() != null
                && mOnLocationGetListener != null) {
            String address = regeocodeReult.getRegeocodeAddress()
                    .getFormatAddress();
            String city = regeocodeReult.getRegeocodeAddress().getCityCode();

            PositionEntity entity = new PositionEntity();
            entity.address = address;
            entity.city = city;
            mOnLocationGetListener.onCallBack(entity);

        }
    }


}
