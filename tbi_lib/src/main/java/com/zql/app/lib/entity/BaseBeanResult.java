package com.zql.app.lib.entity;

import java.io.Serializable;

/**
 * 传输类实体返回基类
 * 适用于HTTP请求后，返回状态信息
 * Created by huangzhe on 2016/11/25.
 */

public class BaseBeanResult<T> implements Serializable {
    private T reslut;
    public boolean success ;//是否访问成功
    public String  msg;//返回消息
    public BaseBeanResult() {
    }
    public BaseBeanResult(boolean success, String message) {
        this.success=success;
        this.msg = message;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getReslut() {
        return reslut;
    }

    public void setReslut(T reslut) {
        this.reslut = reslut;
    }
}
