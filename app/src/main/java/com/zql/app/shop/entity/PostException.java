package com.zql.app.shop.entity;

import java.util.List;

/**
 * Created by Administrator on 2019/6/17 0017.
 */

public class PostException {
    private List<String> userIds;
    private String template_id;

    private String appToken;
    private String content;
    private String summary;//消息摘要，显示在微信聊天页面或者模版消息卡片上，限制长度100，可以不传，不传默认截取content前面的内容。
    private String contentType;//内容类型 1表示文字  2表示html(只发送body标签内部的数据即可，不包括body标签) 3表示markdown
    private List<String> uids;


    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }



    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setUids(List<String> uids) {
        this.uids = uids;
    }
}
