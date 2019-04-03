package com.stolbunov.roman.data.entities.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stolbunov.roman.domain.entity.organization.WorkTime;

import java.util.List;

public class OrganizationMinInfoEntity {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("owner_id")
    @Expose
    private int ownerId;
    @SerializedName("category_id")
    @Expose
    private int categoryId;
    @SerializedName("trc_id")
    @Expose
    private Object trcId;
    @SerializedName("city_id")
    @Expose
    private int cityId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("subcategory")
    @Expose
    private String subcategory;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("site")
    @Expose
    private Object site;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("discount")
    @Expose
    private String discount;
    @SerializedName("is_active")
    @Expose
    private int isActive;
    @SerializedName("keywords")
    @Expose
    private String keywords;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("name_ua")
    @Expose
    private String nameUa;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("subcategory_en")
    @Expose
    private String subcategoryEn;
    @SerializedName("subcategory_ua")
    @Expose
    private String subcategoryUa;
    @SerializedName("address_ua")
    @Expose
    private String addressUa;
    @SerializedName("address_en")
    @Expose
    private String addressEn;
    @SerializedName("description_en")
    @Expose
    private String descriptionEn;
    @SerializedName("description_ua")
    @Expose
    private String descriptionUa;
    @SerializedName("fb")
    @Expose
    private String fb;
    @SerializedName("instagram")
    @Expose
    private String instagram;
    @SerializedName("has_share")
    @Expose
    private int hasShare;
    @SerializedName("work_time")
    @Expose
    private List<WorkTime> workTime = null;

    public int getId() {
        return id;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public Object getTrcId() {
        return trcId;
    }

    public int getCityId() {
        return cityId;
    }

    public String getName() {
        return name;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public String getAddress() {
        return address;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getPhone() {
        return phone;
    }

    public Object getSite() {
        return site;
    }

    public String getDescription() {
        return description;
    }

    public String getDiscount() {
        return discount;
    }

    public int getIsActive() {
        return isActive;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getType() {
        return type;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getNameUa() {
        return nameUa;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getSubcategoryEn() {
        return subcategoryEn;
    }

    public String getSubcategoryUa() {
        return subcategoryUa;
    }

    public String getAddressUa() {
        return addressUa;
    }

    public String getAddressEn() {
        return addressEn;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

    public String getDescriptionUa() {
        return descriptionUa;
    }

    public String getFb() {
        return fb;
    }

    public String getInstagram() {
        return instagram;
    }

    public int getHasShare() {
        return hasShare;
    }

    public List<WorkTime> getWorkTime() {
        return workTime;
    }
}
