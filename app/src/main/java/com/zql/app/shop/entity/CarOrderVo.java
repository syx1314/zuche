package com.zql.app.shop.entity;

import com.zql.app.lib.entity.BaseBean;

/**
 * 接送机 预约用车的订单VO
 * Created by yyj on 2018/1/27.
 */

public class CarOrderVo extends BaseBean {

    private String endDate;//结束时间:yyyy-MM-dd ,
    private String orderSource;// 订单来源 ,
    private String startDate;// 开始时间:yyyy-MM-dd ,
    private String travelDestination;// 出差地 ,
    private String travelOrderNo;//出差单id ,
    private String travelPurposen;//出差目的 ,
    private String travelReason;// 出差理由

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTravelDestination() {
        return travelDestination;
    }

    public void setTravelDestination(String travelDestination) {
        this.travelDestination = travelDestination;
    }

    public String getTravelOrderNo() {
        return travelOrderNo;
    }

    public void setTravelOrderNo(String travelOrderNo) {
        this.travelOrderNo = travelOrderNo;
    }

    public String getTravelPurposen() {
        return travelPurposen;
    }

    public void setTravelPurposen(String travelPurposen) {
        this.travelPurposen = travelPurposen;
    }

    public String getTravelReason() {
        return travelReason;
    }

    public void setTravelReason(String travelReason) {
        this.travelReason = travelReason;
    }
}
