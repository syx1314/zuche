package com.zql.app.shop.core;

import android.os.Bundle;

import com.google.gson.Gson;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.PrefManager;
import com.zql.app.shop.IConst;
import com.zql.app.shop.R;
import com.zql.app.shop.entity.yiwei.LoginResponse;
import com.zql.app.shop.service.view.service.*;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/4/25 0025.
 */

public abstract class MyActivity<S extends ExtandsBaseService> extends BaseCommonActivity<S> {

    private Unbinder bind;

    public abstract int getLayout();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
         bind = ButterKnife.bind(this);


        initData();

    }

    public void initData(){}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bind!=null){
            bind.unbind();
        }
    }
}
