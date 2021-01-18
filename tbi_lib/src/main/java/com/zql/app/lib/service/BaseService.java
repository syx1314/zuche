package com.zql.app.lib.service;

/**
 * Service基类
 * Created by huangzhe on 2016/11/29.
 */

public class BaseService {

//    /**
//     * 发送GET请求
//     *
//     * @param method
//     */
//    protected void getHttp(String method, Map<String, Object> params, final CommonCallback<BaseBeanResult> commonCallback) {
//        RequestParams requestParams = new RequestParams(IBaseConst.BASE.URL_BASE + method);
//        requestParams.addHeader("Content-Type", "application/json");
//        if(params!=null) {
//            for (String key : params.keySet()) {
//                requestParams.addParameter(key, params.get(key));
//            }
//        }
//        Callback.Cancelable cancelable = x.http().get(requestParams, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                BaseBeanResult beanResult = new BaseBeanResult(true, result);
//                commonCallback.onCallBack(beanResult);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                BaseBeanResult beanRsult = new BaseBeanResult(false, ex.getMessage());
//                commonCallback.onCallBack(beanRsult);
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//                BaseBeanResult beanRsult = new BaseBeanResult(false, cex.getMessage());
//                commonCallback.onCallBack(beanRsult);
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//    }
//
//    /**
//     * 发送POST请求，请求参数包装成JSON形式
//     * @param method
//     * @param params
//     * @param commonCallback
//     */
//    public  void postHttp(String method, Map<String, Object> params, final CommonCallback<BaseBeanResult> commonCallback){
//        JSONObject obj=new JSONObject(params);
//        postHttp(method,obj.toString(),commonCallback);
//    }
//
//    /**
//     * 发送POST请求
//     *
//     * @param method
//     */
//    protected void postHttp(String method, String paramStr, final CommonCallback<BaseBeanResult> commonCallback) {
//        RequestParams requestParams = new RequestParams(IBaseConst.BASE.URL_BASE  + method);
//        requestParams.addHeader("Content-Type", "application/json");
//        if(Validator.isNotEmpty(paramStr)) {
//            requestParams.setBodyContent(paramStr);
//        }
//        Callback.Cancelable cancelable = x.http().post(requestParams, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                BaseBeanResult beanResult = new BaseBeanResult(true, result);
//                commonCallback.onCallBack(beanResult);
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                BaseBeanResult beanRsult = new BaseBeanResult(false, ex.getMessage());
//                commonCallback.onCallBack(beanRsult);
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//                BaseBeanResult beanRsult = new BaseBeanResult(false, cex.getMessage());
//                commonCallback.onCallBack(beanRsult);
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
//    }

}
