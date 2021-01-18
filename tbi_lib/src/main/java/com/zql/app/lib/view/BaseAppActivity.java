package com.zql.app.lib.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.ui.SystemBarTintManager;

import org.xutils.x;

import java.io.Serializable;
import java.util.Map;


/**
 * Activity基类
 * Created by huangzhe on 2016/11/25.
 */

public class BaseAppActivity extends ActivitySupport implements IActivitySupport {
    protected BaseAppActivity ctx = null;

    /**
     * 跳转指定页面
     */
    public void toActivity(Class activityClass) {
        Intent intent = new Intent(ctx, activityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * 不清楚当前页面
     *
     * @param activityClass
     */
    public void toActivityNoClear(Class activityClass) {
        Intent intent = new Intent(ctx, activityClass);
        startActivity(intent);
    }

    /**
     * 跳转到拨号界面
     *
     * @param tel
     */
    public void toTel(String tel) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + tel));
        startActivity(intent);
    }

    /**
     * 跳转传参
     *
     * @param params
     * @param activityClass
     */
    public void toActivity(Map<String, String> params, Class activityClass) {
        Intent intent = new Intent(ctx, activityClass);
        for (String key : params.keySet()) {
            intent.putExtra(key, params.get(key));
        }
        startActivity(intent);
    }

    /**
     * 传实体
     *
     * @param name
     * @param parcelable
     * @param activityClass
     */
    public void toActivity(String name, Serializable parcelable, Class activityClass) {
        Intent intent = new Intent(ctx, activityClass);
        intent.putExtra(name, parcelable);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
//        WindowUtil.hidTitle(this);
        x.view().inject(this);
    }

    /**
     * 添加碎片
     *
     * @param fragment
     * @param tag
     */
    public void addFragment(int fragmentId, Fragment fragment, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(fragmentId, fragment, tag);
        transaction.commit();

    }

    /**
     * 添加碎片
     *
     * @param fragmentId
     * @param fragment
     * @param tag
     * @param isHidden   是否隐藏
     */
    protected void addFragment(int fragmentId, Fragment fragment, String tag, boolean isHidden) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(fragmentId, fragment, tag);
        if (isHidden) {
            transaction.hide(fragment);
        }
        transaction.commit();
    }

    /**
     * 显示Fragment
     *
     * @param tag
     */
    protected void showFragment(String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            transaction.hide(fragment);
        }
        BaseAppFragment baseAppFragment = (BaseAppFragment) getSupportFragmentManager().findFragmentByTag(tag);
        transaction.show(baseAppFragment);
        baseAppFragment.onActivate();//调用激活
        transaction.commit();
    }
    /**
     * 显示Fragment
     *
     * @param tag
     */
    protected void hideFragment(String tag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        BaseAppFragment baseAppFragment = (BaseAppFragment) getSupportFragmentManager().findFragmentByTag(tag);
        transaction.hide(baseAppFragment);
        baseAppFragment.onActivate();//调用激活
        transaction.commit();
    }


    ////////////////////////////////////////////////////////////////////////
    //导航条渐变
    //
    ////////////////////////////////////////////////////////////////////////

    /**
     * 浸染状态栏底色背景，若使用布局的背景图浸染，设置resId为透明色即可
     * 其它情况设置resId为ToolBar(ActionBar)的背景色
     *
     * @param resId 颜色id
     */
    public void setStatusBarStyle(int resId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(resId);//通知栏所需颜色

        tintManager.setNavigationBarTintEnabled(true);
        tintManager.setNavigationBarTintResource(resId);

    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
/////////////////////////////////////////////////////////////////////////
// 退出事件
//
///////////////////////////////////////////////////////////////////////////

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    protected boolean keyExit(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            quitApp();
            return false;
        }
        return true;
    }

    /**
     * 完成
     *
     * @param keyCode
     * @param event
     * @return
     */
    protected boolean onFinish(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 快速退出系统
     */
    public void quitFastApp() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        finish();
        getBaseApplication().quit(false);
    }

    public void quitApp() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            finish();
            getBaseApplication().quit(false);
        }
    }

    Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }

    };
    //region 控件操作

    /**
     * 得到指定对象
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T> T findViewById(View view, int id) {
        return (T) view.findViewById(id);
    }

    /**
     * 得到指定对象并赋值
     *
     * @param view
     * @param id
     * @param text
     * @param <T>
     * @return
     */
    public <T extends TextView> T findViewByIdText(View view, int id, String text) {
        T controller = view.findViewById(id);
        if (Validator.isNotEmpty(text)) {
            controller.setText(text);
        }
        return controller;
    }

    /**
     * 得到指定对象并赋值
     *
     * @param id
     * @param text
     * @param <T>
     * @return
     */
    public <T extends TextView> T findViewByIdText(int id, String text) {
        T controller = findViewById(id);
        if (Validator.isNotEmpty(text)) {
            controller.setText(Html.fromHtml(text));
        }
        return controller;
    }

    /**
     * 得到控件的值
     *
     * @param view
     * @param <T>
     * @return
     */
    public <T extends TextView> String getViewValue(View view, int id) {
        T textView = findViewById(view, id);
        if (textView != null && !TextUtils.isEmpty(textView.getText())) {
            return textView.getText().toString();
        }
        return null;
    }

    //endregion
    boolean isExit;
}