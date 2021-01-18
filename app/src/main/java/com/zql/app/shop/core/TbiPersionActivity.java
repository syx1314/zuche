package com.zql.app.shop.core;

import android.content.Intent;
import android.os.Bundle;

import com.zql.app.lib.entity.ILoginConfig;
import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.shop.IConst;
import com.zql.app.shop.TbiApplication;


/**
 * 登录后基类
 * Created by huangzhe on 2016/11/26.
 */

public class TbiPersionActivity extends TbiAppActivity {
    protected ILoginConfig mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isLogin();
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);  //全屏
    }

    /**
     * 登录待子类覆盖
     */
    protected void isLogin() {
        mLogin = getLoginConfig();

    }

    /**
     * 当出现登录时是否清空之前的页面
     *
     * @return
     */
    protected boolean isLoginFiish() {
        return true;
    }


    /**
     * 得到TbiApplication
     *
     * @return
     */
    public TbiApplication getTbiApplication() {
        return (TbiApplication) getBaseApplication();
    }

}
