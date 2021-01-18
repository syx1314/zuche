package com.zql.app.lib.util.sys;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

import com.zql.app.lib.view.ActivitySupport;
import com.zql.app.lib.view.BaseAppActivity;
import static android.content.Context.LOCATION_SERVICE;

/**
 * 网络是否可用、网络种类
 * 联网工具类
 * Created by b508a on 2015/12/28.
 */
public class NetUtils {

    /**
     * 检查是否有网络
     * @param context
     * @return
     */
    public static boolean checkNetWorkIsAvailable(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo network = manager.getActiveNetworkInfo();
            return network != null && network.isConnectedOrConnecting();
        }
        return false;
    }

    /**
     * Cmwap网络是否已连接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnectedByCmwap(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE))
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        return networkInfo != null && networkInfo.isConnected()
                && networkInfo.getExtraInfo() != null
                && networkInfo.getExtraInfo().toLowerCase().contains("cmwap");
    }

    /**
     * 连接的是否是2G网络
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnectedBy2G(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE))
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo != null && networkInfo.isConnected()) {
            int subtype = networkInfo.getSubtype();
            // 移动和联通2G
            return subtype == TelephonyManager.NETWORK_TYPE_GPRS
                    || subtype == TelephonyManager.NETWORK_TYPE_EDGE
                    || subtype == TelephonyManager.NETWORK_TYPE_CDMA;
        }
        return false;
    }

    /**
     * 连接的是否是3G网络
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnectedBy3G(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE))
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (networkInfo != null && networkInfo.isConnected()) {
            int subtype = networkInfo.getSubtype();
            // 电信或联通3G
            return subtype == TelephonyManager.NETWORK_TYPE_EVDO_A
                    || subtype == TelephonyManager.NETWORK_TYPE_EVDO_0
                    || subtype == TelephonyManager.NETWORK_TYPE_UMTS
                    || subtype == TelephonyManager.NETWORK_TYPE_HSPA;
        }
        return false;
    }

    /**
     * Wifi网络是否已连接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnectedByWifi(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE))
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return networkInfo != null && networkInfo.isConnected();
    }

    /**
     * 网络是否已连接
     *
     * @param context
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE))
                    .getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 检查GPS权限是否打开
     * @return
     */
    public static boolean hasLocationGPS(BaseAppActivity ctx) {
        LocationManager manager = (LocationManager) ctx.getSystemService(LOCATION_SERVICE);
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    /**
     * 检查网络权限是否打开
     * @return
     */
    public static boolean hasLocationNetWork(BaseAppActivity ctx) {
        LocationManager manager = (LocationManager) ctx.getSystemService(LOCATION_SERVICE);
        return manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    /**
     * 检查权限
     * @return
     */
    public static boolean checkNetWorkApp(Activity ctx) {
        /**
         *  判断应用权限管理中该应用是否打开了允许使用网络的权限
         *  -1: 没有打开  0: 已经打开
         */
        int permission = ActivityCompat.checkSelfPermission(ctx.getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION");
        LogMe.d("App's network using permission is " + permission);

        int gpsPermission = ActivityCompat.checkSelfPermission(ctx.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION");
        LogMe.d("App's GPS using permission is " + gpsPermission);

        return permission == 0 && gpsPermission == 0;
    }


    public static boolean checkNetWorkApp(ActivitySupport ctx) {
        /**
         *  判断应用权限管理中该应用是否打开了允许使用网络的权限
         *  -1: 没有打开  0: 已经打开
         */
        int permission = ActivityCompat.checkSelfPermission(ctx.getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION");
        LogMe.d("App's network using permission is " + permission);

        int gpsPermission = ActivityCompat.checkSelfPermission(ctx.getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION");
        LogMe.d("App's GPS using permission is " + gpsPermission);

        return permission == 0 && gpsPermission == 0;
    }
}

