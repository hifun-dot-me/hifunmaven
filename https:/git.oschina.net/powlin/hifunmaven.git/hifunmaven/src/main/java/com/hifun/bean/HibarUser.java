package com.hifun.bean;

import java.util.Date;

public class HibarUser {

    private Integer id;

    private String username;

    private Date firstPostTime;

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

    public Date getFirstPostTime() {
        return firstPostTime;
    }

    public void setFirstPostTime(Date firstPostTime) {
        this.firstPostTime = firstPostTime;
    }

}
