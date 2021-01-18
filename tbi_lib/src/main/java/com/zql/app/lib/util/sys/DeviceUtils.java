package com.zql.app.lib.util.sys;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;

import com.zql.app.lib.BaseApplication;

/**
 * 获取手机信息工具类<br>
 * 内部已经封装了打印功能,只需要把DEBUG参数改为true即可<br>
 * 如果需要更换tag可以直接更改,默认为KEZHUANG
 *
 * @author KEZHUANG
 */
public class DeviceUtils {

    /**
     * 获取应用程序的IMEI号
     */
    public static String getIMEI(Context context) {
        String imei = null;
        if (context != null) {
            TelephonyManager telecomManager = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);
            imei = telecomManager.getDeviceId();
        }
        return imei;
    }

    /**
     * 获取设备的系统版本号
     */
    public static int getDeviceSDK() {
        int sdk = Build.VERSION.SDK_INT;
        return sdk;
    }

    /**
     * 获取设备的型号
     */
    public static String getDeviceName() {
        String model = Build.MODEL;
        return model;
    }
    /**
     * 获取设备的品牌
     */
    public static String getBrand() {
        String brand = Build.BRAND;
        return brand;
    }
    public static String getUserAgent() {

        String userAgent ="";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

            try {
                userAgent = WebSettings.getDefaultUserAgent(BaseApplication.mContext);
            }catch (Exception e) {
                userAgent = System.getProperty("http.agent");
            }

        }else {
            userAgent = System.getProperty("http.agent");
        }

        StringBuffer sb =new StringBuffer();
        for (int i =0, length = userAgent.length(); i < length; i++) {
            char c = userAgent.charAt(i);
            if (c <='\u001f' || c >='\u007f') {

                sb.append(String.format("\\u%04x", (int) c));

            }else {
                sb.append(c);

            }
        }
        return sb.toString();

    }
    /**
     * 获取应用程序名称
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return Build.MODEL;
    }

    public static String getPhoneVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int[] getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return new int[]{outMetrics.widthPixels, outMetrics.heightPixels};
    }
}
