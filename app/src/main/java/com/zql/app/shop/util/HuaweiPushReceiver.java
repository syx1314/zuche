//package com.zql.app.shop.util;
//
//import android.content.Context;
//import android.os.Bundle;
//
//
//import com.zql.app.lib.util.sys.LogMe;
//
///**
// * 华为推送自定义HuaweiPushRevicer类继承PushReceiver，实现PUSH Token和透传消息的接收。
// * Created by Administrator on 2019/9/6 0006.
// */
//public class HuaweiPushReceiver extends PushReceiver {
//
//    @Override
//    public void onToken(Context context, String token, Bundle extras) {
//        super.onToken(context, token, extras);
//        String belongId = extras.getString("belongId");
//        LogMe.e("belongId:" + belongId);
//        LogMe.e("Token:" + token);
//        //开发者自行实现token保存逻辑。
//    }
//
//    @Override
//    public boolean onPushMsg(Context context, byte[] msg, Bundle extras) {
//
//        try {
//            //开发者可以自己解析消息内容，然后做相应的处理
//            String content = new String(msg, "UTF-8");
//            LogMe.e("收到PUSH透传消息,消息内容为:" + content);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return super.onPushMsg(context, msg, extras);
//    }
//}
