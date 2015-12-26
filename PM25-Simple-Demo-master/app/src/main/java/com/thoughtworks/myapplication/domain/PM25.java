package com.thoughtworks.myapplication.domain;

import com.google.gson.annotations.SerializedName;

public class PM25 {
    @SerializedName("area")
    private String area;

    @SerializedName("quality")
    private String quality;




    public String getArea() {
        return area;
    }

    public void setArea(String positionName) {
        this.area = positionName;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
