package com.zql.app.shop.core;

import android.support.v7.widget.RecyclerView;

import com.andview.refreshview.XRefreshView;
import com.zql.app.shop.R;
import com.zql.app.shop.service.view.service.*;

import org.xutils.view.annotation.ViewInject;

/**
 * Created by yyj on 2018/5/17.
 */

public abstract class CommonRefreshActivity<S extends ExtandsBaseService> extends BaseRefreshActivity<S> {


    @ViewInject(R.id.xrefreshview)
    protected XRefreshView c_order_xrefreshview;//刷新列表
    @ViewInject(R.id.rv)
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
    protected Integer getStartPage() {
        return 1;
    }
}
