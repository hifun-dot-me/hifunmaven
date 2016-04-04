package com.hifun.bean.data;

public enum ApplyFriendApplyStatusEnum {

    PASS(2), REJECT(-1), APPLYING(1), DEFAULT(0);
    private ApplyFriendApplyStatusEnum(int applyStatus) {
        this.applyStatus = applyStatus;
    }

    private int applyStatus;

    public int getApplyStatus() {
        return applyStatus;
    }

    public static void main(String[] args) {
        System.out.println(ApplyFriendApplyStatusEnum.PASS.getApplyStatus());
    }
}
