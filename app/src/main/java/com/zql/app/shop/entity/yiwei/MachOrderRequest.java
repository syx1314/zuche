package com.zql.app.shop.entity.yiwei;

public class MachOrderRequest {
//    {"matchType":"3","orderId":"fdf6048a-6395-453f-b9ce-e8699429e5a2","pageNo":"1","pageSize":"20","role":"0","sortType":"1"}
private String matchType;
private String orderId;
private String pageNo;
private String pageSize;
private String role="0";
private String sortType="1"; // 2出发时间最早  1 离我最近 3 总价最高
private String endCity="粗略目的地";

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }
}
