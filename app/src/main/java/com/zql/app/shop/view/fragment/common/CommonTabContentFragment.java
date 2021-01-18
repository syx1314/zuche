package com.zql.app.shop.view.fragment.common;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.andview.refreshview.XRefreshView;
import com.zql.app.shop.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import butterknife.BindView;

/**
 * 订单列表内容
 * Created by huangzhe on 2017/5/22.
 */

public abstract class CommonTabContentFragment extends BaseCommonTabContentFragment {


    @BindView(R.id.xrefreshview)
    protected XRefreshView c_order_xrefreshview;//刷新列表
    @BindView(R.id.rv)
    protected RecyclerView c_order_rv;//列表


    @Override
    protected RecyclerView getRecyclerView() {
        return c_order_rv;
    }

    @Override
    protected XRefreshView getXRefreshView() {
        return c_order_xrefreshview;
    }

    @Override
    protected void initFragment(View view, Bundle savedInstanceState) {

    }

    @Override
    protected Integer getStartPage() {
        return 1;
    }

}
