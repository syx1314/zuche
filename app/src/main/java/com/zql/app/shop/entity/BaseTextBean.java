package com.zql.app.shop.entity;

import com.zql.app.lib.entity.BaseBean;

/**
 * CPCommonTextViewList的基类
 * Created by huangzhe on 2017/4/28.
 */

public abstract class BaseTextBean extends BaseBean {
    public abstract String getText();

    public abstract void setText(String text);
}
