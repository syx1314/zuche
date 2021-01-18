package com.zql.app.shop.service;

import com.zql.app.shop.entity.PostException;
import com.zql.app.shop.entity.WeiXinExceptionResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Administrator on 2018/12/10 0010.
 */

public interface SendExceptionService {



    @POST("/api/send/message")
    Observable<WeiXinExceptionResponse<String>> sendException(@Body PostException ex);
}
