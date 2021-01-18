package com.zql.app.shop.entity;

import com.zql.app.lib.entity.BaseBean;

/**
 * 意见反馈
 * Created by huangzhe on 2017/5/2.
 */

public class FeedBack extends BaseBean {

    /**
     * id : string
     * contact : string
     * opinion : string
     */

    private String id;
    private String contact;//联系方式
    private String opinion;//意见内容

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}
