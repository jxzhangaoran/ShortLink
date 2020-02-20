package com.Pojo;

public class LinkMap {
    private Long no;
    private String shortlink;
    private String originlink;

    public LinkMap(Long no, String shortlink, String originlink) {
        this.no = no;
        this.shortlink = shortlink;
        this.originlink = originlink;
    }

    public LinkMap() {
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getShortlink() {
        return shortlink;
    }

    public void setShortlink(String shortlink) {
        this.shortlink = shortlink;
    }

    public String getOriginlink() {
        return originlink;
    }

    public void setOriginlink(String originlink) {
        this.originlink = originlink;
    }

    @Override
    public String toString() {
        return "LinkMap{" +
                "shortlink='" + shortlink + '\'' +
                '}';
    }
}
/*
* mysql无符号整型数据范围：0 - 4294967295
* */