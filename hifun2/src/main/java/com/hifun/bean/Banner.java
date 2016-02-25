package com.hifun.bean;

/**
 * Banner对象
 * @author: yuexia 
 * @since: 2016年1月21日 下午9:04:26 
 * @history:
 */
public class Banner {

    private Integer id; // 主键

    private String title; // 标题

    private String path; // 路径

    private int linkType;// 链接类型

    private String linkTo;// 跳转链接

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getLinkType() {
        return linkType;
    }

    public void setLinkType(int linkType) {
        this.linkType = linkType;
    }

    public String getLinkTo() {
        return linkTo;
    }

    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo;
    }

}
