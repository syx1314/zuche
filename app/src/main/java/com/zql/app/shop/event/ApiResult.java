package com.zql.app.shop.event;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.internal.bind.ContentTypeAdapterFactory;
import com.zql.app.lib.entity.BaseBean;
import com.zql.app.shop.entity.yiwei.YiweiCar;

import java.util.List;

/**
 * 接收Api返回值
 * Created by huangzhe on 2017/4/13.
 */
public class ApiResult<T>  extends BaseBean{

    private int code;//代码
    private String message;//信息
    @JsonAdapter(ContentTypeAdapterFactory.class)
    T content;//内容可变
    private List<YiweiCar> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public List<YiweiCar> getData() {
        return data;
    }
}
