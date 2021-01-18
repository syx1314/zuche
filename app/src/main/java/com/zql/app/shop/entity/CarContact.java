package com.zql.app.shop.entity;

import com.zql.app.lib.entity.BaseBean;

/**
 * 预约用车
 * 接送机   乘车联系人  几个模块公用，联系人选择弹框
 * Created by yyj on 2018/1/27.
 */

public class CarContact extends BaseBean {
    private String certNo;//证件id ,
    private int certType;// 证件类型 ,
    private String email;//邮件地址 ,
    private String name;//名称 ,
    private String parId;// parId ,
    private String phone;//电话

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public void setCertType(int certType) {
        this.certType = certType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParId() {
        return parId;
    }

    public void setParId(String parId) {
        this.parId = parId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarContact that = (CarContact) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (parId != null ? !parId.equals(that.parId) : that.parId != null) return false;
        return phone != null ? phone.equals(that.phone) : that.phone == null;
    }

}
