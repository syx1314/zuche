package com.zql.app.shop.entity;

/**
 * Created by huangzhe on 2017/2/10.
 */

public class JPushInfo {
    /**
     * {
     *     "content":"您的酒店订单:"
     * ,
     *     "extras":{
     * "orderNo":"htl1603763358619",
     * "orderType":"2", orderType AIR(1,"机票"),HOTEL(2,"酒店"),TRAIN(3,"火车票"),CAR(4,"专车"),
     * "pushType":"1"
     *     },
     *     "title":"发起退款 "
     * ,
     *     "userIdList":[
     *         "12050"
     *     ]
     * }
     */
    private String id;//消息标题
    private String title;//显示标题
    private String orderType;//
    private String orderNo;//订单号
    private String pushType;//pushType:1订单推送

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return orderType;
    }

    public void setType(String type) {
        this.orderType = type;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }
}
