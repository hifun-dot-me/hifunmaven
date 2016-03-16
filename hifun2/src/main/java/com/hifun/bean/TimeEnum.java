package com.hifun.bean;

public enum TimeEnum {

	TIME("yyyy-MM-dd HH:mm:ss"), DATE("yyyy-MM-dd");
    private String format;

    private TimeEnum(String format) {
        this.format = format;
    }

    public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
	public static void main(String[] args) {
		System.out.println(TimeEnum.TIME.getFormat());
	}

}
