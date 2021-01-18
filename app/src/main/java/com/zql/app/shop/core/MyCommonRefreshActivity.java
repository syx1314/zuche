package com.zql.app.shop.core;

import android.support.v7.widget.RecyclerView;

import com.andview.refreshview.XRefreshView;
import com.zql.app.shop.R;
import com.zql.app.shop.service.view.service.ExtandsBaseService;

import butterknife.BindView;

/**
 * Created by Administrator on 2019/4/25 0025.
 */

public abstract class MyCommonRefreshActivity<S extends ExtandsBaseService> extends MyBaseRefreshActivity<S> {
    @BindView(R.id.xrefreshview)
    protected XRefreshView xrefreshview;//刷新列表
    @BindView(R.id.rv)
    protected RecyclerView rv;//列表

    @Override
    protected RecyclerView getRecyclerView() {
        return rv;
    }

    @Override
    protected XRefreshView getXRefreshView() {
        return xrefreshview;
    }

    @Override
    protected Integer getStartPage() {
        return 1;
    }


}
