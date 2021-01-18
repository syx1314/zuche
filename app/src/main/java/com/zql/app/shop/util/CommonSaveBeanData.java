package com.zql.app.shop.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by Administrator on 2017/5/12.
 */

public class CommonSaveBeanData {

    public static void saveBeanData(Context context, String keyStr, Object object) {

        SharedPreferences sp = context.getSharedPreferences("SP_PEOPLE", Context.MODE_PRIVATE);//创建sp对象,如果有key为"SP_PEOPLE"的sp就取出，否则就创建一个此key的sp对象

        Gson gson = new Gson();
        String jsonStr = gson.toJson(object); //将对象转换成Json
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(keyStr, jsonStr); //存入json串
        editor.commit(); //提交

        //Log.i("main","data ^_^ 您已经保存成功");
    }

    public static void saveBeanData(Context context, String keyStr, String jsonStr) {

        SharedPreferences sp = context.getSharedPreferences("SP_PEOPLE", Context.MODE_PRIVATE);//创建sp对象,如果有key为"SP_PEOPLE"的sp就取出，否则就创建一个此key的sp对象

        SharedPreferences.Editor editor = sp.edit();
        editor.putString(keyStr, jsonStr); //存入json串
        editor.commit(); //提交

        //Log.i("main","data ^_^ 您已经保存成功");
    }

    public static Object getBeanData(Context context, String keyStr, Class clazz) {
        SharedPreferences sp = context.getSharedPreferences("SP_PEOPLE", Activity.MODE_PRIVATE);//创建sp对象,如果有key为"SP_PEOPLE"的sp就取出
        String cObjectJsonStr = sp.getString(keyStr, "");

        if (cObjectJsonStr == null || cObjectJsonStr.trim().equals("")) {
            return null;
        }

        Gson gson = new Gson();
        Object object = gson.fromJson(cObjectJsonStr, clazz); //将json字符串转换成 Object对象

        //Log.i("main","object ^_^ 将cUserJsonStr转换为cUser Bean成功");

        return object;
    }

    public static String getBeanData(Context context, String keyStr) {
        SharedPreferences sp = context.getSharedPreferences("SP_PEOPLE", Activity.MODE_PRIVATE);//创建sp对象,如果有key为"SP_PEOPLE"的sp就取出
        String cObjectJsonStr = sp.getString(keyStr, "");

        if (cObjectJsonStr == null || cObjectJsonStr.trim().equals("")) {
            return null;
        }

        return cObjectJsonStr;
    }

    public static String getBeanDataString(Context context, String keyStr) {
        SharedPreferences sp = context.getSharedPreferences("SP_PEOPLE", Activity.MODE_PRIVATE);//创建sp对象,如果有key为"SP_PEOPLE"的sp就取出
        String cObjectJsonStr = sp.getString(keyStr, "");

        if (cObjectJsonStr == null || cObjectJsonStr.trim().equals("")) {
            return null;
        }

        return cObjectJsonStr;
    }

    //清楚数据
    public static void clearKeyData(Context context, String keyStr) {
        SharedPreferences sp = context.getSharedPreferences("SP_PEOPLE", Activity.MODE_PRIVATE);//创建sp对象,如果有key为"SP_PEOPLE"的sp就取出
        SharedPreferences.Editor edit = sp.edit();
        edit.remove(keyStr);
        edit.commit();

    }

}
