package com.zql.app.shop.entity;

import com.zql.app.lib.entity.BaseBean;

/**
 * 版本
 * Created by huangzhe on 2017/5/24.
 */

public class BetaBean extends BaseBean {

    /**
     * title : 6.3.2 beta版本更新说明
     * createtime : 2018-06-03
     * context : 1.数据问题/n/t2.漏洞
     * bug : 1.bug1
     * 2.bug2
     */

    private String title;
    private String createtime;
    private String context;
    private String bug;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getBug() {
        return bug;
    }

    public void setBug(String bug) {
        this.bug = bug;
    }
}
