package com.szdx.lifeAssistant.sys.entity;

import java.util.Date;

/**
 * Created by shizhicheng on 2018/4/1.
 */
public class Shop extends Base{
    private String title;
    private Date createTime;
    private Date startDate;
    private Date endDate;
    private String imgUrl;
    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "title='" + title + '\'' +
                ", createTime=" + createTime +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", imgUrl='" + imgUrl + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
