package com.zql.app.shop.entity;

/**
 * 差旅标准
 * Created by yyj on 2018/2/8.
 * "canOrder (string): 违反差标时是否可预订（0：否，1：是） ,
 * carDesc (string): 专车差标描述 ,
 * flightDesc (string): 机票差标描述 ,
 * hotelDesc (string): 酒店差标描述 ,
 * trainDesc (string): 火车票差标描述
 */

public class Policy {


    private String canOrder;
    private String carDesc;
    private String flightDesc;

    private String hotelDesc;
    private String trainDesc;
    //自己添加的属性
    private String homeTitle;
    private String interTitle;
    private String interflightDesc;
    private String homeflightDesc;
    public String getCanOrder() {
        return canOrder;
    }

    public void setCanOrder(String canOrder) {
        this.canOrder = canOrder;
    }

    public String getCarDesc() {
        return carDesc;
    }

    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc;
    }

    public String getFlightDesc() {
        return flightDesc;
    }

    public void setFlightDesc(String flightDesc) {
        this.flightDesc = flightDesc;
    }

    public String getHotelDesc() {
        return hotelDesc;
    }

    public void setHotelDesc(String hotelDesc) {
        this.hotelDesc = hotelDesc;
    }

    public String getTrainDesc() {
        return trainDesc;
    }

    public void setTrainDesc(String trainDesc) {
        this.trainDesc = trainDesc;
    }

    public String getHomeTitle() {
        return homeTitle;
    }

    public void setHomeTitle(String homeTitle) {
        this.homeTitle = homeTitle;
    }

    public String getInterTitle() {
        return interTitle;
    }

    public void setInterTitle(String interTitle) {
        this.interTitle = interTitle;
    }

    public String getInterflightDesc() {
        return interflightDesc;
    }

    public void setInterflightDesc(String interflightDesc) {
        this.interflightDesc = interflightDesc;
    }

    public String getHomeflightDesc() {
        return homeflightDesc;
    }

    public void setHomeflightDesc(String homeflightDesc) {
        this.homeflightDesc = homeflightDesc;
    }
}
