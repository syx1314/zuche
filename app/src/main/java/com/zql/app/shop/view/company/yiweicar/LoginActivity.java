package com.zql.app.shop.view.company.yiweicar;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.zql.app.lib.service.impl.RxApiManager;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.util.sys.PrefManager;
import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.shop.IConst;
import com.zql.app.shop.R;
import com.zql.app.shop.core.IApiReturn;
import com.zql.app.shop.core.MyActivity;
import com.zql.app.shop.entity.yiwei.LoginResponse;
import com.zql.app.shop.event.ApiResult;
import com.zql.app.shop.service.ApiYiweiservice;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginActivity extends MyActivity {

    @BindView(R.id.tv_phone)
    EditText tvPhone;
    @BindView(R.id.tv_pwd)
    EditText tvPwd;
    @BindView(R.id.tv_login)
    Button btnLogin;

    @Override
    public int getLayout() {
        return R.layout.activity_login;
    }




    @OnClick(R.id.tv_login)
    public void onViewClicked() {
        if (Validator.isEmpty(tvPhone.getText().toString())){
            DialogUtil.showAlert(ctx,tvPhone.getHint().toString(),null);
            return;
        }
        if (Validator.isEmpty(tvPwd.getText().toString())){
            DialogUtil.showAlert(ctx,tvPwd.getHint().toString(),null);
            return;
        }
        //登录
        final Observable<LoginResponse> observable = getBaseApplication().getApiService(ApiYiweiservice.class).loginByPwd(tvPhone.getText().toString(),tvPwd.getText().toString());
        final int tag = this.hashCode();
        RxApiManager.instance().add(tag, observable.hashCode(),
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<LoginResponse>() {
                            @Override
                            public void onCompleted() { }

                            @Override
                            public void onError(Throwable e) { }

                            @Override
                            public void onNext(LoginResponse loginResponse) {
                                if ("1".equals(loginResponse.getStatus())) {
                                    Gson gson = new Gson();
                                    PrefManager.saveString(ctx, IConst.PreManager.USER_INFO, gson.toJson(loginResponse, LoginResponse.class));
                                    DialogUtil.showAlert(ctx,"登录成功",null);
                                    finish();
                                }else {
                                    if (loginResponse!=null){
                                        LoginResponse.LoginRes data = loginResponse.getData();
                                        DialogUtil.showAlert(ctx,data.getMsg(),null);
                                    }
                                }
                                }
                        }));

    }
}
