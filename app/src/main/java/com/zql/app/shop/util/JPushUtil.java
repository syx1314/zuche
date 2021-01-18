package com.zql.app.shop.util;

import android.content.Context;
import android.os.Handler;

import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.LogMe;

import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * Jpush工具类
 * Created by huangzhe on 2017/2/7.
 */

public class JPushUtil {

   private Context context;
   private String alias;
   private Set<String> tag;
      TagAliasCallback mAliasCallback = new TagAliasCallback() {
        @Override
        public void gotResult(int code, String alias, Set<String> tags) {
            String logs ;
            switch (code) {
                case 0:
                    logs = "Set tag and alias success";
                    LogMe.e( logs);
                    // 建议这里往 SharePreference 里写一个成功设置的状态。成功设置一次后，以后不必再次设置了。
                    break;
                case 6002:
                    logs = "Failed to set alias and tags due to timeout. Try again after 60s.";
                    LogMe.e( logs);
                    // 延迟 60 秒来调用 Handler 设置别名
                    mHandler.sendMessageDelayed(mHandler.obtainMessage(MSG_SET_ALIAS, alias), 1000 * 60);
                    break;
                default:
                    logs = "Failed with errorCode = " + code;
                    LogMe.e( logs);
            }
        }
    };
    private static final int MSG_SET_ALIAS = 1001;
    private static final int MSG_DEl_ALIAS = 1002;
    private    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SET_ALIAS:
                    LogMe.e( "Set alias in handler.");
                    // 调用 JPush 接口来设置别名。
                    if (JPushInterface.isPushStopped(context)) {
                        JPushInterface.resumePush(context);
                    }
                    // 调用 JPush 接口来设置别名。
                    JPushInterface.setAliasAndTags(context,
                            alias,
                            tag,
                            mAliasCallback);
                    break;
                default:
                    JPushInterface.stopPush(context);
                    LogMe.e( "Unhandled msg - " + msg.what);
            }
        }
    };
    public void setJPush(Context context, String alias, Set<String> tag){
    this.context=context;
    this.alias=alias;
    this.tag=tag;
        // 调用 Handler 来异步设置别名
        if(Validator.isNotEmpty(alias)) {
            mHandler.sendMessage(mHandler.obtainMessage(MSG_SET_ALIAS, alias));
        }else {
            mHandler.sendMessage(mHandler.obtainMessage(0000, alias));
        }

    }
}
