package com.zql.app.shop.entity.yiwei;

public class YiweiPasserInfo {
    /*
            "identityStatus":"0",
            "inviteUserId":"",
            "passerAvatar":"http://oxc8t6uon.bkt.clouddn.com/headimg_25.png",
            "passerId":"",
            "passerMobile":"188****8175",
            "passerName":"尾号8175",
            "passerSex":"0",
            "userBeEvaluateName":"非常棒",
            "userBeEvaluateScore":100*/

    private String passerMobile;
    private String passerAvatar;
    private String passerName;
    private String passerSex;
    private String userBeEvaluateScore; //用户评估分数

    public String getPasserMobile() {
        return passerMobile;
    }

    public String getPasserAvatar() {
        return passerAvatar;
    }

    public String getPasserName() {
        return passerName;
    }

    public String getPasserSex() {
        return passerSex;
    }

    public String getUserBeEvaluateScore() {
        return userBeEvaluateScore;
    }
}
