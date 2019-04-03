package com.stolbunov.roman.domain.entity.organization;

import java.util.List;

public class OrganizationMinInfo {
    private final int id;
    private final int ownerId;
    private final int categoryId;
    private final Object trcId;
    private final int cityId;
    private final String name;
    private final String subcategory;
    private final String address;
    private final double longitude;
    private final double latitude;
    private final String phone;
    private final Object site;
    private final String description;
    private final String discount;
    private final int isActive;
    private final String keywords;
    private final String type;
    private final String updatedAt;
    private final String createdAt;
    private final String nameUa;
    private final String nameEn;
    private final String subcategoryEn;
    private final String subcategoryUa;
    private final String addressUa;
    private final String addressEn;
    private final String descriptionEn;
    private final String descriptionUa;
    private final String fb;
    private final String instagram;
    private final int hasShare;
    private final List<WorkTime> workTime = null;

    public OrganizationMinInfo(int id, int ownerId, int categoryId, Object trcId, int cityId,
                               String name, String subcategory, String address, double longitude,
                               double latitude, String phone, Object site, String description,
                               String discount, int isActive, String keywords, String type,
                               String updatedAt, String createdAt, String nameUa, String nameEn,
                               String subcategoryEn, String subcategoryUa, String addressUa,
                               String addressEn, String descriptionEn, String descriptionUa,
                               String fb, String instagram, int hasShare) {
        this.id = id;
        this.ownerId = ownerId;
        this.categoryId = categoryId;
        this.trcId = trcId;
        this.cityId = cityId;
        this.name = name;
        this.subcategory = subcategory;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phone = phone;
        this.site = site;
        this.description = description;
        this.discount = discount;
        this.isActive = isActive;
        this.keywords = keywords;
        this.type = type;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.nameUa = nameUa;
        this.nameEn = nameEn;
        this.subcategoryEn = subcategoryEn;
        this.subcategoryUa = subcategoryUa;
        this.addressUa = addressUa;
        this.addressEn = addressEn;
        this.descriptionEn = descriptionEn;
        this.descriptionUa = descriptionUa;
        this.fb = fb;
        this.instagram = instagram;
        this.hasShare = hasShare;
    }

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
