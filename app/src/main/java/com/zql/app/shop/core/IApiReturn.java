package com.zql.app.shop.core;

import com.zql.app.shop.event.ApiResult;

/**
 * 处理API返回值
 * Created by huangzhe on 2017/4/13.
 */
public interface IApiReturn<T> {
    void run(ApiResult<T> apiResult);
}
