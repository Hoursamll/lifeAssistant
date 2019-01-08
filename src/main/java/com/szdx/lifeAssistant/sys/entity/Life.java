package com.szdx.lifeAssistant.sys.entity;

import java.util.Date;

/**
 * Created by shizhicheng on 2018/4/1.
 */
public class Life extends Base{
    private String imgUrl;
    private String title;
    private Date createTime;
    private String message;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "imgUrl='" + imgUrl + '\'' +
                ", title='" + title + '\'' +
                ", createTime=" + createTime +
                ", message='" + message + '\'' +
                '}';
    }
}
