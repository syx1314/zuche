package com.zql.app.shop.service;

import com.zql.app.shop.entity.yiwei.LoginResponse;
import com.zql.app.shop.entity.yiwei.MachOrderReponse;
import com.zql.app.shop.entity.yiwei.MachReponse;
import com.zql.app.shop.entity.yiwei.YiViUserCardReponse;
import com.zql.app.shop.event.ApiResult;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiYiweiservice {



    @GET("business/v1.0/business/freeride/getPasserOrderByEs")
    Observable<ApiResult<String>>   carOrderList(@Query(value = "params", encoded = true) String params);

    @GET("business/v1.0/business/orderMatch/getOrderMatchList683")
    Observable<MachReponse>   carOrderJinzhunList(@Header("userId") String uid, @Query(value = "params", encoded = true) String params);
    //进行监控中订单
    @GET("business/v1.0/business/freeride/order/getOrderListInProgress")
    Observable<ApiResult<String>>   carOrderPlaningList(@Header("userId") String uid,@Query(value = "params", encoded = true) String params);


    @GET("business/v1.0/business/freeride/order/getOrderListInProgress")
    Observable<ApiResult<String>>   carOrderJinxingList(@Query(value = "params", encoded = true) String params);

    @GET("business/v1.0/business/freeride/order/getUserDetailInfo")
    Observable<YiViUserCardReponse>   findUserPhone(@Query(value = "params", encoded = true) String params);

    @POST("/sso/login/register/loginByPwd.json")
    Observable<LoginResponse> loginByPwd(@Query("userMobile") String userMobile,@Query("userPassword") String userPassword);

}
