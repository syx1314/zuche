package com.zql.app.shop.util;

import android.app.Activity;
import android.app.Application;

import com.zql.app.lib.util.sys.DeviceUtils;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2019/9/6 0006.
 */

public class PushUtils {

    public static void init(Application context) {
        //判断是不是华为手机
        if (isHuaWei()) {
//            HMSAgent.init(context);
//            JPushInterface.stopPush(context);
        } else {
            // 打开JPUSH
            JPushInterface.setDebugMode(true);
            JPushInterface.init(context);
//            JPushInterface.resumePush(context);
        }
    }

    private static void getHuaWeiToken() {
        if (isHuaWei()) {
//            HMSAgent.Push.getToken(new GetTokenHandler() {
//                @Override
//                public void onResult(int rst) {
//
//                }
//            });
        }

    }

    public static void connectHuaWeiPush(Activity context) {
        if (isHuaWei()) {
//            HMSAgent.connect(context, new ConnectHandler() {
//                @Override
//                public void onConnect(int rst) {
//                    LogMe.e("HMS connect end:" + rst);
//                }
//            });
//            getHuaWeiToken();
        }
    }

    private static boolean isHuaWei() {
        //判断是不是华为手机
        String brand = DeviceUtils.getBrand();
        if (brand != null && "huawei".contains(brand.toLowerCase())) {
            return false;
        }
        return false;
    }
}
