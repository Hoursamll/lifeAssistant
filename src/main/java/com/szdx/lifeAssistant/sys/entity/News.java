package com.szdx.lifeAssistant.sys.entity;

import java.util.Date;

/**
 * Created by shizhicheng on 2018/4/16.
 */
public class News extends Base{
    private String title;
    private String message;
    private Date createTime;
    private String imgUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", createTime=" + createTime +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
