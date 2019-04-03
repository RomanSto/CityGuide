package com.stolbunov.roman.domain.entity.organization;

public class Share {
    private final String name;
    private final String nameEn;
    private final String nameUa;
    private final String description;
    private final String descriptionEn;
    private final String descriptionUa;

    public Share(String name, String nameEn, String nameUa, String description, String descriptionEn, String descriptionUa) {
        this.name = name;
        this.nameEn = nameEn;
        this.nameUa = nameUa;
        this.description = description;
        this.descriptionEn = descriptionEn;
        this.descriptionUa = descriptionUa;
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
