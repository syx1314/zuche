package com.zql.app.shop.entity;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.bind.ContentTypeAdapterFactory;

/**
 * Created by Administrator on 2018/12/10 0010.
 */

public class WeiXinExceptionResponse<T> {
    private int code;//代码
    private String msg;//信息
    @JsonAdapter(ContentTypeAdapterFactory.class)
    T data;//内容可变

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "WeiXinExceptionResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
