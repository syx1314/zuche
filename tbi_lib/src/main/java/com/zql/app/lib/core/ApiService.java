package com.zql.app.lib.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.IntegerDefault0Adapter;
import com.google.gson.internal.bind.LongDefaultAdapter;
import com.zql.app.lib.BaseApplication;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.DeviceUtils;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.util.sys.NetUtils;
import com.zql.app.lib.util.sys.PrefManager;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 访问后台API接口工具类
 * Created by huangzhe on 2017/4/13.
 */
public class ApiService {
    private static ApiService instance;
    private static ApiService extInstance;
    private static ApiService bugInstance;
    private static ApiService loadInstance;
    private Retrofit retrofit;

    private ApiService(String baseUrl) {
        //缓存
        File httpCacheDirectory = new File(BaseApplication.mContext.getCacheDir(), "responses");
        if (!httpCacheDirectory.exists()) {
            httpCacheDirectory.mkdirs();
        }
        int cacheSize = 10 * 1024 * 1024;//10 MB
        Cache cache = new Cache(httpCacheDirectory, cacheSize);

        //设置应用拦截器，可用于设置公共参数，头信息，日志拦截等
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();


        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .retryOnConnectionFailure(true) //错误重联
                .addInterceptor(new RewriteCacheControlInterceptor())
                .cache(cache)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request()
                                .newBuilder()
                                .removeHeader("User-Agent")//移除旧的
                                //WebSettings.getDefaultUserAgent(mContext) 是获取原来的User-Agent
                                .addHeader("User-Agent","YiViCarOwner/6.8.3 (iPhone; iOS 10.3.1; Scale/3.00)")
                                .addHeader("appVersion","6.8.3")
                                .addHeader("deviceType","MOBILE")
                                .addHeader("channel","7")
                                .addHeader("uuid","b740175d0d9b0d4623dd75b0c5bcebaa")
                                .build();
                        return chain.proceed(request);

                    }
                })
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(buildGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private Gson buildGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .registerTypeAdapter(Integer.class, new IntegerDefault0Adapter())
                .registerTypeAdapter(int.class, new IntegerDefault0Adapter())
                .registerTypeAdapter(Long.class, new LongDefaultAdapter())
                .registerTypeAdapter(long.class, new LongDefaultAdapter())
                .create();
    }

    /**
     * 得到实例
     *
     * @return
     */
    public static ApiService getInstance(String baseUrl) {
        if (instance == null) {
            synchronized (ApiService.class) {
                if (instance == null) {
                    instance = new ApiService(baseUrl);
                }
            }
        }
        return instance;
    }

    public static ApiService getExtInstance(String baseUrl) {
        if (extInstance == null) {
            synchronized (ApiService.class) {
                if (extInstance == null) {
                    extInstance = new ApiService(baseUrl);
                }
            }
        }
        return extInstance;
    }
    public static ApiService getBugInstance(String baseUrl) {
        if (bugInstance == null) {
            synchronized (ApiService.class) {
                if (bugInstance == null) {
                    bugInstance = new ApiService(baseUrl);
                }
            }
        }
        return bugInstance;
    }
    public static ApiService getLoadInstance(String baseUrl) {
        if (loadInstance == null) {
            synchronized (ApiService.class) {
                if (loadInstance == null) {
                    loadInstance = new ApiService(baseUrl);
                }
            }
        }
        return loadInstance;
    }

    /**
     * 清除缓存
     */
    public void clearCache() throws IOException {
        OkHttpClient client = (OkHttpClient) instance.retrofit.callFactory();
        for (File file : client.cache().directory().listFiles()) {
            file.delete();
        }
    }

    /**
     * 得到具体的Service
     *
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }

    /**
     * 重定向缓存控制
     */
    class RewriteCacheControlInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            //请求
            Request request = chain.request();
            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
//            cacheBuilder.noCache();
            if(request.cacheControl().maxAgeSeconds()>0) {
                cacheBuilder.maxAge(request.cacheControl().maxAgeSeconds(), TimeUnit.SECONDS);
            }else {
                cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            }
            cacheBuilder.maxStale(365, TimeUnit.DAYS);
            CacheControl cacheControl = cacheBuilder.build();

            if (!NetUtils.checkNetWorkIsAvailable(BaseApplication.mContext)) {
                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();
            } else {
                BaseApplication baseApplication = (BaseApplication) BaseApplication.mContext;
                if (baseApplication.getLoginConfig() != null&& (Validator.isNotEmpty(baseApplication.getLoginConfig().getToken()) || Validator.isNotEmpty(baseApplication.getLoginConfig().getPtoken()))) {
                    if (baseApplication.getLoginConfig() != null) {
                        String curVsersion = baseApplication.getLoginConfig().getCurVsersion();
                        if (IBaseConst.BASE.C_VERSION.equals(curVsersion)) {
                            if(Validator.isNotEmpty(baseApplication.getLoginConfig().getToken())) {
                                LogMe.e("商务版token:", baseApplication.getLoginConfig().getToken());
                                request = request.newBuilder().header("authorization", baseApplication.getLoginConfig().getToken()).build();//加入token头
//                                request = request.newBuilder().header("authorization","5102_005b3b37201748158a98da178473618c").build();//加入token头
                            }
                        } else {
                            if(Validator.isNotEmpty(baseApplication.getLoginConfig().getPtoken())) {
                            LogMe.e("个人版token:", baseApplication.getLoginConfig().getPtoken());
                                request = request.newBuilder().header("authorization", baseApplication.getLoginConfig().getPtoken()).build();//加入token头
//                            request = request.newBuilder().header("authorization","10000007_d9e0b2288e9247deb02276cf01c80acc").build();//加入token头
                            }
                        }
                        request=request.newBuilder().header("lang", PrefManager.getString(baseApplication,IBaseConst.PreManager.LOCAL_LANGUAGE, Locale.getDefault().getLanguage())).build();

                    }
//                    request=request.newBuilder().header("authorization","365_e16b1951a6964731bb4759887bbce03e").build();//加入token头
                }
            }
            //返回数据
            Response originalResponse = chain.proceed(request);
            LogMe.e("originalResponse"+originalResponse.toString());
            if (NetUtils.checkNetWorkIsAvailable(BaseApplication.mContext)) {
                int maxAge = 0;
                if(request.cacheControl().maxAgeSeconds()>0){
                    maxAge=request.cacheControl().maxAgeSeconds();
                }
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    }
}
