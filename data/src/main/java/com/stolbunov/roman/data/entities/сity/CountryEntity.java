package com.stolbunov.roman.data.entities.сity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryEntity {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("name_ua")
    @Expose
    private String nameUa;
    @SerializedName("cities")
    @Expose
    private List<CityEntity> cities = null;

    public String getName() {
        return name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameUa() {
        return nameUa;
    }

    public List<CityEntity> getCities() {
        return cities;
    }
}
