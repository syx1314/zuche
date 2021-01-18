package com.zql.app.shop.service.impl;

import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.service.impl.RxApiManager;
import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.shop.core.IApiReturn;
import com.zql.app.shop.entity.yiwei.MachOrderReponse;
import com.zql.app.shop.entity.yiwei.MachReponse;
import com.zql.app.shop.entity.yiwei.YiViUserCardReponse;
import com.zql.app.shop.event.ApiResult;
import com.zql.app.shop.service.ApiYiweiservice;
import com.zql.app.shop.service.view.service.ExtandsBaseService;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class YiweiServiceImpl extends ExtandsBaseService {


    public void carOrderList(String request, final CommonCallback<ApiResult<String>> callback) {
        Subscribe(getApiExService(ApiYiweiservice.class).carOrderList(request), new IApiReturn<String>() {
            @Override
            public void run(ApiResult<String> apiResult) {
                callback.onCallBack(apiResult);
            }
        });
    }

    public void orderJinZhunList(String uid, String request, final CommonCallback<MachReponse> callback) {

        Observable<MachReponse> observable = getApiExService(ApiYiweiservice.class).carOrderJinzhunList(uid, request);

        final int tag = this.hashCode();
        RxApiManager.instance().add(tag, observable.hashCode(),
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<MachReponse>() {
                            @Override
                            public void onCompleted() {
                                DialogUtil.dismissProgress();
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(MachReponse machOrderReponse) {
                                callback.onCallBack(machOrderReponse);
                            }
                        }));

    }

    public void orderProgress(String uid, String request, final CommonCallback<ApiResult<String>> callback) {
        Subscribe(getApiExService(ApiYiweiservice.class).carOrderPlaningList(uid, request), new IApiReturn<String>() {
            @Override
            public void run(ApiResult<String> apiResult) {
                callback.onCallBack(apiResult);
            }
        });
    }

    public void findUserPhone(String request, final CommonCallback<YiViUserCardReponse> callback) {

        Observable<YiViUserCardReponse> observable = getApiExService(ApiYiweiservice.class).findUserPhone(request);
        final int tag = this.hashCode();
        RxApiManager.instance().add(tag, observable.hashCode(),
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<YiViUserCardReponse>() {
                            @Override
                            public void onCompleted() {
                                DialogUtil.dismissProgress();
                            }

                            @Override
                            public void onError(Throwable e) {
                                DialogUtil.dismissProgress();
                            }

                            @Override
                            public void onNext(YiViUserCardReponse yiViUserCardRequest) {
                                callback.onCallBack(yiViUserCardRequest);
                            }
                        }));

    }
}
