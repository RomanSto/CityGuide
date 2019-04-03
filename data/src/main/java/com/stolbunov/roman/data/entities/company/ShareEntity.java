package com.stolbunov.roman.data.entities.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShareEntity {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("name_ua")
    @Expose
    private String nameUa;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("description_en")
    @Expose
    private String descriptionEn;
    @SerializedName("description_ua")
    @Expose
    private String descriptionUa;

    public String getName() {
        return name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameUa() {
        return nameUa;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public String getDescriptionUa() {
        return descriptionUa;
    }
}
