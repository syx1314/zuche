package com.zql.app.shop.util.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andview.refreshview.XRefreshView;
import com.andview.refreshview.callback.IFooterCallBack;
import com.zql.app.shop.R;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;


/**
 * 自定义列表底部类
 * Created by shikeyue on 2017/7/3.
 */
public class XRefreshViewFooterCustom extends LinearLayout implements IFooterCallBack {


    private GifImageView gifImageView;
    private Context mContext;
    private View mContentView;
    private TextView mHintView;
    private TextView mClickView;
    private boolean showing = true;


    public XRefreshViewFooterCustom(Context context) {
        super(context);
        initView(context);
    }

    public XRefreshViewFooterCustom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }


    private void initView(Context context) {
        mContext = context;
        ViewGroup moreView = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.xrefresh_view_footer_customer, this);
        moreView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        mContentView = moreView.findViewById(R.id.xrefreshview_footer_content_customer);
        gifImageView = moreView.findViewById(R.id.refresh_header_iv);

        mHintView = moreView.findViewById(R.id.xrefreshview_footer_hint_textview);
        mClickView = moreView.findViewById(R.id.xrefreshview_footer_click_textview);

        // 如果加载的是gif动图，第一步需要先将gif动图资源转化为GifDrawable
        // 将gif图资源转化为GifDrawable
        GifDrawable gifDrawable = null;

        try {

            gifDrawable = new GifDrawable(getResources(), R.mipmap.refresh_header);

            // gif1加载一个动态图gif
            gifImageView.setImageDrawable(gifDrawable);

            //gifImageView.setImageResource(R.mipmap.refresh_header);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void callWhenNotAutoLoadMore(final XRefreshView xRefreshView) {
        mClickView.setText(com.andview.refreshview.R.string.xrefreshview_footer_hint_click);
        mClickView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                xRefreshView.notifyLoadMore();
            }
        });
    }

    @Override
    public void onStateReady() {
        mHintView.setVisibility(View.GONE);
        gifImageView.setVisibility(View.GONE);
        mClickView.setText(com.andview.refreshview.R.string.xrefreshview_footer_hint_click);
        mClickView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStateRefreshing() {
        mHintView.setVisibility(View.GONE);
        gifImageView.setVisibility(View.VISIBLE);
        mClickView.setVisibility(View.GONE);
        show(true);
    }

    @Override
    public void onReleaseToLoadMore() {
        mHintView.setVisibility(View.GONE);
        gifImageView.setVisibility(View.GONE);
        mClickView.setText(com.andview.refreshview.R.string.xrefreshview_footer_hint_release);
        mClickView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onStateFinish(boolean hideFooter) {
        if (hideFooter) {
            mHintView.setText(com.andview.refreshview.R.string.xrefreshview_footer_hint_normal);
        } else {
            //处理数据加载失败时ui显示的逻辑，也可以不处理，看自己的需求
            mHintView.setText(com.andview.refreshview.R.string.xrefreshview_footer_hint_fail);
        }
        mHintView.setVisibility(View.VISIBLE);
        gifImageView.setVisibility(View.GONE);
        mClickView.setVisibility(View.GONE);
    }

    @Override
    public void onStateComplete() {
        mHintView.setText(com.andview.refreshview.R.string.xrefreshview_footer_hint_complete);
        mHintView.setVisibility(View.VISIBLE);
        gifImageView.setVisibility(View.GONE);
        mClickView.setVisibility(View.GONE);
    }

    @Override
    public void show(final boolean show) {
        if (show == showing) {
            return;
        }
        showing = show;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mContentView
                .getLayoutParams();
        lp.height = show ? LayoutParams.WRAP_CONTENT : 0;
        mContentView.setLayoutParams(lp);
//        setVisibility(show?VISIBLE:GONE);

    }

    @Override
    public boolean isShowing() {
        return showing;
    }

    @Override
    public int getFooterHeight() {
        return getMeasuredHeight();
    }

}
