package com.zql.app.shop.entity;

/**
 * 通用文本
 * Created by huangzhe on 2017/5/9.
 */

public class CommonTextBean extends BaseTextBean {
    private String text;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
