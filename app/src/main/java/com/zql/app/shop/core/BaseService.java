package com.zql.app.shop.core;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;

import com.zql.app.lib.service.impl.RxApiManager;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.shop.event.ApiResult;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by huangzhe on 2018/1/3.
 */
public abstract class BaseService extends Service {

    public void startServer(Class className) {
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int time = 10 * 1000;
        long triggerAtTime = SystemClock.elapsedRealtime() + time;
        Intent intent1 = new Intent(this, className);
        PendingIntent pi = PendingIntent.getService(this, 0, intent1, 0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            manager.setAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);//Doze模式（睡眠）也能运行
        } else {
            manager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtTime, pi);//保证任务的准时
        }
    }

    /**
     * 订阅操作类
     *
     * @param observable
     * @param apiReturn  返回处理
     */
    public <T> void Subscribe(final Observable<ApiResult<T>> observable, final IApiReturn<T> apiReturn) {
        final int tag = this.hashCode();
        RxApiManager.instance().add(tag, observable.hashCode(),
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ApiResult<T>>() {
                                       @Override
                                       public void onCompleted() {
                                           RxApiManager.instance().cancel(tag, observable.hashCode());
                                       }

                                       @Override
                                       public void onError(Throwable e) {
                                           RxApiManager.instance().cancel(tag);
                                           LogMe.e(e.getMessage(), e);
                                       }

                                       @Override
                                       public void onNext(ApiResult<T> apiResult) {
                                           apiReturn.run(apiResult);
                                       }
                                   }
                        )
        );
    }
}
