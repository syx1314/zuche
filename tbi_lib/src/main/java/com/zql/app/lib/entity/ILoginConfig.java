package com.zql.app.lib.entity;

import java.io.Serializable;

/**
 * 登录用户统一接口
 * Created by huangzhe on 2016/11/25.
 */

public interface ILoginConfig extends Serializable{
    String  getUserId();//用户id
    String  getUserName();//用户名称
    String getToken();//URl的Token
    String getPtoken();
    String getCurVsersion();//当前所处系统，个人版？商务版
}
