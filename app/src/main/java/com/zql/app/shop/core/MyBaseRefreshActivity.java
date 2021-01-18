package com.zql.app.shop.core;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.gyf.immersionbar.ImmersionBar;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.shop.adapter.XRefreshviewRecyclerAdapter;
import com.zql.app.shop.service.view.service.ExtandsBaseService;
import com.zql.app.shop.util.view.XRefreshViewUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by yyj on 2018/5/17.
 */

public abstract class MyBaseRefreshActivity<S extends ExtandsBaseService> extends BaseCommonActivity<S> {
    //region 变量
    private XRefreshViewUtils refreshViewUtils;
    private Unbinder bind;
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
    public abstract int getLayout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        bind = ButterKnife.bind(this);
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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(bind!=null){
            bind.unbind();
        }
    }
}
