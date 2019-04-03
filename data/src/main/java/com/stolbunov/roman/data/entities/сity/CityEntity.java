package com.stolbunov.roman.data.entities.сity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityEntity {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("name_ua")
    @Expose
    private String nameUa;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameUa() {
        return nameUa;
    }
}
