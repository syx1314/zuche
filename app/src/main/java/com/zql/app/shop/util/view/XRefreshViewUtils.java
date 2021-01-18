package com.zql.app.shop.util.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.andview.refreshview.XRefreshView;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.util.ListUtil;
import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.shop.adapter.XRefreshviewRecyclerAdapter;
import com.zql.app.shop.core.TbiAppActivity;


import java.util.List;

/**
 * 带刷新的列表基类
 * Created by huangzhe on 2017/7/14.
 */

public class XRefreshViewUtils {
    //region 变量
    private int curPage = 1;//当前第几页
    private int pageCount = 20;//一页多少条数据
    private boolean isRefresh = false;//是否刷新
    private int startPage = 1;//首页

    private XRefreshviewRecyclerAdapter adapter;
    private View emptyView;//空视图
    private RecyclerView recyclerView;//列表
    private XRefreshView xRefreshView;//刷新控件

    private TbiAppActivity ctx;
    private CommonCallback<Object> loadCallback;//加载网络数据

    private PullRefreshListener pullRefreshListener;
    //endregion


    public void setPullRefreshListener(PullRefreshListener pullRefreshListener) {
        this.pullRefreshListener = pullRefreshListener;
    }

    //region 初始化
    public XRefreshViewUtils(int startPage, XRefreshviewRecyclerAdapter adapter, View emptyView, RecyclerView recyclerView, XRefreshView xRefreshView, TbiAppActivity ctx, CommonCallback<Object> loadCallback) {
        this.startPage = startPage;
        this.adapter = adapter;
        this.emptyView = emptyView;
        this.recyclerView = recyclerView;
        this.xRefreshView = xRefreshView;
        this.ctx = ctx;
        this.loadCallback = loadCallback;
        initXRefreshView();
    }

    private void initXRefreshView() {
        if (getAdapter() == null) {
            return;
        }
        getRecyclerView().setAdapter(getAdapter());
        getRecyclerView().setHasFixedSize(true);
        getRecyclerView().setLayoutManager(new LinearLayoutManager(ctx));

        getXRefreshView().setPinnedTime(1000);//设置当下拉刷新完成以后，headerview和footerview被固定的时间
        getXRefreshView().setMoveForHorizontal(true);//处理横向移动与XRefreshView的冲突
        getXRefreshView().setPullLoadEnable(true);//设置是否可以上拉刷新
        getXRefreshView().setAutoLoadMore(true);//滑动到底部自动加载更多
        getXRefreshView().setEmptyView(emptyView);//EmptyViewUtil.getNoOrderView(this.getContext(),c_order_xrefreshview)
        getXRefreshView().enableReleaseToLoadMore(true);
        getXRefreshView().enableRecyclerViewPullUp(true);
        getXRefreshView().enablePullUpWhenLoadCompleted(true);
        //加载自定义头尾
        getAdapter().setCustomLoadMoreView(new XRefreshViewFooterCustom(ctx));

        getXRefreshView().setCustomHeaderView(new XRefreshViewHeaderCustom(ctx));

        getXRefreshView().setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh(boolean isPullDown) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DialogUtil.showProgressByApi(ctx, false);
                        isRefresh = true;
                        if(pullRefreshListener!=null){
                            pullRefreshListener.refresh();
                        }
                        reLoad();
                    }
                }, 1000);
            }

            @Override
            public void onLoadMore(boolean isSilence) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        curPage++;
                        DialogUtil.showProgressByApi(ctx, false);
                        loadData();
                    }
                }, 1000);
            }
        });
    }
    //endregion

    //region 方法

    /**
     * 重新加载
     */
    public   void reLoad() {

        if (adapter != null) {
            adapter.clear();
        }
        curPage = startPage;
        xRefreshView.setLoadComplete(false);
        DialogUtil.showProgressByApi(ctx, false);
        loadData();

    }

    /**
     * 整理数据
     */
    public void setLoadData(List datas, boolean isNotErr) {
        if (isNotErr) {
//            EmptyViewUtil.setNoWifi(getXRefreshView().getEmptyView(), false);
            if (ListUtil.isNotEmpty(datas)) {
                getAdapter().setDatas(datas);
                if (!isRefresh) {
                    if (datas.size() < pageCount) {
                        getXRefreshView().setLoadComplete(true);
                    } else {
                        getXRefreshView().stopLoadMore();
                    }
//                    getXRefreshView().stopLoadMore();
                } else {
                    getXRefreshView().stopRefresh(true);
                    isRefresh = false;
                }
            } else {
                if (getAdapter().isEmpty()) {
                    getXRefreshView().enableEmptyView(true);
                } else {
                    getXRefreshView().enableEmptyView(false);
                }
                if (!isRefresh) {
                    getXRefreshView().setLoadComplete(true);
                } else {
                    getXRefreshView().stopRefresh(true);
                    isRefresh = false;
                }
            }
        } else {
//            EmptyViewUtil.setNoWifi(getXRefreshView().getEmptyView(), true);
            if (!isRefresh) {
                getXRefreshView().stopLoadMore();
            } else {
                getXRefreshView().stopRefresh(false);
                isRefresh = false;
            }
        }
    }

    /**
     * 调用外界加载数据
     */
    private void loadData() {
        loadCallback.onCallBack(null);
    }
    //endregion

    //region 属性


    public XRefreshviewRecyclerAdapter getAdapter() {
        return adapter;
    }

    public View getEmptyView() {
        return emptyView;
    }

    public void setEmptyView(View emptyView) {
        if (getXRefreshView() != null) {
            this.emptyView = emptyView;
            xRefreshView.setEmptyView(getEmptyView());
//            getXRefreshView().setEmptyView(getEmptyView());
        }

    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public XRefreshView getXRefreshView() {
        return xRefreshView;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public boolean isRefresh() {
        return isRefresh;
    }

    public void setRefresh(boolean refresh) {
        isRefresh = refresh;
    }
    //endregion

    //region 底部滚动

    /**
     * 设置滚动到底部自动隐藏Tab
     */
    public void initScroll(final ViewGroup common_tab) {
        getRecyclerView().addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    int visibleItemCount = getRecyclerView().getLayoutManager().getChildCount();
                    int totalItemCount = getRecyclerView().getLayoutManager().getItemCount();
                    int pastVisiblesItems = ((LinearLayoutManager) getRecyclerView().getLayoutManager()).findFirstVisibleItemPosition();
                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        //底部隐藏
                        setTabIsShow(false, common_tab);
                    }
                } else {
                    if (common_tab.getVisibility() != View.VISIBLE) {
                        common_tab.setVisibility(View.VISIBLE);
                        setTabIsShow(true, common_tab);
                    }
                }
            }
        });
    }

    /**
     * 是否显示Tab
     *
     * @param isShow     true 显示 false 隐藏
     * @param common_tab 底部控件
     */
    private void setTabIsShow(boolean isShow, final ViewGroup common_tab) {
        ObjectAnimator animation = null;
        if (!isShow) {
            animation = ObjectAnimator.ofFloat(common_tab, "translationY", common_tab.getMeasuredHeight());

            animation.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    common_tab.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
        } else {
            animation = ObjectAnimator.ofFloat(common_tab, "translationY", 0);
        }
        animation.setDuration(500);
        animation.start();
    }
    //endregion

    public interface  PullRefreshListener{
        void refresh();
    }
}
