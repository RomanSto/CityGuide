package com.stolbunov.roman.data.entities.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrganizationEntity {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("trc_id")
    @Expose
    private Object trcId;
    @SerializedName("city_id")
    @Expose
    private Integer cityId;
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
    private Double longitude;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
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
    private Integer isActive;
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
    private Object fb;
    @SerializedName("instagram")
    @Expose
    private String instagram;
    @SerializedName("work_time")
    @Expose
    private List<WorkTimeEntity> workTime = null;
    @SerializedName("pictures")
    @Expose
    private List<PictureEntity> pictureEntities = null;
    @SerializedName("shares")
    @Expose
    private List<ShareEntity> shareEntities = null;
    @SerializedName("conditions")
    @Expose
    private List<Object> conditions = null;

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Object getTrcId() {
        return trcId;
    }

    public Integer getCityId() {
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

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
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

    public Integer getIsActive() {
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

    public Object getFb() {
        return fb;
    }

    public String getInstagram() {
        return instagram;
    }

    public List<WorkTimeEntity> getWorkTime() {
        return workTime;
    }

    public List<PictureEntity> getPictureEntities() {
        return pictureEntities;
    }

    public List<ShareEntity> getShareEntities() {
        return shareEntities;
    }

    public List<Object> getConditions() {
        return conditions;
    }
}

