package com.zql.app.shop.view.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.immersionbar.ImmersionBar;
import com.zql.app.shop.R;
import com.zql.app.shop.entity.FilterBean;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogFilterRight extends Dialog {


    @BindView(R.id.et_qidian)
    EditText etQidian;
    @BindView(R.id.et_zundian)
    EditText etZundian;
    @BindView(R.id.et_date)
    EditText etDate;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.tv_reset)
    TextView tvReset;
    @BindView(R.id.lin_root)
    LinearLayout linRoot;
    private Activity activity;
    private String checkItem;
    private OnConfirmListener onConfirmListener;

    public void setOnConfirmListener(OnConfirmListener onConfirmListener) {
        this.onConfirmListener = onConfirmListener;
    }

    public DialogFilterRight(@NonNull Context context) {
        super(context);
        this.activity = (Activity) context;

    }

    public void setFilterBean(FilterBean filterBean) {
        if (filterBean!=null){
            etDate.setText(filterBean.getDate());
            etQidian.setText(filterBean.getStart());
            etZundian.setText(filterBean.getEnd());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_filter_right, null);
        setContentView(view);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        ButterKnife.bind(this, view);
        getWindow().setBackgroundDrawable(new ColorDrawable(0x01000000));
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);

        ImmersionBar.with((Activity) activity, this).statusBarColor(R.color.white).fitsSystemWindows(true)
                .statusBarDarkFont(true)   //状态栏字体是深色，不写默认为亮色
                .navigationBarColor(R.color.black)
                .keyboardEnable(true)  //解决软键盘与底部输入框冲突问题，默认为false，还有一个重载方法，可以指定软键盘mode
                .init();  //必须调用方可应用以上所配置的参数.init();

        setCanceledOnTouchOutside(true);


    }

    @OnClick({R.id.tv_confirm, R.id.tv_reset, R.id.lin_root})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_confirm:
                FilterBean filterBean=new FilterBean();
                filterBean.setDate(etDate.getText()+"");
                filterBean.setStart(etQidian.getText().toString());
                filterBean.setEnd(etZundian.getText().toString());
                if (onConfirmListener!=null){
                    onConfirmListener.confirm(filterBean);
                }
                dismiss();
                break;
            case R.id.tv_reset:
                etDate.setText(null);
                etQidian.setText(null);
                etZundian.setText(null);
                break;
            case R.id.lin_root:
                dismiss();
                break;
        }
    }

    public interface OnConfirmListener {
        void confirm(FilterBean filterBean);
    }


}
