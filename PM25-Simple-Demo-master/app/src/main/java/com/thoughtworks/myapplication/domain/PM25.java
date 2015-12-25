package com.thoughtworks.myapplication.domain;

import com.google.gson.annotations.SerializedName;

public class PM25 {
    @SerializedName("position_name")
    private String positionName;

    @SerializedName("quality")
    private String quality;

    @SerializedName("pm2_5_24h")
    private String pm2_5_24h;

    @SerializedName("area")
    private String area;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPm2_5_24h() {
        return pm2_5_24h;
    }

    public void setPm2_5_24h(String pm2_5_24h) {
        this.pm2_5_24h = pm2_5_24h;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
