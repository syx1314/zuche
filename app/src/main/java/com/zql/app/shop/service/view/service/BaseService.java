package com.zql.app.shop.service.view.service;


import com.zql.app.lib.util.Validator;

import com.zql.app.lib.util.ui.DialogUtil;

import com.zql.app.shop.TbiApplication;

import com.zql.app.shop.core.IApiReturn;
import com.zql.app.shop.core.TbiAppActivity;

import com.zql.app.shop.event.ApiResult;

import java.util.ArrayList;

import rx.Observable;

/**
 * 窗体Service
 * Created by huangzhe on 2017/12/22.
 */

public abstract class BaseService {
    //region 变量
    private TbiAppActivity tbiAppActivity;
    //endregion

    //region 属性
    protected TbiAppActivity getActivtiy() {
        return tbiAppActivity;
    }

    public void setTbiAppActivity(TbiAppActivity tbiAppActivity) {
        this.tbiAppActivity = tbiAppActivity;
    }

    protected TbiApplication getTbiApplication() {
        return TbiApplication.getInstance();
    }

    /**
     * 得到Service类型
     */
    protected <T> T getApiService(Class<T> serviceClass) {
        return getTbiApplication().getApiService(serviceClass);
    }

    /**
     * 得到Service类型
     */
    protected <T> T getApiExService(Class<T> serviceClass) {
        return getTbiApplication().getApiExtService(serviceClass);
    }
    /**
     * 得到Service类型
     */
    protected <T> T getApiLoadService(Class<T> serviceClass) {
        return getTbiApplication().getApiLoadService(serviceClass);
    }

    /**
     * 得到字符串
     */
    protected String getString(int resId) {
        if (getActivtiy() != null) {
            return getActivtiy().getString(resId);
        }
        return null;
    }


    //endregion

    //region 公用方法

    /**
     * 访问网络
     *
     * @param observable
     * @param apiReturn
     * @param <T>
     */
    protected <T> void Subscribe(final Observable<ApiResult<T>> observable, final IApiReturn<T> apiReturn) {
        Subscribe(observable, true, apiReturn);
    }

    /**
     * 访问网络
     *
     * @param observable
     * @param isCloseProgress 是否关闭弹屏
     * @param apiReturn
     * @param <T>
     */
    protected <T> void Subscribe(final Observable<ApiResult<T>> observable, final boolean isCloseProgress, final IApiReturn<T> apiReturn) {
        if (getActivtiy() != null) {
            getActivtiy().Subscribe(observable, isCloseProgress, apiReturn);
        }
    }

    /**
     * 判断网络请求是否成功
     *
     * @param apiResult
     * @return
     */
    public boolean isSuccess(ApiResult apiResult) {
        return apiResult.getCode() == 100;
    }

    //显示警告信息
    public boolean showWarnDialog(int redId) {
        return showWarnDialog(getString(redId));
    }

    //显示警告信息
    public boolean showWarnDialog(String msg) {
        if (Validator.isNotEmpty(msg)) {
            DialogUtil.showAlert(getActivtiy(), msg, null);
            return true;
        }
        return false;
    }
    //endregion

    //region Override方法
    public void onResume() {

    }

    public void onPause() {

    }

    public void onDestroy() {

    }


}
