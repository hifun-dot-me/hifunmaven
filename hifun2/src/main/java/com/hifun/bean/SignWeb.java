package com.hifun.bean;

import java.util.Date;

public class SignWeb {

    private Integer id;

    private String username;

    private Date signTime;

    private int signOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public int getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(int signOrder) {
        this.signOrder = signOrder;
    }

}
