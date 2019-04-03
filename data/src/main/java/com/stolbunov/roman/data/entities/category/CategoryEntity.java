package com.stolbunov.roman.data.entities.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryEntity {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("is_active")
    @Expose
    private int isActive;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("name_ua")
    @Expose
    private String nameUa;

    public CategoryEntity(int id, String name, int isActive, String nameEn, String nameUa) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.nameEn = nameEn;
        this.nameUa = nameUa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIsActive() {
        return isActive;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameUa() {
        return nameUa;
    }
}
