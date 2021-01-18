package com.zql.app.shop.entity.yiwei;

import java.util.List;

public class MachOrderReponse {
//    {"matchType":"3","orderId":"fdf6048a-6395-453f-b9ce-e8699429e5a2","pageNo":"1","pageSize":"20","role":"0","sortType":"1"}

    private String matchType1Count;
    private String matchType2Count;
    private String matchType3Count;
    private String matchType4Count;
    private List<YiweiCar> orderListVO;

    public String getMatchType1Count() {
        return matchType1Count;
    }

    public String getMatchType2Count() {
        return matchType2Count;
    }

    public String getMatchType3Count() {
        return matchType3Count;
    }

    public String getMatchType4Count() {
        return matchType4Count;
    }

    public List<YiweiCar> getOrderListVO() {
        return orderListVO;
    }
}
