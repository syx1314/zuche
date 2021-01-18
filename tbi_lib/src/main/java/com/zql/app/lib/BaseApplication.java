package com.zql.app.lib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.zql.app.lib.core.ApiService;
import com.zql.app.lib.entity.ILoginConfig;

import org.xutils.BuildConfig;
import org.xutils.DbManager;
import org.xutils.x;
import java.util.LinkedList;
import java.util.List;

/**
 * 全局Application的基类
 * Created by huangzhe on 2016/11/25.
 */

public abstract class BaseApplication extends Application{
    private DbManager mDb;//数据库
    private DbManager.DaoConfig daoConfig;
    public static Context mContext;

    /**
     * 得到API接口地址
     * @return
     */
    public abstract String getApiUrl();

    /**
     * API扩展接口
     * @return
     */
    public abstract String getApiExtUrl();


    public abstract String getApiLoadUrl();
    /**
     * 退出程序
     * @param isClearData
     */
    public abstract void quit(boolean isClearData);

    /**
     * 得到当前登录用户
     * @return
     */
    public abstract ILoginConfig getLoginConfig();

    /**
     * 保存登录状态
     * @param mLoginConfig
     * @param isSaveDB 如果为False, 只返回LoginConfig实体，不将记录保存到内部数据库中
     */
    public abstract void saveLoginConfig(ILoginConfig mLoginConfig, boolean isSaveDB);


    public void onCreate(){
        super.onCreate();
        mContext=getApplicationContext();
    }

    protected List<Activity> activityList = new LinkedList<Activity>();
    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }
    public void popupActivity(Activity activity) {
        activityList.remove(activity);
    }

    // 遍历所有Activity并finish
    public void clearActivity() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }


    /**
     * 初始化数据库
     */
    protected void initDb(String dbName,Integer dbVersion,DbManager.DbUpgradeListener dbUpgradeListener){
        x.Ext.init(this);//Xutils初始化
        x.Ext.setDebug(BuildConfig.DEBUG);
        daoConfig = new DbManager.DaoConfig()
                .setDbName(dbName)//创建数据库的名称
                .setDbVersion(dbVersion)//数据库版本号
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        // 开启WAL, 对写入加速提升巨大
                        db.getDatabase().enableWriteAheadLogging();
                    }
                })
                .setDbUpgradeListener(dbUpgradeListener);
    }

    /**
     * daoConfig get方法
     * @return
     */
    public DbManager.DaoConfig getDaoConfig() {
        return daoConfig;
    }

    /**
     * 数据库操作类
     * @return
     */
    public DbManager getDb() {
        if(mDb==null){
            mDb =  x.getDb(daoConfig);
        }
        return mDb;
    }

    /**
     * 得到API的Service
     * @param service
     * @param <T>
     * @return
     */
    public <T> T getApiService(Class<T> service){
        return ApiService.getInstance(getApiUrl()).create(service);
    }

    /**
     * 得到API的Service
     * @param service
     * @param <T>
     * @return
     */
    public <T> T getApiExtService(Class<T> service){
        return ApiService.getExtInstance(getApiExtUrl()).create(service);
    }
    /**
     * 得到API的Service
     * @param service
     * @param <T>
     * @return
     */
    public <T> T getApiLoadService(Class<T> service){
        return ApiService.getLoadInstance(getApiLoadUrl()).create(service);
    }


}
