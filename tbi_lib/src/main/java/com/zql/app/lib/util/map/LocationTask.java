/**
 * Project Name:Android_Car_Example
 * File Name:LocationTask.java
 * Package Name:com.amap.api.car.example
 * Date:2015年4月3日上午9:27:45
 */

package com.zql.app.lib.util.map;

import android.content.Context;
import android.text.TextUtils;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.core.IBaseConst;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.util.sys.PrefManager;


/**
 * ClassName:LocationTask <br/>
 * Function: 简单封装了定位请求，可以进行单次定位和多次定位，注意的是在app结束或定位结束时注意销毁定位 <br/>
 * Date: 2015年4月3日 上午9:27:45 <br/>
 *
 * @author yiyi.qi
 * @see
 * @since JDK 1.6
 */
public class LocationTask implements AMapLocationListener {

    private AMapLocationClient mLocationClient;//定位客户端

    private LocationTask mLocationTask;//单例

    private Context mContext;

    private CommonCallback<PositionEntity> onLocationGetListener;//回调接口

    /**
     * 初始化参数
     *
     * @param context
     * @param onLocationGetListener
     */
    public LocationTask(Context context, CommonCallback<PositionEntity> onLocationGetListener) {
        mLocationClient = new AMapLocationClient(context);
        mLocationClient.setLocationListener(this);
        mContext = context;
        this.onLocationGetListener = onLocationGetListener;
    }


    /**
     * 开启单次定位
     */
    public void startSingleLocate() {
        try {
            AMapLocationClientOption option = new AMapLocationClientOption();
            option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            option.setOnceLocation(true);
            option.setOnceLocationLatest(true);//返回最近3秒内的精度最高的结果
            mLocationClient.setLocationOption(option);
            mLocationClient.startLocation();
        } catch (SecurityException e) {
            LogMe.d("SecurityException:" + e.toString());
        }
    }

    /**
     * 开启多次定位
     */
    public void startLocate() {

        try {
            AMapLocationClientOption option = new AMapLocationClientOption();
            option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            option.setOnceLocation(false);
            option.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport);
            option.setInterval(8 * 1000);
            mLocationClient.setLocationOption(option);


            mLocationClient.startLocation();
        } catch (SecurityException e) {
            LogMe.d("SecurityException:----------------------------------------------------");
        }
    }

    /**
     * 结束定位，可以跟多次定位配合使用
     */
    public void stopLocate() {
        mLocationClient.stopLocation();

    }

    /**
     * 销毁定位资源
     */
    public void onDestroy() {

        mLocationClient.stopLocation();
        mLocationClient.onDestroy();
        mContext=null;
    }

    /**
     * 退出系统
     */
    public void quitApp() {
        mLocationTask = null;
    }

    /**
     * 定位改变
     *
     * @param amapLocation
     */
    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null && amapLocation.getErrorCode() == 0) {
            PositionEntity entity = new PositionEntity();
            entity.latitue = amapLocation.getLatitude();
            entity.longitude = amapLocation.getLongitude();
            entity.city = amapLocation.getCity();
            if (!TextUtils.isEmpty(amapLocation.getAddress())) {
                entity.address = amapLocation.getAddress();
            }
            //保存临时坐标
            PrefManager.saveString(mContext, IBaseConst.PreManager.LOCATION_LAT, Double.toString(entity.latitue));
            PrefManager.saveString(mContext, IBaseConst.PreManager.LOCATION_LOG, Double.toString(entity.longitude));
            onLocationGetListener.onCallBack(entity);
        }else{
            onLocationGetListener.onCallBack(null);
        }

    }
}
