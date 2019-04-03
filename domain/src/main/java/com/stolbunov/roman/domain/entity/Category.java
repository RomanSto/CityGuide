package com.stolbunov.roman.domain.entity;

public class Category {
    private final int id;
    private final String name;
    private final int isActive;
    private final String nameEn;
    private final String nameUa;

    public Category(int id, String name, int isActive, String nameEn, String nameUa) {
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
