package com.zql.app.shop.core;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.shop.adapter.XRefreshviewRecyclerAdapter;
import com.zql.app.shop.service.view.service.*;
import com.zql.app.shop.util.view.XRefreshViewUtils;

/**
 * Created by yyj on 2018/5/17.
 */

public abstract class BaseRefreshActivity<S extends ExtandsBaseService> extends BaseCommonActivity<S> {
    //region 变量
    private XRefreshViewUtils refreshViewUtils;
    //endregion

    //region 待实现

    /**
     * 得到适配器
     *
     * @return
     */
    protected abstract XRefreshviewRecyclerAdapter getOrderContextViewAdapter();

    /**
     * 得到空视图
     *
     * @return
     */
    protected abstract View getEmptyView();

    /**
     * Recycler
     *
     * @return
     */
    protected abstract RecyclerView getRecyclerView();

    /**
     * XRefreshView
     *
     * @return
     */
    protected abstract XRefreshView getXRefreshView();

    /**
     * 加载网络数据
     */
    protected abstract void loadData();

    /**
     * 初始化
     */
    protected abstract Integer getStartPage();

    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    protected void initView() {

        refreshViewUtils = new XRefreshViewUtils(getStartPage(), getOrderContextViewAdapter(), getEmptyView(), getRecyclerView(), getXRefreshView(), (TbiAppActivity) ctx, new CommonCallback<Object>() {
            @Override
            public void onCallBack(Object data) {
                loadData();
            }
        });
        refreshViewUtils.reLoad();
    }

    /**
     * 列表工具
     *
     * @return
     */
    public XRefreshViewUtils getRefreshViewUtils() {
        return refreshViewUtils;
    }

    /**
     * 重新加载
     */
    public void reLoad() {
        refreshViewUtils.reLoad();
    }
    //endregion

    //region 底部滚动

    /**
     * 设置滚动到底部自动隐藏Tab
     */
    public void initScroll(final ViewGroup common_tab) {
        refreshViewUtils.initScroll(common_tab);
    }
    //endregion

}
