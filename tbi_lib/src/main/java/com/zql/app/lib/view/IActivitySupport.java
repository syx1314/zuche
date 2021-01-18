package com.zql.app.lib.view;

import com.zql.app.lib.BaseApplication;
import com.zql.app.lib.entity.ILoginConfig;

/**
 * Created by huangzhe on 2016/11/25.
 */

public interface IActivitySupport {
    BaseApplication getBaseApplication();
    boolean validateInternet();
    void checkMemoryCard();

    void showToast(String text, int longint);

    void showToast(String text);

    ILoginConfig getLoginConfig();

    /**
     *
     * 发出Notification的method.
     * @param iconId       图标
     * @param contentTitle 标题
     * @param contentText  你内容
     * @param activity
     *
     */
    void setNotiType(int iconId, String contentTitle,
                     String contentText, Class activity, String from);
}
