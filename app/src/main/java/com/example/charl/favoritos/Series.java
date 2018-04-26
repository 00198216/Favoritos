package com.example.charl.favoritos;

import java.io.Serializable;

public class Series implements Serializable {

    private String name;
    private String cap;
    private int img;
    private String desc;
    private Boolean Check;

    public Series(String name, String caps, int img, String desc) {
        this.name = name;
        this.cap = caps;
        this.img = img;
        this.desc = desc;

    }

    public String getCap() {
        return cap;
    }

    public Boolean getCheck() {
        return Check;
    }

    public String getName() {
        return name;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public void setCheck(Boolean check) {
        Check = check;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaps() {
        return cap;
    }

    public void setCaps(String caps) {
        this.cap = caps;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
