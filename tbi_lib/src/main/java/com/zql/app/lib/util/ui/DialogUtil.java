package com.zql.app.lib.util.ui;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.core.CommonOutCallBack;
import com.zql.app.lib.entity.CustomData;
import com.zql.app.lib.service.impl.RxApiManager;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.DeviceUtils;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.view.BaseAppActivity;
import com.zql.app.lib.view.widget.CreateBitmap;
import com.zql.app.lib.view.widget.CustomProgressDialog;

import java.io.File;
import java.io.IOException;
import java.util.List;

import tjgl.com.android.lib.R;

/**
 * 窗口工具类,提供可重用的窗口
 * @author     sszvip@qq.com
 * @copyright  weibo.com/lostbottle
 */
public class DialogUtil {

    private static CustomProgressDialog progressDialogMy;
    private static Toast mToast;//为了实现疯狂模式下toast延时消失的问题
    private static Toast mToastCust ;



    /**
     * 显示等待条
     * Context == Activity
     */
    public static void showProgress(Context ctx,final boolean isKeyBack) {
        progressDialogMy = CustomProgressDialog.createDialog(ctx);
        if(progressDialogMy.isShowing()){
            return;
        }
        // 添加按键监听
        progressDialogMy.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface arg0, int arg1, KeyEvent arg2) {
                if (isKeyBack) {
                    if (arg1 == KeyEvent.KEYCODE_BACK) {
                        if ((progressDialogMy != null) && progressDialogMy.isShowing()) {
                            progressDialogMy.cancel();
                        }
                    }
                }
                return false;
            }
        });
        try {
            progressDialogMy.show();
        }catch (Exception ex){

        }
    }

    /**
     * 等待条用于访问HTTP，可取消访问
     * @param activity
     * @param isKeyBack
     */
    public static void showProgressByApi(final BaseAppActivity activity, final boolean isKeyBack){
        try {
            if (progressDialogMy == null) {
                progressDialogMy = CustomProgressDialog.createDialog(activity);
            } else {
                if (!progressDialogMy.isShowing()) {
                    progressDialogMy = CustomProgressDialog.createDialog(activity);
                } else {
                    return;
                }
            }
            if (progressDialogMy.isShowing()) {
                return;
            }
            progressDialogMy.setCanceledOnTouchOutside(false);//点区域外quxiao
            // 添加按键监听
            progressDialogMy.setOnKeyListener(new DialogInterface.OnKeyListener() {
                public boolean onKey(DialogInterface arg0, int arg1, KeyEvent arg2) {
                    if (isKeyBack) {
                        if (arg1 == KeyEvent.KEYCODE_BACK) {
                            if ((progressDialogMy != null) && progressDialogMy.isShowing()) {
                                progressDialogMy.cancel();
                                RxApiManager.instance().cancel(activity.hashCode());
                            }
                        }
                    }
                    return false;
                }
            });
            progressDialogMy.show();
        }catch (Exception ex){
            LogMe.e(ex.getMessage(),ex);
        }
    }

    /**
     * 隐藏progress
     */
    public static void dismissProgress() {
        try {
            if (progressDialogMy != null&&progressDialogMy.getContext()!=null) {
                if (progressDialogMy.isShowing()) {
                    progressDialogMy.dismiss();
                }
                progressDialogMy = null;
            }
        }catch (Exception ex){
            LogMe.e(ex.getMessage(),ex);
        }
    }

    /**
     * 显示并自动关闭
     * @param act
     * @param msg
     */
    public static void showToastOnUIThread(final Activity act,final String msg) {
        act.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showToastCust(act,msg);
            }
        });

    }

    /**
     * 此方法可以避免疯狂模式下点击按钮造成的长时间显示toast的问题
     * @param ctx
     * @param msg
     */
    public static void showToastCust(Context ctx, String msg) {
        if(mToast==null){
            mToast = new Toast(ctx);
            mToast.setGravity(Gravity.CENTER, 0, 0);
            mToast.setDuration(Toast.LENGTH_LONG);
            View toastRoot = LayoutInflater.from(ctx).inflate(R.layout.toast_my, null);
            mToast.setView(toastRoot);
        }
        TextView message = mToast.getView().findViewById(R.id.tv_toast);
        message.setText(msg);
        mToast.show();
    }
    /**
     * 此方法可以避免疯狂模式下点击按钮造成的长时间显示toast的问题
     * @param ctx
     * @param msg
     */
    public static void showToastCust(Context ctx, String msg,int layoutId) {
        if(mToast==null){
            mToast = new Toast(ctx);
            mToast.setGravity(Gravity.CENTER, 0, 0);
            mToast.setDuration(Toast.LENGTH_SHORT);
            View toastRoot = LayoutInflater.from(ctx).inflate(layoutId, null);
            mToast.setView(toastRoot);
        }
        TextView message = mToast.getView().findViewById(R.id.tv_toast);
        message.setText(msg);
        mToast.show();
    }
    public static void showToastCust(Context ctx, int resId) {
        if(mToast==null){
            mToast = new Toast(ctx);
            mToast.setGravity(Gravity.CENTER, 0, 0);
            mToast.setDuration(Toast.LENGTH_LONG);
            View toastRoot = LayoutInflater.from(ctx).inflate(R.layout.toast_my, null);
            mToast.setView(toastRoot);
        }
        TextView message = mToast.getView().findViewById(R.id.tv_toast);
        message.setText(resId);
        mToast.show();
    }

    public static void showNoNet(Context ctx) {
        showToastCust(ctx, "网络不可用，请检查网络！");
    }



    public static void showToastNoNet(Context ctx) {
        View toastRoot =  LayoutInflater.from(ctx).inflate(R.layout.toast_my, null);
        TextView message = toastRoot.findViewById(R.id.tv_toast);
        message.setText("网络不可用！");

        Toast toastStart = new Toast(ctx);
        toastStart.setGravity(Gravity.CENTER, 0, 0);
        toastStart.setDuration(Toast.LENGTH_SHORT);
        toastStart.setView(toastRoot);
        toastStart.show();
    }

    public static void showAlertOnUIThread(final Activity ctx,final String msg,final CommonCallback callback) {
        ctx.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showAlert(ctx, msg, callback);
            }
        });
    }
    public static void showAdvertByFile(final Activity ctx, final File file, final CommonCallback<Boolean> callback ){
        final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
//        mAlertDialog.setCancelable(false);

        final View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_advert,null);
        ImageView alert_dialog_iv_advert= view.findViewById(R.id.alert_dialog_iv_advert);
//        ImageView alert_dialog_iv_close=(ImageView)view.findViewById(R.id.alert_dialog_iv_close);
//
//        alert_dialog_iv_close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAlertDialog.dismiss();
//            }
//        });
        alert_dialog_iv_advert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertDialog.dismiss();
            }
        });
        alert_dialog_iv_advert.setImageURI(Uri.fromFile(file));
        try {
            mAlertDialog.show();
        }catch(Exception ex){

        }
        mAlertDialog.getWindow().setContentView(view);
        mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        callback.onCallBack(true);
    }
    /**
     * 显示广告信息
     */
    public static void showAdvert(final Activity ctx,final String src,final File saveFile,final CommonCallback<Boolean> callback) throws IOException {
        final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
//        mAlertDialog.setCancelable(false);

        final View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_advert,null);
        ImageView alert_dialog_iv_advert= view.findViewById(R.id.alert_dialog_iv_advert);
//        ImageView alert_dialog_iv_close=(ImageView)view.findViewById(R.id.alert_dialog_iv_close);
//
//        alert_dialog_iv_close.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mAlertDialog.dismiss();
//            }
//        });
        alert_dialog_iv_advert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertDialog.dismiss();
            }
        });
        CreateBitmap createBitmap=new CreateBitmap(alert_dialog_iv_advert, saveFile,new CommonCallback<Boolean>() {
            @Override
            public void onCallBack(Boolean data) {
                try {
                    if(data==null||!data){//如果图片加载失败不显示控件
                        mAlertDialog.dismiss();
                        callback.onCallBack(false);
                        return;
                    }
                    mAlertDialog.show();
                    mAlertDialog.getWindow().setContentView(view);
                    mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
                    callback.onCallBack(true);
                }catch(Exception ex){
                    callback.onCallBack(false);
                }
            }
        });
        createBitmap.execute(src);


    }

    /**
     * 圆角提示框
     * @param ctx
     * @param msg
     * @param callback
     */
    public static void showAlert(final Activity ctx, final String msg,final CommonCallback<Boolean> callback) {
        if(ctx!=null) {
            showAlert(ctx, ctx.getString(R.string.warn), msg, null, callback);
        }
    }
    /**
     * 途途帮的黄色圆角提示框
     * @param ctx
     * @param msg
     * @param callback
     */
    public static void showAlertTt(final Activity ctx, final String msg,final CommonCallback<Boolean> callback) {
        if(ctx!=null) {
            showAlertTt(ctx, ctx.getString(R.string.warn), msg, null, callback);
        }
    }

    public static void showAlert(final Activity ctx, final String title,final String msg,String oknName,final CommonCallback<Boolean> callback) {
//        if(Validator.isEmpty(msg)){
//            return;
//        }
        final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
        mAlertDialog.setCancelable(false);

        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_warn,null);
        TextView tv = view.findViewById(R.id.alert_id);
        if(title!=null) {


                tv.setText(title);

        }else{
            tv.setVisibility(View.GONE);
        }

        TextView tc = view.findViewById(R.id.alert_context);
        //设置滚动方式
        tc.setMovementMethod(ScrollingMovementMethod.getInstance());
        if(msg!=null) {
            if(msg.contains("br")){

                tc.setText(Html.fromHtml(msg.replace("</br>","<br/>")));
            }else {
                tc.setText(msg);
            }
            tc.setGravity(Gravity.LEFT);
        }else{
            tc.setVisibility(View.GONE);
        }

        Button btn= view.findViewById(R.id.alert_ok);
        if(oknName!=null){
            btn.setText(oknName);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertDialog.dismiss();
                if(callback!=null) {
                    callback.onCallBack(true);
                }
            }
        });
        try {
            mAlertDialog.show();
        }catch (Exception ex){

        }
        mAlertDialog.getWindow().setContentView(view);
        mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        //计算宽为30%
        int width = ctx.getResources().getDisplayMetrics().widthPixels;
        width = width / 100 * 85;
        mAlertDialog.getWindow().setLayout(width, mAlertDialog.getWindow().getAttributes().height);
    }
    //兔兔帮
    public static void showAlertTt(final Activity ctx, final String title,final String msg,String oknName,final CommonCallback<Boolean> callback) {
//        if(Validator.isEmpty(msg)){
//            return;
//        }
        final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
        mAlertDialog.setCancelable(false);

        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_warn,null);
        TextView tv = view.findViewById(R.id.alert_id);
        if(title!=null) {

            tv.setText(title);
        }else{
            tv.setVisibility(View.GONE);
        }

        TextView tc = view.findViewById(R.id.alert_context);
        //设置滚动方式
        tc.setMovementMethod(ScrollingMovementMethod.getInstance());
        if(msg!=null) {
            String  msgStr=msg.replace("<br>","");
            tc.setText(msgStr);
            tc.setGravity(Gravity.LEFT);
        }else{
            tc.setVisibility(View.GONE);
        }

        Button btn= view.findViewById(R.id.alert_ok);
        btn.setTextColor(ctx.getResources().getColor(R.color.tt_orange));
        if(oknName!=null){
            btn.setText(oknName);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAlertDialog.dismiss();
                if(callback!=null) {
                    callback.onCallBack(true);
                }
            }
        });
        try {
            mAlertDialog.show();
        }catch (Exception ex){

        }
        mAlertDialog.getWindow().setContentView(view);
        mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        //计算宽为30%
        int width = ctx.getResources().getDisplayMetrics().widthPixels;
        width = width / 100 * 85;
        mAlertDialog.getWindow().setLayout(width, mAlertDialog.getWindow().getAttributes().height);
    }

    public static void showAlertYesNo(final Activity ctx,final String msg,final CommonCallback callback) {
        final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
        mAlertDialog.setCancelable(false);

        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_ok,null);
        TextView tv= view.findViewById(R.id.alert_id);
        tv.setText(ctx.getString(R.string.warn));

        TextView tc= view.findViewById(R.id.alert_context);
        tc.setText(msg);

        Button yesBtn= view.findViewById(R.id.alert_yes);
        yesBtn.setText(ctx.getString(R.string.btn_yes));
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onCallBack(true);
            }
        });

        Button onBtn= view.findViewById(R.id.alert_no);
        onBtn.setText(ctx.getString(R.string.btn_no));
        onBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                callback.onCallBack(false);
                mAlertDialog.dismiss();
            }
        });
        try {
            mAlertDialog.show();
        }catch (Exception ex){

        }
        mAlertDialog.getWindow().setContentView(view);
        mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
    }
    public static void showAlertYesOrNoOnUIThread(final Activity ctx,final String msg,final CommonCallback callback) {
        ctx.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showAlertYesNo(ctx, msg, callback);
            }
        });
    }
    public static void showAlertOkCancel(final Activity ctx,final String msg,final CommonCallback<Boolean> callback) {
        showAlertCusTitlel(ctx,ctx.getString(R.string.warn),msg,ctx.getString(R.string.btn_ok),ctx.getString(R.string.btn_cancel), callback);
    }

    /**
     * 自定义
     * @param ctx
     * @param msg
     * @param callback
     */
    public static void showAlertCusTitlel(final Activity ctx,final String title,final String msg,
                                          final String okName,final String cancelName,
                                          final CommonCallback<Boolean> callback) {
        final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
        mAlertDialog.setCancelable(false);

        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_ok,null);
        TextView tv= view.findViewById(R.id.alert_id);
        if(Validator.isNotEmpty(title)) {
            tv.setText(title);
        }else{
            tv.setVisibility(View.GONE);
        }

        TextView tc= view.findViewById(R.id.alert_context);
        if(Validator.isNotEmpty(msg)) {
            tc.setText(msg);
        }else{
            tc.setVisibility(View.GONE);
        }

        Button yesBtn= view.findViewById(R.id.alert_yes);

        if (Validator.isNotEmpty(okName)) {
            yesBtn.setText(okName);
        } else {
            yesBtn.setText(ctx.getString(R.string.btn_ok));
        }
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onCallBack(true);
                mAlertDialog.dismiss();
            }
        });

        Button noBtn= view.findViewById(R.id.alert_no);
        if (Validator.isNotEmpty(cancelName)) {
            noBtn.setText(cancelName);
        } else {
            noBtn.setText(ctx.getString(R.string.btn_cancel));
        }

        noBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                callback.onCallBack(false);
                mAlertDialog.dismiss();
            }
        });
        if(!mAlertDialog.isShowing()) {
            try {
                mAlertDialog.show();
            }catch(Exception ex){

            }
            mAlertDialog.getWindow().setContentView(view);
            mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        }
    }

    /**
     * 自定义
     * @param ctx
     * @param msg
     * @param callback
     */
    public static void showAlertCusTitlel(final Activity ctx,final String title,final String msg,
                                          final String okName,int okColor,final String cancelName,int cancelColor,
                                          final CommonCallback<Boolean> callback) {
        final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
        mAlertDialog.setCancelable(false);

        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_ok,null);
        TextView tv= view.findViewById(R.id.alert_id);
        if(Validator.isNotEmpty(title)) {
            tv.setText(title);
        }else{
            tv.setVisibility(View.GONE);
        }

        TextView tc= view.findViewById(R.id.alert_context);
        if(Validator.isNotEmpty(msg)) {
            tc.setText(msg);
        }else{
            tc.setVisibility(View.GONE);
        }

        Button yesBtn= view.findViewById(R.id.alert_yes);

        if (Validator.isNotEmpty(okName)) {
            yesBtn.setText(okName);
        } else {
            yesBtn.setText(ctx.getString(R.string.btn_ok));
        }
        yesBtn.setTextColor(okColor);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onCallBack(true);
                mAlertDialog.dismiss();
            }
        });

        Button noBtn= view.findViewById(R.id.alert_no);
        if (Validator.isNotEmpty(cancelName)) {
            noBtn.setText(cancelName);
        } else {
            noBtn.setText(ctx.getString(R.string.btn_cancel));
        }
        noBtn.setTextColor(cancelColor);
        noBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                callback.onCallBack(false);
                mAlertDialog.dismiss();
            }
        });
        if(!mAlertDialog.isShowing()) {
            try {
                mAlertDialog.show();
            }catch(Exception ex){

            }

            mAlertDialog.getWindow().setContentView(view);
            mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        }
    }
    //按钮背景色
    /**
     * 自定义
     * @param ctx
     * @param msg
     * @param callback
     */
    public static void showAlertCusTitlelW80(final Activity ctx,final String title,final String msg,
                                          final String okName,int okColor,final String cancelName,int cancelColor,
                                          final CommonCallback<Boolean> callback) {
        final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
        mAlertDialog.setCancelable(false);

        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_ok_w,null);
        TextView tv= view.findViewById(R.id.alert_id);
        if(Validator.isNotEmpty(title)) {
            tv.setText(title);
        }else{
            tv.setVisibility(View.GONE);
        }

        TextView tc= view.findViewById(R.id.alert_context);
        if(Validator.isNotEmpty(msg)) {
            tc.setText(msg);
        }else{
            tc.setVisibility(View.GONE);
        }

        Button yesBtn= view.findViewById(R.id.alert_yes);

        if (Validator.isNotEmpty(okName)) {
            yesBtn.setText(okName);
        } else {
            yesBtn.setText(ctx.getString(R.string.btn_ok));
        }
        yesBtn.setTextColor(okColor);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onCallBack(true);
                mAlertDialog.dismiss();
            }
        });

        Button noBtn= view.findViewById(R.id.alert_no);
        if (Validator.isNotEmpty(cancelName)) {
            noBtn.setText(cancelName);
        } else {
            noBtn.setText(ctx.getString(R.string.btn_cancel));
        }
        noBtn.setTextColor(cancelColor);
        noBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                callback.onCallBack(false);
                mAlertDialog.dismiss();
            }
        });
        if(!mAlertDialog.isShowing()) {
            try {
                mAlertDialog.show();
            }catch(Exception ex){

            }
            WindowManager.LayoutParams lp = mAlertDialog.getWindow().getAttributes();
            lp.width = (int) (DeviceUtils.getScreenSize(ctx)[0]*0.8); //设置宽度
            mAlertDialog.getWindow().setAttributes(lp);
            mAlertDialog.getWindow().setContentView(view);
            mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        }
    }
    public static void showAlertCusTitle2(final Activity ctx,final String title,final String msg,
                                          final String okName,int okColor,int okBgColor,final String cancelName,int cancelColor,
                                          final CommonCallback<Boolean> callback) {
        final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
        mAlertDialog.setCancelable(false);

        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_ok,null);
        TextView tv= view.findViewById(R.id.alert_id);
        if(Validator.isNotEmpty(title)) {
            tv.setText(title);
        }else{
            tv.setVisibility(View.GONE);
        }

        TextView tc= view.findViewById(R.id.alert_context);
        if(Validator.isNotEmpty(msg)) {
            tc.setText(msg);
        }else{
            tc.setVisibility(View.GONE);
        }

        Button yesBtn= view.findViewById(R.id.alert_yes);
        yesBtn.setBackgroundColor(okBgColor);
        if (Validator.isNotEmpty(okName)) {
            yesBtn.setText(okName);
        } else {
            yesBtn.setText(ctx.getString(R.string.btn_ok));
        }
        yesBtn.setTextColor(okColor);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onCallBack(true);
                mAlertDialog.dismiss();
            }
        });

        Button noBtn= view.findViewById(R.id.alert_no);



        if (Validator.isNotEmpty(cancelName)) {
            noBtn.setText(cancelName);
        } else {
            noBtn.setText(ctx.getString(R.string.btn_cancel));
        }
        noBtn.setTextColor(cancelColor);
        noBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                callback.onCallBack(false);
                mAlertDialog.dismiss();
            }
        });
        if(!mAlertDialog.isShowing()) {
            try {
                mAlertDialog.show();
            }catch(Exception ex){

            }

            mAlertDialog.getWindow().setContentView(view);
            mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        }
    }

    /**
     * 自定义，从外面进行关闭
     * @param ctx
     * @param msg
     * @param callback
     */
    public static void showAlertCustomer(final Activity ctx, final String msg,
                                          final String okName,final String cancelName,
                                          final CommonOutCallBack<Dialog, Boolean> callback) {
        final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
        mAlertDialog.setCancelable(false);
        View view=ctx.getLayoutInflater().inflate(R.layout.alert_dialog_single, null);

        TextView tc= view.findViewById(R.id.alert_context);
        if(Validator.isNotEmpty(msg)) {
            tc.setText(msg);
        }else{
            tc.setVisibility(View.INVISIBLE);
        }

        Button yesBtn= view.findViewById(R.id.alert_yes);

        if (Validator.isNotEmpty(okName)) {
            yesBtn.setText(okName);
        } else {
            yesBtn.setText(ctx.getString(R.string.btn_ok));
        }
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                callback.onCallBack(mAlertDialog, true);
                mAlertDialog.dismiss();
            }
        });

        Button noBtn= view.findViewById(R.id.alert_no);
        if (Validator.isNotEmpty(cancelName)) {
            noBtn.setText(cancelName);
        } else {
            noBtn.setText(ctx.getString(R.string.btn_cancel));
        }

        noBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                callback.onCallBack(mAlertDialog, false);
                mAlertDialog.dismiss();
            }
        });
        try {
            mAlertDialog.show();
        }catch (Exception ex){

        }
        mAlertDialog.getWindow().setContentView(view);
        mAlertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
    }

    /**
     * 菜单形式
     * @param ctx
     * @param title
     * @param arr
     * @param callback
     */
    public static void showAlertMenu(final Activity ctx,String title,final String[] arr,final CommonCallback<Integer> callback){
        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
        if(Validator.isNotEmpty(title)){
            builder.setTitle(title);
        }
        builder.setCancelable(true);
        /**
         * 第一个参数指定我们要显示的一组下拉单选框的数据集合
         * 第二个参数代表索引，指定默认哪一个单选框被勾选上，0表示默认选中第一个
         * 第三个参数给每一个单选项绑定一个监听器
         */
        builder.setItems(arr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                callback.onCallBack(which);
                dialog.cancel();
            }
        });
        builder.show();
    }

    public static void showAlertMenuCust(final Activity ctx, String title, final String[] itemList, final Integer selectIndex, final CommonCallback<Integer> callback) {
        try{
            final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
            //内容
            ListAdapter mAdapter = new ArrayAdapter(ctx, R.layout.alertdialog_item, itemList);
            LayoutInflater inflater = LayoutInflater.from(ctx);
            View view = inflater.inflate(R.layout.alertdialog, null);
            view.setTranslationX(mAlertDialog.getWindow().getAttributes().width);
            //标题
            TextView titleView = view.findViewById(R.id.tv_title);
            if(Validator.isNotEmpty(title)){
                titleView.setText(title);
                titleView.setVisibility(View.VISIBLE);
            }else{
                titleView.setVisibility(View.GONE);
            }
            //取消
            TextView btn= view.findViewById(R.id.alert_cancel);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAlertDialog.cancel();
                }
            });
            final ListView listview = view.findViewById(android.R.id.list);
            listview.setAdapter(mAdapter);
            if(selectIndex!=null) {
                listview.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView tv = (TextView) listview.getChildAt(selectIndex);
                        tv.setTextColor(Color.parseColor("#fdb12c"));
                    }
                });
            }
            listview.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
                    callback.onCallBack(pos);
                    mAlertDialog.cancel();
                }
            });

            mAlertDialog.getWindow().getAttributes().gravity=Gravity.BOTTOM;
            mAlertDialog.getWindow().setWindowAnimations(R.style.alertTranStyle);
            try {
                mAlertDialog.show();
            }catch(Exception ex){

            }
            mAlertDialog.getWindow().setContentView(view);

            mAlertDialog.getWindow().setLayout(ctx.getResources().getDisplayMetrics().widthPixels,mAlertDialog.getWindow().getAttributes().height);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void showAlertMenuCust(final Activity ctx,String title,final List<String> itemList,final CommonCallback<Integer> callback) {
        try{
            final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
            //内容
            ListAdapter mAdapter = new ArrayAdapter(ctx, R.layout.alertdialog_item, itemList);
            LayoutInflater inflater = LayoutInflater.from(ctx);
            View view = inflater.inflate(R.layout.alertdialog, null);

            TextView titleView = view.findViewById(R.id.tv_title);
            if(Validator.isNotEmpty(title)){
                titleView.setText(title);
                titleView.setVisibility(View.VISIBLE);
            }else{
                titleView.setVisibility(View.GONE);
            }

            ListView listview = view.findViewById(android.R.id.list);
            listview.setAdapter(mAdapter);
            listview.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
                    callback.onCallBack(pos);
                    mAlertDialog.cancel();
                }
            });
            try {
                mAlertDialog.show();
            }catch (Exception ex) {
            }
            mAlertDialog.getWindow().setContentView(view);
            //mAlertDialog.getWindow().setLayout(150, 320);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void showAlertMenuCustBottom(final Activity ctx,String title,final List<String> itemList,final CommonCallback<Integer> callback) {
        try{
            final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
            //内容
            ListAdapter mAdapter = new ArrayAdapter(ctx, R.layout.alertdialog_item, itemList);
            LayoutInflater inflater = LayoutInflater.from(ctx);
            View view = inflater.inflate(R.layout.layout_bottom_sel_menu, null);

            TextView titleView = view.findViewById(R.id.tv_title);
            view.findViewById(R.id.alert_cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAlertDialog.cancel();
                }
            });
            if(Validator.isNotEmpty(title)){
                titleView.setText(title);
                titleView.setVisibility(View.VISIBLE);
            }else{
                titleView.setVisibility(View.GONE);
            }

            ListView listview = view.findViewById(android.R.id.list);
            listview.setAdapter(mAdapter);
            listview.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
                    callback.onCallBack(pos);
                    mAlertDialog.cancel();
                }
            });
            try {
                mAlertDialog.show();
            }catch (Exception ex) {
            }
            mAlertDialog.getWindow().setContentView(view);
            //mAlertDialog.getWindow().setLayout(150, 320);
            mAlertDialog.getWindow().getAttributes().gravity = Gravity.BOTTOM;
            mAlertDialog.getWindow().setWindowAnimations(R.style.alertTranStyle);
            mAlertDialog.show();
            mAlertDialog.getWindow().setContentView(view);

            mAlertDialog.getWindow().setLayout(ctx.getResources().getDisplayMetrics().widthPixels, mAlertDialog.getWindow().getAttributes().height);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
public static void showAlertMenuBottom(final Activity ctx, String title, final List<CustomData> itemList, final CommonCallback<Integer> callback) {
        try{
            final Dialog mAlertDialog = new Dialog(ctx,R.style.MyDialogStyle);
            //内容
            ListAdapter mAdapter = new ArrayAdapter(ctx, R.layout.alertdialog_item, itemList);
            LayoutInflater inflater = LayoutInflater.from(ctx);
            View view = inflater.inflate(R.layout.layout_bottom_sel_menu, null);

            TextView titleView = view.findViewById(R.id.tv_title);
            view.findViewById(R.id.alert_cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAlertDialog.cancel();
                }
            });
            if(Validator.isNotEmpty(title)){
                titleView.setText(title);
                titleView.setVisibility(View.VISIBLE);
            }else{
                titleView.setVisibility(View.GONE);
            }

            ListView listview = view.findViewById(android.R.id.list);
            listview.setAdapter(mAdapter);
            listview.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int pos,long arg3) {
                    callback.onCallBack(pos);
                    mAlertDialog.cancel();
                }
            });
            try {
                mAlertDialog.show();
            }catch (Exception ex) {
            }
            mAlertDialog.getWindow().setContentView(view);
            //mAlertDialog.getWindow().setLayout(150, 320);
            mAlertDialog.getWindow().getAttributes().gravity = Gravity.BOTTOM;
            mAlertDialog.getWindow().setWindowAnimations(R.style.alertTranStyle);
            mAlertDialog.show();
            mAlertDialog.getWindow().setContentView(view);

            mAlertDialog.getWindow().setLayout(ctx.getResources().getDisplayMetrics().widthPixels, mAlertDialog.getWindow().getAttributes().height);

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    //va 引用了 ContextUtil
    /**
     *
     * @param msg
     */
    public static void showToastCust(String msg){
        showToastCust(ContextUtil.getAppContext(),msg);
    }
}