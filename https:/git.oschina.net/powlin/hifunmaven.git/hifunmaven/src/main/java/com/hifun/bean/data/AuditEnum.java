package com.hifun.bean.data;

public enum AuditEnum {

    Y(1), N(0);
    private int status;

    private AuditEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static void main(String[] args) {
        System.out.println(AuditEnum.Y.getStatus());
    }
}
