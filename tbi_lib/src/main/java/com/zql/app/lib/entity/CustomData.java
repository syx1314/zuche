package com.zql.app.lib.entity;

import com.zql.app.lib.util.Validator;

/**
 * 自定义的数据  比如 左半边文字  右边值
 * Created by yyj on 2018/5/9.
 */

public class CustomData {
    private String key;
    private String extra1;
    private Object o;
    private Object extra;

    public CustomData(String key, Object o) {
        this.key = key;
        this.o = o;
    }

    public CustomData(String key, String extra1, Object o) {
        this.key = key;
        this.extra1 = extra1;
        this.o = o;
    }

    public CustomData(String key, String extra1, Object o, Object extra) {
        this.key = key;
        this.extra1 = extra1;
        this.o = o;
        this.extra = extra;
    }

    public CustomData(String key, Object o, Object extra) {
        this.key = key;
        this.o = o;
        this.extra = extra;
    }

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public String getKey() {
        return Validator.isNotEmpty(key)?key:"0";
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getO() {
        return o;
    }

    public void setO(Object o) {
        this.o = o;
    }

    @Override
    public String toString() {
        return o+"";
    }
}
