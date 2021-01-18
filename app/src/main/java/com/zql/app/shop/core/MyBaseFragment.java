package com.zql.app.shop.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.PrefManager;
import com.zql.app.shop.IConst;
import com.zql.app.shop.entity.yiwei.LoginResponse;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019/5/6 0006.
 */

public abstract class MyBaseFragment extends TbiBaseFragment {

    private Unbinder unbinder;
    protected LoginResponse login;

    public abstract int getLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        Gson gson = new Gson();
        String json = PrefManager.getString(ctx, IConst.PreManager.USER_INFO);
        if (Validator.isNotEmpty(json)) {
            login = gson.fromJson(json, LoginResponse.class);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder!=null) {
            unbinder.unbind();
        }
    }
}
