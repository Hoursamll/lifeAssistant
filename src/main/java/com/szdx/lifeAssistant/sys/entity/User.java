package com.szdx.lifeAssistant.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by shizhicheng on 2018/3/30.
 */
//会员管理，商场活动信息管理，生活百科知识
public class User extends Base{
    private String userName;
    private String phone;
    private String passWord;
    private String eamil;
    private String type;
    private String headImg;
    private BigDecimal price;
    private Date startTime;
    private Date endTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", passWord='" + passWord + '\'' +
                ", eamil='" + eamil + '\'' +
                ", type='" + type + '\'' +
                ", headImg='" + headImg + '\'' +
                ", price=" + price +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
