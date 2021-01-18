package com.zql.app.shop.view.company.yiweicar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.shop.R;
import com.zql.app.shop.adapter.XRefreshviewRecyclerAdapter;
import com.zql.app.shop.core.MyCommonRefreshActivity;
import com.zql.app.shop.entity.yiwei.OrderRequest;
import com.zql.app.shop.entity.yiwei.YiweiUserPhone;
import com.zql.app.shop.event.ApiResult;
import com.zql.app.shop.service.impl.YiweiServiceImpl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class OrderActivity extends MyCommonRefreshActivity<YiweiServiceImpl> {

    @Override
    protected XRefreshviewRecyclerAdapter getOrderContextViewAdapter() {
        return null;
    }

    @Override
    protected View getEmptyView() {
        return null;
    }

    @Override
    protected void loadData() {
        OrderRequest request=new OrderRequest();
        String json = new Gson().toJson(request, OrderRequest.class);
        //json=json.replace("{","%7b").replace("}","%7d");
        LogMe.e(json);
        String encode = null;
        try {
            encode = URLEncoder.encode(json,"utf-8");
            encode = URLEncoder.encode(json,"utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getLayout() {
        return R.layout.activity_order;
    }


}