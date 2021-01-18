package com.zql.app.shop.entity.yiwei;

import com.zql.app.lib.util.Validator;

public class YiweiCar implements Cloneable{
    private String  orderInSeats;//几人
    private String  startPoint;//开始点
    private String  startCity;//开始点
    private String  endPoint;//结束点
    private String  endCity;//结束点
    private YiweiPasserInfo  passerInfo;//几人
    private String  passerId;//几人
    private String  totalDistance;//距离
    private String  leaveWords;//留言
    private String  ownerOrderAccount;//显示订单价格
    private String  orderAccount;//订单价格
    private String  leaveOffTime;//戒指时间
    private String  leaveOnTime;//开始时间
    private String  orderCreateTime;//订单创建时间
    private String orderId;
    private String maxPrice;
    private String minPrice;

    public String getOrderInSeats() {
        return orderInSeats;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getStartCity() {
        return startCity;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getEndCity() {
        return endCity;
    }

    public YiweiPasserInfo getPasserInfo() {
        return passerInfo;
    }

    public String getPasserId() {
        return passerId;
    }

    public String getTotalDistance() {
        return totalDistance;
    }

    public String getLeaveWords() {
        return Validator.isNotEmpty(leaveWords)?leaveWords:"";
    }

    public String getOwnerOrderAccount() {
        return ownerOrderAccount;
    }

    public String getOrderAccount() {
        return orderAccount;
    }

    public String getLeaveOffTime() {
        return leaveOffTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getLeaveOnTime() {
        if (Validator.isNotEmpty(leaveOnTime)){
            return leaveOnTime;
        }else if (Validator.isNotEmpty(leaveOffTime)){
            return leaveOffTime;
        }
        return "0";
    }

    public String getOrderCreateTime() {
        return orderCreateTime;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

