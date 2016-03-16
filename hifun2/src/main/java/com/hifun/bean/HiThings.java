package com.hifun.bean;

import com.hifun.util.DateUtil;

public class HiThings {

    private Integer id;

    private String username; // 用户名

    private String nickname;// 昵称

    private String content;// 内容

    private int status;// 审核状态

    private String remark;// 备注

    private String updateTime;// 更新时间

    private int zannum;// 赞数

    private int cainum;// 踩数

    private int evaluateTypeId;// 评价类型

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUpdateTime() {
        if (updateTime != null) {
            updateTime = DateUtil.getTimeString(
                DateUtil.getTimeDate(updateTime), TimeEnum.TIME.getFormat());
        }
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getZannum() {
        return zannum;
    }

    public void setZannum(int zannum) {
        this.zannum = zannum;
    }

    public int getCainum() {
        return cainum;
    }

    public void setCainum(int cainum) {
        this.cainum = cainum;
    }

    public int getEvaluateTypeId() {
        return evaluateTypeId;
    }

    public void setEvaluateTypeId(int evaluateTypeId) {
        this.evaluateTypeId = evaluateTypeId;
    }

}
