package com.stolbunov.roman.testandroid.utils.mapper;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.stolbunov.roman.domain.entity.Category;
import com.stolbunov.roman.domain.entity.organization.OrganizationMinInfo;
import com.stolbunov.roman.testandroid.entity.CategoryForAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Mapper {
    private Mapper() {
    }

    public static List<CategoryForAdapter> transformToCategoryForAdapterList(
            List<Category> categories,
            List<OrganizationMinInfo> organizations) {

        List<CategoryForAdapter> result = Collections.emptyList();

        if (categories != null && organizations != null) {
            result = new ArrayList<>(categories.size());
            for (Category category : categories) {
                result.add(createCategoryForAdapter(category, organizations));
            }
        }
        return result;
    }

    private static CategoryForAdapter createCategoryForAdapter(Category category,
                                                               List<OrganizationMinInfo> organizations) {
        return new CategoryForAdapter(
                category.getId(),
                category.getName(),
                category.getIsActive(),
                category.getNameEn(),
                category.getNameUa(),
                getOrganizationsByCategoryId(organizations, category.getId()));
    }

    private static List<OrganizationMinInfo> getOrganizationsByCategoryId(List<OrganizationMinInfo> organizations,
                                                                          int idCategory) {
        List<OrganizationMinInfo> organizationList = new ArrayList<>();
        for (OrganizationMinInfo organization : organizations) {
            if (idCategory == organization.getCategoryId()) {
                organizationList.add(organization);
            }
        }
        return organizationList;
    }

    public static List<MarkerOptions> transformToMapMarkers(List<OrganizationMinInfo> organizationMinInfo) {
        List<MarkerOptions> result = new ArrayList<>(organizationMinInfo.size());

        for (OrganizationMinInfo organization : organizationMinInfo) {
            result.add(createMarkerOptions(organization));
        }
        return result;
    }

    private static MarkerOptions createMarkerOptions(OrganizationMinInfo organization) {
        MarkerOptions result = new MarkerOptions();
        result.position(new LatLng(organization.getLatitude(), organization.getLongitude()));
        result.title(organization.getNameEn());
        return result;
    }

}