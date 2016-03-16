package com.hifun.bean;

import com.hifun.util.DateUtil;

public class HiPlayground {

    private Integer id;

    private String username; // 用户名

    private String nickname;// 昵称

    private int shopId;// 商家ID

    private String shopName;// 商家名称

    private String shopDesc;// 商家描述

    private String shopAddr;// 商家地址

    private int status;// 审核状态

    private String statusName;// 审核状态名称

    private String remark;// 备注

    private String updateTime;// 更新时间

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

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    public String getShopAddr() {
        return shopAddr;
    }

    public void setShopAddr(String shopAddr) {
        this.shopAddr = shopAddr;
    }

}
