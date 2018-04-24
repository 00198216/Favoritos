package com.example.charl.favoritos;

public class Series {

    private String name;
    private String cap;
    private int img;
    private String desc;

    public Series(String name, String caps, int img, String desc) {
        this.name = name;
        this.cap = caps;
        this.img = img;
        this.desc = desc;
    }

    public String getName() {
        return name;
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
