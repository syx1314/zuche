package com.zql.app.shop.entity;

import com.zql.app.lib.entity.BaseBean;

/**
 * 列表基类
 * Created by huangzhe on 2017/4/24.
 */

public class BaseList extends BaseBean {
    protected int imgRes;//本地连接
    protected String imgSrc;//连接
    protected String title;//标题
    protected String describe;//描述
    protected String productId;//产品ID

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
