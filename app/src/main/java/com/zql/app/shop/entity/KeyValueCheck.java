package com.zql.app.shop.entity;

import com.zql.app.lib.entity.BaseBean;

/**
 * 传参使用
 * Created by huangzhe on 2017/4/28.
 */

public class KeyValueCheck<T> extends BaseBean implements Cloneable {
    private String key;//显示字段
    private T value;//值
    private boolean check;//是否选中
    private Object extra;

    public KeyValueCheck(String key, T value) {
        this.key = key;
        this.value = value;
    }

    public KeyValueCheck(String key, T value, boolean check) {
        this.key = key;
        this.value = value;
        this.check = check;
    }

    public KeyValueCheck(String key, T value, boolean check, Object extra) {
        this.key = key;
        this.value = value;
        this.check = check;
        this.extra = extra;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public KeyValueCheck clone() throws CloneNotSupportedException {
        return (KeyValueCheck) super.clone();
    }


    public Object getExtra() {
        return extra;
    }
}
