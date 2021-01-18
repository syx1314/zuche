package com.zql.app.shop.util.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.andview.refreshview.callback.IHeaderCallBack;
import com.zql.app.shop.R;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;


/**
 * XRefreshViewHeader自定义头
 * Created by huangzhe on 2017/6/8.
 */

public class XRefreshViewHeaderCustom extends LinearLayout implements IHeaderCallBack {


    private GifImageView gifImageView;

//    private TextView headerHint;


    public XRefreshViewHeaderCustom(Context context) {
        super(context);
        setBackgroundColor(Color.parseColor("#f3f3f3"));
        initView(context);
    }

    public XRefreshViewHeaderCustom(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {

        LayoutInflater.from(context).inflate(R.layout.xrefresh_view_header_customer, this);
        gifImageView = findViewById(R.id.refresh_header_iv);

//        headerHint = (TextView) findViewById(R.id.gif_header_hint);

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
    public void hide() {
        setVisibility(GONE);
    }

    @Override
    public void show() {
        setVisibility(VISIBLE);
    }


    /**
     * 激活
     */
    @Override
    public void onStateNormal() {
//        headerHint.setText(R.string.xrefreshview_header_hint_normal);
        gifImageView.setVisibility(VISIBLE);
    }

    /**
     * 准备
     */
    @Override
    public void onStateReady() {
//        headerHint.setText(R.string.xrefreshview_header_hint_ready);
    }

    /**
     * 显示刷新
     */
    @Override
    public void onStateRefreshing() {
//        headerHint.setText(R.string.xrefreshview_header_hint_refreshing);
//        gifImageView.setVisibility(GONE);
    }

    /**
     * 完成刷新
     *
     * @param success
     */
    @Override
    public void onStateFinish(boolean success) {
//        headerHint.setText(success ? R.string.xrefreshview_header_hint_loaded : R.string.xrefreshview_header_hint_loaded_fail);
        gifImageView.setVisibility(VISIBLE);
    }

    @Override
    public void onHeaderMove(double headerMovePercent, int offsetY, int deltaY) {

    }

    @Override
    public void setRefreshTime(long lastRefreshTime) {

    }

    @Override
    public int getHeaderHeight() {
        return getMeasuredHeight();
    }


}
