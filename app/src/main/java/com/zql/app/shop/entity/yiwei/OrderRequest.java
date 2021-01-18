package com.zql.app.shop.entity.yiwei;

import java.util.List;

public class OrderRequest {
    private String isNewEdition="3";
    private String pageSize="10";
    private String role="0";
    private String pageNo="1";
    private List<String> orderTypeList;

    public void setIsNewEdition(String isNewEdition) {
        this.isNewEdition = isNewEdition;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public void setOrderTypeList(List<String> orderTypeList) {
        this.orderTypeList = orderTypeList;
    }
}
