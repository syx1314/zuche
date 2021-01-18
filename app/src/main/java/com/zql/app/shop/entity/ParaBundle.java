package com.zql.app.shop.entity;

import com.zql.app.lib.entity.BaseBean;

import java.util.List;

/**
 * 用于页面之间传参
 * Created by huangzhe on 2017/6/15.
 */

public class ParaBundle<T> extends BaseBean {
    private List<T> datas;

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
