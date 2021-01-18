package com.zql.app.shop.entity.yiwei;

public class LoginResponse {

//    {
//        "data": {
//        "sessionId": "6b0f7ee668e848f08ec8493c79f66538",
//                "userId": "09d91fa8-3369-11ea-a206-98039b46d4d0",
//                "userVehicleIdentity": 1
//    },
//        "status": 1
//    }

private  String status;
private  LoginRes data;

    public String getStatus() {
        return status;
    }

    public LoginRes getData() {
        return data;
    }

    public class LoginRes{
    private String sessionId;
    private String userId;
    private String userVehicleIdentity;
    private String msg;
    private String code;

    public String getSessionId() {
        return sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserVehicleIdentity() {
        return userVehicleIdentity;
    }

    public String getMsg() {
        return msg;
    }

    public String getCode() {
        return code;
    }
}

}
