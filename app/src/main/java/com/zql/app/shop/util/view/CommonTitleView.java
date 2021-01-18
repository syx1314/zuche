package com.zql.app.shop.util.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.validator.ValidatorUtil;
import com.zql.app.shop.R;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yyj on 2018/4/18.
 */

public class CommonTitleView extends LinearLayout {
    private Context context;
    @BindView(R.id.iv_left)
    ImageView ivLeft;
    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    private String title;
    private OnClickListener onClickListener;
    private OnLeftClickListener onLeftClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setOnLeftClickListener(OnLeftClickListener onLeftClickListener) {
        this.onLeftClickListener = onLeftClickListener;
    }

    public CommonTitleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.common_title_view);
        boolean rightVisible = typedArray.getBoolean(R.styleable.common_title_view_rightVisible, false);
        String title = typedArray.getString(R.styleable.common_title_view_title);
        String right_title = typedArray.getString(R.styleable.common_title_view_right_title);
        int color = typedArray.getColor(R.styleable.common_title_view_right_title_color, getResources().getColor(R.color.blue));
        String left_title = typedArray.getString(R.styleable.common_title_view_left_title);
        String left_visable=typedArray.getString(R.styleable.common_title_view_left_visable);
        Drawable drawable = typedArray.getDrawable(R.styleable.common_title_view_left_img);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_common_title, this, true);
//        x.view().inject(inflate);
        ButterKnife.bind(inflate);
//        ButterKnife.apply(inflate);
        if (Validator.isNotEmpty(title)) {
            tvTitle.setText(title);
        }
        if (Validator.isNotEmpty(left_title)) {
            ivLeft.setVisibility(GONE);
            tvLeft.setText(left_title);
        }
        if(left_visable!=null&&"false".equals(left_visable)){
            ivLeft.setVisibility(View.GONE);
        }
        if(drawable!=null){
            ivLeft.setImageDrawable(drawable);
            ivLeft.setColorFilter(null);
        }else {
            ivLeft.setColorFilter(context.getResources().getColor(R.color.black));
        }
        if (Validator.isNotEmpty(right_title)) {
            tvRight.setText(right_title);
        }
        if (rightVisible) {
            tvRight.setVisibility(VISIBLE);
            if (color != getResources().getColor(R.color.blue)) {
                tvRight.setTextColor(color);
            }
        } else {
            tvRight.setVisibility(INVISIBLE);
        }
        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onRightClickListener();
                }
            }
        });
    }

    public void setTitle(String title) {
        ValidatorUtil.setTextVal(tvTitle, title);
    }

    public void setVisibleRight(int visibleRight) {
        tvRight.setVisibility(visibleRight);
    }
    public void setVisibleLeft(int visibleRight) {
        ivLeft.setVisibility(visibleRight);
    }

    @OnClick(R.id.iv_left)
    public void ivLeft(View view) {
        if(onLeftClickListener!=null){
            onLeftClickListener.onLeftClickListener();
        }else {
            ((Activity) context).onBackPressed();
        }
    }

    public interface OnClickListener {
        void onRightClickListener();
    }
    public interface OnLeftClickListener {
        void onLeftClickListener();
    }
}
