package com.zql.app.shop.entity;

import com.zql.app.lib.entity.BaseBean;

/**
 * 常见问题
 * Created by huangzhe on 2017/5/2.
 */

public class Faq extends BaseBean {

    private String title;//标题
    private String type;//类型
    private String context;//内容

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
