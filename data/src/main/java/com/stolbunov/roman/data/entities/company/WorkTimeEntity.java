package com.stolbunov.roman.data.entities.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkTimeEntity {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_ua")
    @Expose
    private String nameUa;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("alias")
    @Expose
    private String alias;
    @SerializedName("from")
    @Expose
    private String from;
    @SerializedName("to")
    @Expose
    private String to;
    @SerializedName("is_day_off")
    @Expose
    private Integer isDayOff;

    public String getName() {
        return name;
    }

    public String getNameUa() {
        return nameUa;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getAlias() {
        return alias;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Integer getIsDayOff() {
        return isDayOff;
    }
}
