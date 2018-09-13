package com.szdx.lifeAssistant.common.persistence.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by shizhicheng on 2018/4/19.
 */
public abstract class Entity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 实体编号（唯一标识） */
    protected String id;

    protected String number;

    protected Date createDate;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
