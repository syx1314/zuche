package com.zql.app.shop.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by yyj on 2018/7/3.
 */

public class IntentUtil {
    public static final String OPEN_ACTIVITY_KEY = "open_activity";//intent跳转传递传输key
    public static final String OPEN_ACTIVITY_KEY_SERIALIZABLE = "open_activity_serializable";//intent跳转传递传输key
    public static final String OPEN_ACTIVITY_KEY_LIST = "open_activity_list";//intent跳转传递传输key
    private static IntentUtil manager;
    private static Intent intent;

    private IntentUtil() {

    }

    public static IntentUtil get() {
        if (manager == null) {
            synchronized (IntentUtil.class) {
                if (manager == null) {
                    manager = new IntentUtil();
                }
            }
        }
        intent = new Intent();
        return manager;
    }

    /**
     * 获取上一个界面传递过来的参数
     *
     * @param activity this
     * @param <T>      泛型
     * @return
     */
    public <T> T getParcelableExtra(Activity activity) {
        Parcelable parcelable = activity.getIntent().getParcelableExtra(OPEN_ACTIVITY_KEY);
        activity = null;
        return (T) parcelable;
    }
    public <T> T getParcelableArrarListExtra(Activity activity) {
        ArrayList<Parcelable> parcelableArrayListExtra = activity.getIntent().getParcelableArrayListExtra(OPEN_ACTIVITY_KEY_LIST);
        activity = null;
        return (T) parcelableArrayListExtra;
    }
    public <T> T getSerializableExtra(Activity activity) {
        Serializable serializable = activity.getIntent().getSerializableExtra(OPEN_ACTIVITY_KEY_SERIALIZABLE);
        activity = null;
        return (T) serializable;
    }

    /**
     * 启动一个Activity
     *
     * @param _this
     * @param _class
     */
    public void goActivity(Context _this, Class<? extends Activity> _class) {
        intent.setClass(_this, _class);
        _this.startActivity(intent);
        _this = null;
    }

    /**
     * 启动activity后kill前一个
     *
     * @param _this
     * @param _class
     */
    public void goActivityKill(Context _this, Class<? extends Activity> _class) {
        intent.setClass(_this, _class);
        _this.startActivity(intent);
        ((Activity) _this).finish();
        _this = null;
    }

    /**
     * 回调跳转
     *
     * @param _this
     * @param _class
     * @param requestCode
     */
    public void goActivityResult(Activity _this, Class<? extends Activity> _class, int requestCode) {
        intent.setClass(_this, _class);
        _this.startActivityForResult(intent, requestCode);
        _this = null;
    }

    /**
     * 回调跳转并finish当前页面
     *
     * @param _this
     * @param _class
     * @param requestCode
     */
    public void goActivityResultKill(Activity _this, Class<? extends Activity> _class, int requestCode) {
        intent.setClass(_this, _class);
        _this.startActivityForResult(intent, requestCode);
        _this.finish();
        _this = null;
    }

    /**
     * 传递一个序列化实体类
     *
     * @param _this
     * @param _class
     * @param parcelable
     */
    public void goActivity(Context _this, Class<? extends Activity> _class, Parcelable parcelable) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        _this.startActivity(intent);
        _this = null;
    }
    public void goActivity(Context _this, Class<? extends Activity> _class, ArrayList<? extends Parcelable> value ) {
        intent.setClass(_this, _class);
        putParcelableArrayListExtra(value);
        _this.startActivity(intent);
        _this = null;
    }
    public void goActivity(Context _this, Class<? extends Activity> _class, Parcelable parcelable,Serializable serializable) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        putSerializable(serializable);
        _this.startActivity(intent);
        _this = null;
    }
    public void goActivity(Context _this, Class<? extends Activity> _class, Parcelable parcelable,Serializable serializable,ArrayList<? extends Parcelable> value) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        putSerializable(serializable);
        putParcelableArrayListExtra(value);
        _this.startActivity(intent);
        _this = null;
    }
    /**
     * 传递一个序列化实体类
     *
     * @param _this
     * @param _class
     * @param
     */
    public void goActivity(Context _this, Class<? extends Activity> _class,Serializable serializable) {
        intent.setClass(_this, _class);
        putSerializable(serializable);

        _this.startActivity(intent);
        _this = null;
    }

    /**
     * 启动一个Activity
     *
     * @param _this
     * @param _class
     * @param flags
     * @param parcelable 传递的实体类
     */
    public void goActivity(Context _this, Class<? extends Activity> _class, int flags, Parcelable parcelable) {
        intent.setClass(_this, _class);
        setFlags(flags);
        putParcelable(parcelable);
        _this.startActivity(intent);
        _this = null;
    }

    public void goActivityKill(Context _this, Class<? extends Activity> _class, Parcelable parcelable) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        _this.startActivity(intent);
        ((Activity) _this).finish();
        _this = null;
    }

    public void goActivityKill(Context _this, Class<? extends Activity> _class, int flags, Parcelable parcelable) {
        intent.setClass(_this, _class);
        setFlags(flags);
        putParcelable(parcelable);
        _this.startActivity(intent);
        ((Activity) _this).finish();
        _this = null;
    }

    public void goActivityResult(Activity _this, Class<? extends Activity> _class, Parcelable parcelable, int requestCode) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        _this.startActivityForResult(intent, requestCode);
        _this = null;
    }

    public void goActivityResult(Activity _this, Class<? extends Activity> _class, int flags, Parcelable parcelable, int requestCode) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        setFlags(flags);
        _this.startActivityForResult(intent, requestCode);
        _this = null;
    }

    public void goActivityResultKill(Activity _this, Class<? extends Activity> _class, Parcelable parcelable, int requestCode) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        _this.startActivityForResult(intent, requestCode);
        _this.finish();
        _this = null;
    }

    public void goActivityResultKill(Activity _this, Class<? extends Activity> _class, int flags, Parcelable parcelable, int requestCode) {
        intent.setClass(_this, _class);
        putParcelable(parcelable);
        setFlags(flags);
        _this.startActivityForResult(intent, requestCode);
        _this.finish();
        _this = null;
    }

    private void setFlags(int flags) {
        if (flags < 0) return;
        intent.setFlags(flags);
    }

    private void putParcelable(Parcelable parcelable) {
        if (parcelable == null) return;
        intent.putExtra(OPEN_ACTIVITY_KEY, parcelable);
    }
    private void putParcelableArrayListExtra(ArrayList<? extends Parcelable> parcelable) {
        if (parcelable == null) return;
        intent.putParcelableArrayListExtra(OPEN_ACTIVITY_KEY_LIST, parcelable);
    }
    private void putSerializable(Serializable serializable) {
        if (serializable == null) return;
        intent.putExtra(OPEN_ACTIVITY_KEY_SERIALIZABLE, serializable);
    }

    /**
     * 功能描述：带数据的Activity之间的跳转
     *
     * @param
     * @param cls
     * @param hashMap
     * @Time 2016年4月25日
     * @Author lizy18
     */
    public void skipAnotherActivity(Activity _this,
                                    Class<? extends Activity> cls,
                                    Map<String, ? extends Object> hashMap) {
        intent.setClass(_this, cls);
        Iterator<?> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            @SuppressWarnings("unchecked")
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator
                    .next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                intent.putExtra(key, (String) value);
            }
            if (value instanceof Boolean) {
                intent.putExtra(key, (boolean) value);
            }
            if (value instanceof Integer) {
                intent.putExtra(key, (int) value);
            }
            if (value instanceof Float) {
                intent.putExtra(key, (float) value);
            }
            if (value instanceof Double) {
                intent.putExtra(key, (double) value);
            }
        }
        _this.startActivity(intent);
    }


    /**
     * 功能描述：带数据的Activity之间的跳转
     *
     * @param
     * @param cls
     * @param hashMap
     * @Time 2016年4月25日
     * @Author lizy18
     */
    public void skipAnotherActivityResult(Activity _this,
                                    Class<? extends Activity> cls,
                                    Map<String, ? extends Object> hashMap,int requestCode) {
        intent.setClass(_this, cls);
        Iterator<?> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            @SuppressWarnings("unchecked")
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) iterator
                    .next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                intent.putExtra(key, (String) value);
            }
            if (value instanceof Boolean) {
                intent.putExtra(key, (boolean) value);
            }
            if (value instanceof Integer) {
                intent.putExtra(key, (int) value);
            }
            if (value instanceof Float) {
                intent.putExtra(key, (float) value);
            }
            if (value instanceof Double) {
                intent.putExtra(key, (double) value);
            }
        }
        _this.startActivityForResult(intent,requestCode);
    }

}
