package com.zql.app.shop;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Log;



import com.google.gson.Gson;

import com.tencent.smtt.export.external.TbsCoreSettings;
import com.zql.app.lib.BaseApplication;
import com.zql.app.lib.core.ApiService;
import com.zql.app.lib.core.IBaseConst;
import com.zql.app.lib.entity.ILoginConfig;
import com.zql.app.lib.service.impl.RxApiManager;
import com.zql.app.lib.util.DateUtil;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.util.sys.PrefManager;
import com.zql.app.lib.util.sys.SwitchLanguage;
import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.shop.core.TbiAppActivity;

import com.zql.app.shop.entity.PostException;

import com.zql.app.shop.entity.WeiXinExceptionResponse;

import com.zql.app.shop.service.SendExceptionService;
import com.zql.app.shop.util.JPushUtil;
import com.zql.app.shop.util.LanguageSeting;
import com.zql.app.shop.util.PushUtils;


import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.stat.StatConfig;
import com.tencent.stat.StatService;
import com.umeng.analytics.MobclickAgent;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import org.xutils.DbManager;
import org.xutils.ex.DbException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;
import me.jessyan.autosize.onAdaptListener;
import me.jessyan.autosize.utils.AutoSizeLog;
import me.leolin.shortcutbadger.ShortcutBadger;
import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * 全局变量
 * Created by huangzhe on 2016/11/25.
 */

public class TbiApplication extends BaseApplication {
    private static TbiApplication instance;

    public interface MsgDisplayListener {
        void handle(String msg);
    }
    public static MsgDisplayListener msgDisplayListener = null;
    public static StringBuilder cacheMsg = new StringBuilder();
    /**
     * 得到当前实例
     *
     * @return
     */
    public static TbiApplication getInstance() {
        return instance;
    }



    @Override
    public void onCreate() {
        super.onCreate();
        screenAdapter();
        disableAPIDialog();
        initManService(this);

        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(this);
        strategy.setCrashHandleCallback(new CrashReport.CrashHandleCallback() {
            public Map<String, String> onCrashHandleStart(int crashType, String errorType,
                                                          String errorMessage, String errorStack) {

                String append = "";
                if (getLoginConfig() != null) {
                    append = "账号:" + getLoginConfig().getUserName() + "</br>" +
                            "个人版TOKEN:" + getLoginConfig().getPtoken() + "</br>" +
                            "商务版TOKEN:" + getLoginConfig().getPtoken() + "</br>";
                }

                sendBugMsg(errorType+"</br>"+errorMessage+"</br>"+errorStack);
                LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
                map.put("关键信息-》", append);
                return map;
            }

            @Override
            public byte[] onCrashHandleStart2GetExtraDatas(int crashType, String errorType,
                                                           String errorMessage, String errorStack) {
                try {
                    return "Extra data.".getBytes(StandardCharsets.UTF_8);
                } catch (Exception e) {
                    return null;
                }
            }

        });
        CrashReport.initCrashReport(getApplicationContext(), "cf496d1414", false, strategy);
//        if(BuildConfig.DEBUG) {
//            if (LeakCanary.isInAnalyzerProcess(this)) {
//                // This process is dedicated to LeakCanary for heap analysis.
//                // You should not init your app in this process.
//                return;
//            }
//            LeakCanary.install(this);
//        }
        instance = this;
        initDb(IConst.BASE.DB_NAME, IConst.BASE.DB_VER_NUM,
                new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        //待更新版本
//                        if(oldVersion!=newVersion){
//                            db.update();
//                        }
                    }
                });
//        // 打开JPUSH
//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);
         PushUtils.init(this);


        ZXingLibrary.initDisplayOpinion(this);
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }
            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        QbSdk.initTbsSettings(map);


        //x5内核初始化接口
        try {
            QbSdk.initX5Environment(this, cb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendBugMsg(String errorStack) {
        PostException postException = new PostException();
        ArrayList<String> userIds = new ArrayList<>();
        userIds.add("UID_Exxme3lVOFLk5fpDDCnkctkAHBem");
        userIds.add("UID_xBV1MX9ak7yybca8tWGZ1jWrUz61");
        postException.setUids(userIds);
        String titleHtml="<font color='#ff0000'>靠!APP出事了</font></br>";
        String timeHtml="<font color='#000000'>"+DateUtil.getCurrentDateForSDFHMS()+"</font></br>";
        String sourceHtml="<font color='#000000'>来自Android消息</font></br>";
        String append = "";
        if (getLoginConfig() != null) {
            append = "账号:" + getLoginConfig().getUserName() + "</br>" +
                    "个人版TOKEN:" + getLoginConfig().getPtoken() + "</br>" +
                    "商务版TOKEN:" + getLoginConfig().getPtoken() + "</br>";
        }
        String content="<font color='#f00'>"+append+errorStack+"</font>";
        postException.setAppToken("AT_JS7sf1QjjG67MCCmAIsuWtPhHThN9M8C");
        postException.setContentType("2");
        postException.setContent(titleHtml+timeHtml+sourceHtml+content);
        Observable<WeiXinExceptionResponse<String>> observable = ApiService.getBugInstance("http://wxpusher.zjiecode.com/").create(SendExceptionService.class).sendException(postException);
        final int tag = this.hashCode();
        LogMe.e("请求错误信息");
        RxApiManager.instance().add(tag, observable.hashCode(),
                observable.subscribeOn(Schedulers.io())
                        .subscribe(new Action1<WeiXinExceptionResponse<String>>() {
                            @Override
                            public void call(WeiXinExceptionResponse<String> stringWeiXinExceptionResponse) {
                                LogMe.e("11111111111" + stringWeiXinExceptionResponse);
                            }
                        })
        );

    }

    /**
     * 退出系统
     *
     * @param isClearData 是否清空
     */
    @Override
    public void quit(boolean isClearData) {

        System.exit(0);
    }

    @Override
    public ILoginConfig getLoginConfig() {
        return null;
    }

    @Override
    public void saveLoginConfig(ILoginConfig mLoginConfig, boolean isSaveDB) {

    }


    @Override
    public String getApiUrl() {
        return IConst.BASE.URL_BASE;
    }

    /**
     * 火车票和专车
     *
     * @return
     */
    @Override
    public String getApiExtUrl() {
        return IConst.BASE.URL_BASE_EXT;
    }

    @Override
    public String getApiLoadUrl() {
        return IConst.BASE.FIX_URL_BASE;
    }

    /**
     * 清楚并保留Main页面
     */
    public void clearActivityByMain() {
        Iterator<Activity> iterator = activityList.iterator();

    }

    /**
     * 清楚并保留Main页面
     */
    public void clearActivity() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }

    /**
     * 清楚并保留Main页面
     */
    public void clearActivityKeep(Class<? extends TbiAppActivity> className, Class<? extends TbiAppActivity> className2) {
        for (Activity activity : activityList) {
            if (activity.getClass() != className && activity.getClass() != className2) {
                activity.finish();
            }
        }
    }

    /**
     * 清楚并保留Main页面
     */
    public void clearActivityKeep(Class<? extends TbiAppActivity> className, Class<? extends TbiAppActivity> className2, Class<? extends TbiAppActivity> className3) {
        for (Activity activity : activityList) {
            if (activity.getClass() != className && activity.getClass() != className2 && activity.getClass() != className3) {
                activity.finish();
            }
        }
    }

    /**
     * 清楚指定页面 比如重新预订要保留一些页面
     */
    public void clearActivityList(List<Class<? extends TbiAppActivity>> className2) {
        for (Activity activity : activityList) {
            for (Class mClass : className2) {
                if (activity.getClass() == mClass) {
                    activity.finish();
                }
            }
        }
    }

    /**
     * 清楚重复页面的最后一个
     */
    public void clearLastReActivityList(Class<? extends TbiAppActivity> className2) {

        for (int i = activityList.size() - 1; i >= 0; i--) {
            Activity activity = activityList.get(i);

            if (activity.getClass() == className2) {
                activity.finish();
                break;
            }
        }
    }

    /**
     * 保留一些页面不清楚
     */
    public void clearActivitykeepList(List<Class<? extends TbiAppActivity>> className2) {
        for (Activity activity : activityList) {
            boolean fag = true;
            for (Class mClass : className2) {
                if (activity.getClass() == mClass) {
                    fag = false;
                    break;
                } else {
                    fag = true;
                }
            }
            if (fag) {
                activity.finish();
            }
        }
    }

    /**
     * 查询指定的窗体
     *
     * @param className
     * @param <T>
     * @return
     */
    public <T> T findActivityByClass(Class<T> className) {
        LogMe.e("查找的activity数量" + activityList.size());
        for (int i = 0; i < activityList.size(); i++) {
            LogMe.e("查找的activity" + activityList.get(i).getClass() + "----" + className);
            if ((activityList.get(i).getClass() + "").equals(className + "")) {

                return (T) activityList.get(i);
            }
        }
        return null;
    }

    /**
     * 清除到指定Activity
     */
    public void clearActivityToActivity(Class<? extends TbiAppActivity> className) {
        for (int i = activityList.size() - 1; i > 0; i--) {
            Log.d("Activity", activityList.get(i).getClass().toString() + " | " + className.toString());
            if (activityList.get(i).getClass() != className)
                activityList.get(i).finish();
            else
                break;
        }
    }

    /**
     * 清除指定页面
     */
    public void clearActivityByActivity(Class<? extends TbiAppActivity> className) {
        for (Activity activity : activityList) {
            if (activity.getClass() == className) {
                activity.finish();
            }
        }
    }


    private void initManService(Context context) {


        // [可选]设置是否打开debug输出，上线时请关闭，Logcat标签为"MtaSDK"
        StatConfig.setDebugEnable(true);
        // 基础统计API
        StatService.registerActivityLifecycleCallbacks(this);
//        /**
//         * 初始化Mobile Analytics服务
//         */
//        // 获取MAN服务
//        MANService manService = MANServiceProvider.getService();
//        // 打开调试日志
//        manService.getMANAnalytics().turnOnDebug();
//        manService.getMANAnalytics().setAppVersion(Utils.packageCode(context));
//        // MAN初始化方法之一，通过插件接入后直接在下发json中获取appKey和appSecret初始化
//        manService.getMANAnalytics().init(this, getApplicationContext());
////         MAN另一初始化方法，手动指定appKey和appSecret
//        // 若需要关闭 SDK 的自动异常捕获功能可进行如下操作,详见文档5.4
//        //manService.getMANAnalytics().turnOffCrashReporter();
//        // 通过此接口关闭页面自动打点功能，详见文档4.2
////        manService.getMANAnalytics().turnOffAutoPageTrack();
//        // 设置渠道（用以标记该app的分发渠道名称），如果不关心可以不设置即不调用该接口，渠道设置将影响控制台【渠道分析】栏目的报表展现。如果文档3.3章节更能满足您渠道配置的需求，就不要调用此方法，按照3.3进行配置即可
//        manService.getMANAnalytics().setChannel("自有渠道");

    }
    /**
     * 反射 禁止弹窗
     */
    private void disableAPIDialog(){
        if (Build.VERSION.SDK_INT < 28)return;
        try {
            Class clazz = Class.forName("android.app.ActivityThread");
            Method currentActivityThread = clazz.getDeclaredMethod("currentActivityThread");
            currentActivityThread.setAccessible(true);
            Object activityThread = currentActivityThread.invoke(null);
            Field mHiddenApiWarningShown = clazz.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);

//            DialogUtil.showToastCust("屏蔽弹框反射");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void screenAdapter(){
        //当 App 中出现多进程, 并且您需要适配所有的进程, 就需要在 App 初始化时调用 initCompatMultiProcess()
        //在 Demo 中跳转的三方库中的 DefaultErrorActivity 就是在另外一个进程中, 所以要想适配这个 Activity 就需要调用 initCompatMultiProcess()
        AutoSize.initCompatMultiProcess(this);

        //如果在某些特殊情况下出现 InitProvider 未能正常实例化, 导致 AndroidAutoSize 未能完成初始化
        //可以主动调用 AutoSize.checkAndInit(this) 方法, 完成 AndroidAutoSize 的初始化后即可正常使用
//        AutoSize.checkAndInit(this);

//        如何控制 AndroidAutoSize 的初始化，让 AndroidAutoSize 在某些设备上不自动启动？https://github.com/JessYanCoding/AndroidAutoSize/issues/249

        /**
         * 以下是 AndroidAutoSize 可以自定义的参数, {@link AutoSizeConfig} 的每个方法的注释都写的很详细
         * 使用前请一定记得跳进源码，查看方法的注释, 下面的注释只是简单描述!!!
         */
        AutoSizeConfig.getInstance()

                //是否让框架支持自定义 Fragment 的适配参数, 由于这个需求是比较少见的, 所以须要使用者手动开启
                //如果没有这个需求建议不开启
                .setCustomFragment(true)

                //是否屏蔽系统字体大小对 AndroidAutoSize 的影响, 如果为 true, App 内的字体的大小将不会跟随系统设置中字体大小的改变
                //如果为 false, 则会跟随系统设置中字体大小的改变, 默认为 false
//                .setExcludeFontScale(true)

                //区别于系统字体大小的放大比例, AndroidAutoSize 允许 APP 内部可以独立于系统字体大小之外，独自拥有全局调节 APP 字体大小的能力
                //当然, 在 APP 内您必须使用 sp 来作为字体的单位, 否则此功能无效, 不设置或将此值设为 0 则取消此功能
//                .setPrivateFontScale(0.8f)

                //屏幕适配监听器
                .setOnAdaptListener(new onAdaptListener() {
                    @Override
                    public void onAdaptBefore(Object target, Activity activity) {
                        //使用以下代码, 可以解决横竖屏切换时的屏幕适配问题
                        //使用以下代码, 可支持 Android 的分屏或缩放模式, 但前提是在分屏或缩放模式下当用户改变您 App 的窗口大小时
                        //系统会重绘当前的页面, 经测试在某些机型, 某些情况下系统不会重绘当前页面, ScreenUtils.getScreenSize(activity) 的参数一定要不要传 Application!!!
//                        AutoSizeConfig.getInstance().setScreenWidth(ScreenUtils.getScreenSize(activity)[0]);
//                        AutoSizeConfig.getInstance().setScreenHeight(ScreenUtils.getScreenSize(activity)[1]);
                        AutoSizeLog.d(String.format(Locale.ENGLISH, "%s onAdaptBefore!", target.getClass().getName()));
                    }

                    @Override
                    public void onAdaptAfter(Object target, Activity activity) {
                        AutoSizeLog.d(String.format(Locale.ENGLISH, "%s onAdaptAfter!", target.getClass().getName()));
                    }
                })

        //是否打印 AutoSize 的内部日志, 默认为 true, 如果您不想 AutoSize 打印日志, 则请设置为 false
//                .setLog(false)

        //是否使用设备的实际尺寸做适配, 默认为 false, 如果设置为 false, 在以屏幕高度为基准进行适配时
        //AutoSize 会将屏幕总高度减去状态栏高度来做适配
        //设置为 true 则使用设备的实际屏幕高度, 不会减去状态栏高度
        //在全面屏或刘海屏幕设备中, 获取到的屏幕高度可能不包含状态栏高度, 所以在全面屏设备中不需要减去状态栏高度，所以可以 setUseDeviceSize(true)
                .setUseDeviceSize(true)

        //是否全局按照宽度进行等比例适配, 默认为 true, 如果设置为 false, AutoSize 会全局按照高度进行适配
//                .setBaseOnWidth(false)

        //设置屏幕适配逻辑策略类, 一般不用设置, 使用框架默认的就好
//                .setAutoAdaptStrategy(new AutoAdaptStrategy())
        ;
    }
}
