package com.hifun.bean;

import java.util.Date;

import com.hifun.bean.data.TimeEnum;
import com.hifun.util.DateUtil;

public class ApplyFriend {

    private Integer id;

    private String applyTo;// 申请至

    private String applyTime;// 申请时间

    private int applyStatus;// 申请状态

    private Date passTime;// 通过时间

    private String username;// 申请人

    private String nickname;// 昵称

    private String remark;// 备注

    // 辅助字段
    private String fusername;// 好友名（用户名）

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApplyTo() {
        return applyTo;
    }

    public void setApplyTo(String applyTo) {
        this.applyTo = applyTo;
    }

    public String getApplyTime() {
        if (applyTime != null) {
            applyTime = DateUtil.getTimeString(DateUtil.getTimeDate(applyTime),
                TimeEnum.TIME.getFormat());
        }
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public int getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Date getPassTime() {
        return passTime;
    }

    public void setPassTime(Date passTime) {
        this.passTime = passTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getFusername() {
        return fusername;
    }

    public void setFusername(String fusername) {
        this.fusername = fusername;
    }

}
