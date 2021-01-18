package com.zql.app.shop.view.fragment.common;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.shop.adapter.XRefreshviewRecyclerAdapter;
import com.zql.app.shop.core.MyBaseFragment;
import com.zql.app.shop.core.TbiBaseFragment;
import com.zql.app.shop.util.view.XRefreshViewUtils;

/**
 * 待刷新功能的列表
 * Created by huangzhe on 2017/6/20.
 */

public abstract class BaseCommonTabContentFragment extends MyBaseFragment {
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
     *
     * @param view
     * @param savedInstanceState
     */
    protected abstract void initFragment(View view, Bundle savedInstanceState);

    protected abstract Integer getStartPage();

    //endregion

    //region 加载数据
    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initFragment(view, savedInstanceState);
        refreshViewUtils = new XRefreshViewUtils(getStartPage(), getOrderContextViewAdapter(), getEmptyView(), getRecyclerView(), getXRefreshView(), getTbiAppActivity(), new CommonCallback<Object>() {
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
