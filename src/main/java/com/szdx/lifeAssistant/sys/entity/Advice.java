package com.szdx.lifeAssistant.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by shizhicheng on 2018/4/1.
 */
public class Advice {
    private String advicePerson;//建议人
    private Date adviceDate;//提出日期
    private String phone;//联系电话
    private String adviceTitle;//题目
    private String adviceBefore;//改善前
    private String adviceAfter;//改善后
    private String adviceResult;//预期效果
    private String id;
    private String number;
    private Date createTime;

    public String getAdvicePerson() {
        return advicePerson;
    }

    public void setAdvicePerson(String advicePerson) {
        this.advicePerson = advicePerson;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getAdviceDate() {
        return adviceDate;
    }

    public void setAdviceDate(Date adviceDate) {
        this.adviceDate = adviceDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdviceTitle() {
        return adviceTitle;
    }

    public void setAdviceTitle(String adviceTitle) {
        this.adviceTitle = adviceTitle;
    }

    public String getAdviceBefore() {
        return adviceBefore;
    }

    public void setAdviceBefore(String adviceBefore) {
        this.adviceBefore = adviceBefore;
    }

    public String getAdviceAfter() {
        return adviceAfter;
    }

    public void setAdviceAfter(String adviceAfter) {
        this.adviceAfter = adviceAfter;
    }

    public String getAdviceResult() {
        return adviceResult;
    }

    public void setAdviceResult(String adviceResult) {
        this.adviceResult = adviceResult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
