package com.zql.app.shop.util;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

import com.zql.app.lib.util.sys.PrefManager;
import com.zql.app.shop.IConst;

import java.util.Locale;

/**
 * Created by Administrator on 2019/3/14 0014.
 */

public class LanguageSeting {

    public static void getDefaultLanguage(){

    }
    public static  void setLanguage(Context context,Configuration config){
//        Configuration config = context.getResources().getConfiguration();
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        context. getResources().updateConfiguration(config, dm);
    }

    public static String getCurLanguage(Context context){
        String lg = PrefManager.getString(context, IConst.PreManager.LOCAL_LANGUAGE, Locale.getDefault().getLanguage());
        return lg;
    }
}
