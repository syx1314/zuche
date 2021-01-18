package com.zql.app.shop.core;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.gyf.immersionbar.ImmersionBar;
import com.zql.app.lib.core.CommonCallback;

import com.zql.app.lib.entity.ILoginConfig;
import com.zql.app.lib.service.impl.RxApiManager;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.util.sys.PrefManager;

import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.lib.view.BaseAppActivity;
import com.zql.app.shop.IConst;
import com.zql.app.shop.R;
import com.zql.app.shop.TbiApplication;



import com.zql.app.shop.event.ApiResult;

import com.zql.app.shop.service.view.service.BaseService;
import com.zql.app.shop.service.view.service.ExtandsBaseService;


import com.umeng.analytics.MobclickAgent;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Locale;

import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 未登录Activity基类
 * Created by huangzhe on 2017/4/13.
 */

public class TbiAppActivity<S extends ExtandsBaseService> extends BaseAppActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setStatusColor();
        LogMe.d("------------------>" + this.getClass().getName());//输出类

        // 统计按钮被点击次数，统计对象：OK按钮


    }

    protected void setStatusColor() {

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            defaultBar().statusBarColor(R.color.white).init();
        } else {
//            View root = getRootView(this);
//            if (root != null) {
//                getRootView(this).setFitsSystemWindows(true);
//            }
//            setStatusBarStyle(tjgl.com.android.lib.R.color.white);
            noStatustextColor();
        }
    }

    protected ImmersionBar noStatustextColor(){
        ImmersionBar immersionBar = ImmersionBar.with(this);
        immersionBar.statusBarColor(R.color.white).statusBarDarkFont(true, 0.2f).fitsSystemWindows(true)
                .navigationBarColor(R.color.black).init();
        return immersionBar;
    }
    protected ImmersionBar defaultBar() {

        ImmersionBar immersionBar = ImmersionBar.with(this);
        immersionBar
                .statusBarDarkFont(true)//状态栏字体是深色，不写默认为亮色
                .statusBarDarkFont(true, 0.2f)
                .autoStatusBarDarkModeEnable(true, 0.2f)
                .navigationBarColor(R.color.black)
                .fitsSystemWindows(true)    //解决状态栏和布局重叠问题，任选其一，默认为false，当为true时一定要指定statusBarColor()，不然状态栏为透明色，还有一些重载方法
//                .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
                .init();  //必须调用方可应用以上所配置的参数
        return immersionBar;
    }

    /**
     * 状态栏字体深色
     *
     * @return
     */
    protected ImmersionBar defaultBar2() {
        ImmersionBar immersionBar = ImmersionBar.with(this);

        immersionBar
                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                .navigationBarColor(R.color.black)
//               .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
                .init();  //必须调用方可应用以上所配置的参数
        return immersionBar;
    }

    /**
     * 不改变状态栏颜色
     *
     * @return
     */
    protected ImmersionBar defaultBar3() {
        ImmersionBar immersionBar = ImmersionBar.with(this);

        immersionBar
                .navigationBarColor(R.color.black)
//                .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
                .init();  //必须调用方可应用以上所配置的参数
        return immersionBar;
    }

    protected static View getRootView(Activity context) {
        return ((ViewGroup) context.findViewById(android.R.id.content)).getChildAt(0);
    }


    /**
     * 得到TbiApplication
     *
     * @return
     */
    public TbiApplication getTbiApplication() {
        return (TbiApplication) getBaseApplication();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroyByApp();
    }

    //销毁窗口
    protected void onDestroyByApp() {
        DialogUtil.dismissProgress();
        if (service != null) {
            service.onDestroy();
        }
        RxApiManager.instance().cancel(this.hashCode());//清除http请求
    }



    public <T> void Subscribe(final Observable<ApiResult<T>> observable, final IApiReturn<T> apiReturn) {
        Subscribe(observable, true, apiReturn);
    }

    /**
     * 订阅操作类
     *
     * @param observable
     * @param isCloseProgress 是否需要关闭弹出
     * @param apiReturn       返回处理
     */
    public <T> void Subscribe(final Observable<ApiResult<T>> observable, final boolean isCloseProgress, final IApiReturn<T> apiReturn) {
        final int tag = this.hashCode();
        RxApiManager.instance().add(tag, observable.hashCode(),
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ApiResult<T>>() {
                                       @Override
                                       public void onCompleted() {
                                           LogMe.e("//退出兑换框");
                                           if (isCloseProgress) {

                                               try {
                                                   DialogUtil.dismissProgress();
                                               } catch (Exception ex) {
                                                   LogMe.e(ex.getMessage(), ex);
                                               }
                                           }
                                           RxApiManager.instance().cancel(tag, observable.hashCode());
                                       }

                                       @Override
                                       public void onError(Throwable e) {
                                           if (isCloseProgress) {
                                               DialogUtil.dismissProgress();
                                           }

                                           LogMe.e(e.getMessage(), e);
                                           //错误处理
                                       }

                                       @Override
                                       public void onNext(ApiResult<T> apiResult) {

                                           LogMe.e("//返回数据" + apiResult.getContent());
                                           apiReturn.run(apiResult);
                                       }
                                   }
                        )
        );
    }








    @Override
    protected void onPause() {
        super.onPause();
        if (service != null) {
            service.onResume();
        }
        MobclickAgent.onPause(this);
    }

    /**
     * 强制首页列表刷新
     */
    protected void winMainReload() {
        PrefManager.saveBoolean(ctx, IConst.PreManager.WIN_MAIN_RELOAD, true);
    }

    //region Service
    private BaseService service;

    public S getTbiService() {
        if (service == null) {
            Type genType = getClass().getGenericSuperclass();
            if (!(genType instanceof ParameterizedType)) {
                LogMe.e("请指定TbiAppActivity的泛型类型");
                return null;
            }
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
            Class<S> entityClass = (Class) params[0];
            try {
                service = entityClass.newInstance();
                service.setTbiAppActivity(this);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return (S) service;
    }
    //endregion


}
