package com.zql.app.lib.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangzhe on 2016/12/15.
 */

public class HashMapUtil {
    public static Map<String,Object> createMap(String key,String value ){
        Map<String,Object> par=new HashMap<String,Object>();
        par.put(key,value);
        return par;
    }

    public static Map<String,Object> createMap(String key,String value,String key1,String value1,String key2,String value2 ){
        Map<String,Object> par=new HashMap<String,Object>();
        par.put(key,value);
        par.put(key1,value1);
        par.put(key2,value2);
        return par;
    }
    public static Map<String,Object> createMap(String key,String value,String key1,String value1,String key2,String value2,String key3,String value3 ){
        Map<String,Object> par=new HashMap<String,Object>();
        par.put(key,value);
        par.put(key1,value1);
        par.put(key2,value2);
        par.put(key3,value3);
        return par;
    }
    public static Map<String,Object> createMap(String key,String value,String key1,String value1,String key2,String value2,String key3,String value3,String key4,String value4  ){
        Map<String,Object> par=new HashMap<String,Object>();
        par.put(key,value);
        par.put(key1,value1);
        par.put(key2,value2);
        par.put(key3,value3);
        par.put(key4,value4);
        return par;
    }
    public static Map<String,Object> createMap(String key,String value,String key1,String value1,String key2,String value2,String key3,String value3,String key4,String value4,String key5,String value5  ){
        Map<String,Object> par=new HashMap<String,Object>();
        par.put(key,value);
        par.put(key1,value1);
        par.put(key2,value2);
        par.put(key3,value3);
        par.put(key4,value4);
        par.put(key5,value5);
        return par;
    }
    public static Map<String,Object> createMap(String key,String value,String key1,String value1){
        Map<String,Object> par=new HashMap<String,Object>();
        par.put(key,value);
        par.put(key1,value1);
        return par;
    }

    public static Map<String,String> createMapStr(String key,String value){
        Map<String,String> par=new HashMap<String,String>();
        par.put(key,value);
        return par;
    }

    public static Map<String,String> createMapStr(String key,String value,String key1,String value1){
        Map<String,String> par=new HashMap<String,String>();
        par.put(key,value);
        par.put(key1,value1);
        return par;
    }

    public static Map<String,String> createMapStr(String key,String value,String key1,String value1, String key2,String value2){
        Map<String,String> par=new HashMap<String,String>();
        par.put(key,value);
        par.put(key1,value1);
        par.put(key2,value2);
        return par;
    }
    public static Map<String,String> createMapStr(String key,String value,String key1,String value1, String key2,String value2,String key3,String value3){
        Map<String,String> par=new HashMap<String,String>();
        par.put(key,value);
        par.put(key1,value1);
        par.put(key2,value2);
        return par;
    }

    /**
     * 添加数据排除空数据
     */
    public static void addValueWhereNull(Map map,String key,Object value){
        if(value!=null){
            map.put(key,value);
        }
    }
}
