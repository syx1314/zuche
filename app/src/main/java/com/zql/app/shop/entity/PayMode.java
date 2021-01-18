package com.zql.app.shop.entity;

/**
 * 支付方式
 * Created by Administrator on 2018/7/19 0019.
 */

public class PayMode {
    private int resId;
    private String content;

    public PayMode(int resId, String content) {
        this.resId = resId;
        this.content = content;
    }

    public int getResId() {
        return resId;
    }

    public String getContent() {
        return content;
    }
}
