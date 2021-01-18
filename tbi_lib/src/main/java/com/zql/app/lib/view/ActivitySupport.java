package com.zql.app.lib.view;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.zql.app.lib.BaseApplication;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.entity.ILoginConfig;
import com.zql.app.lib.util.ui.DialogUtil;

import tjgl.com.android.lib.R;

/**
 * Activity工具类
 * Created by huangzhe on 2016/11/25.
 */

public class ActivitySupport extends AppCompatActivity implements IActivitySupport{
    protected BaseApplication mBaseApplication = null;
    protected NotificationManager notificationManager;//状态栏

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mBaseApplication = (BaseApplication) getApplication();
        validateInternet();
        mBaseApplication.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        mBaseApplication.popupActivity(this);
        super.onDestroy();
    }

    /**
     * 检查是否能连接网络
     * @return
     */
    @Override
    public boolean validateInternet() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        if (manager == null) {
            openWirelessSet();//打开无线网络
            return false;
        } else {
            NetworkInfo[] info = manager.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        openWirelessSet();
        return false;
    }

    /**
     * 检查SD卡
     */
    @Override
    public void checkMemoryCard() {
        if (!Environment.MEDIA_MOUNTED.equals(Environment
                .getExternalStorageState())) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.title_prompt)
                    .setMessage(R.string.check_sd)
                    .setPositiveButton(R.string.menu_settings,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.cancel();
                                    Intent intent = new Intent(
                                            Settings.ACTION_SETTINGS);
                                    startActivity(intent);
                                }
                            })
                    .setNegativeButton(R.string.btn_exit,
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    dialog.cancel();
                                    mBaseApplication.quit(false);
                                }
                            }).create().show();
        }
    }

    /**
     * 打开无线设置
     */
    public void openWirelessSet() {
        DialogUtil.showAlertOkCancel(this, getString(R.string.check_connection), new CommonCallback<Boolean>() {
            @Override
            public void onCallBack(Boolean data) {
                if(data){
                    Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                    startActivity(intent);
                }
            }
        });
    }

    /**
     *
     * 显示toast
     *
     * @param text
     * @param longint
     * @author shimiso
     * @update 2012-6-28 下午3:46:18
     */
    public void showToast(String text, int longint) {
        Toast.makeText(this, text, longint).show();
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    /**
     *
     * 关闭键盘事件
     *
     * @author shimiso
     * @update 2012-7-4 下午2:34:34
     */
    public void closeInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && this.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    /**
     * 打开键盘事件
     */
    public void openInput() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (inputMethodManager != null && this.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus()
                    .getWindowToken(), InputMethodManager.SHOW_FORCED);
        }
    }

    /**
     *
     * 发出Notification的method.
     *
     * @param iconId
     *            图标
     * @param contentTitle
     *            标题
     * @param contentText
     *            你内容
     * @param activity
     * @author shimiso
     * @update 2012-5-14 下午12:01:55
     */
    public void setNotiType(int iconId, String contentTitle,
                            String contentText, Class activity, String from) {
		/*
		 * 创建新的Intent，作为点击Notification留言条时， 会运行的Activity
		 */
        Intent notifyIntent = new Intent(this, activity);
        notifyIntent.putExtra("to", from);
        // notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		/* 创建PendingIntent作为设置递延运行的Activity */
        PendingIntent appIntent = PendingIntent.getActivity(this, 0,
                notifyIntent, 0);

		/* 创建Notication，并设置相关参数 */
        Notification myNoti = new Notification();
        // 点击自动消失
        myNoti.flags = Notification.FLAG_AUTO_CANCEL;
		/* 设置statusbar显示的icon */
        myNoti.icon = iconId;
		/* 设置statusbar显示的文字信息 */
        myNoti.tickerText = contentTitle;
		/* 设置notification发生时同时发出默认声音 */
        myNoti.defaults = Notification.DEFAULT_SOUND;
		/* 设置Notification留言条的参数 */
        //myNoti.setLatestEventInfo(this, contentTitle, contentText, appIntent);
		/* 送出Notification */
        notificationManager.notify(0, myNoti);
    }

    @Override
    public ILoginConfig getLoginConfig() {
        return getBaseApplication().getLoginConfig();
    }


    @Override
    public BaseApplication getBaseApplication() {
        return mBaseApplication;
    }
}
