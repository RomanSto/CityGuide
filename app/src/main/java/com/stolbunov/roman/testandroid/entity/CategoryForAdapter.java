package com.stolbunov.roman.testandroid.entity;

import com.stolbunov.roman.domain.entity.organization.OrganizationMinInfo;

import java.util.List;

public class CategoryForAdapter {
    private final int id;
    private final String name;
    private final int isActive;
    private final String nameEn;
    private final String nameUa;
    private final List<OrganizationMinInfo> organizations;

    public CategoryForAdapter(int id, String name, int isActive, String nameEn, String nameUa,
                              List<OrganizationMinInfo> organizations) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.nameEn = nameEn;
        this.nameUa = nameUa;
        this.organizations = organizations;
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

    public List<OrganizationMinInfo> getOrganizations() {
        return organizations;
    }

    public int getNumberOrganizations() {
        return organizations.size();
    }
}
