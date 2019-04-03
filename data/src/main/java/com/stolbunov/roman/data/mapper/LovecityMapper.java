package com.stolbunov.roman.data.mapper;

import com.stolbunov.roman.data.entities.category.CategoryEntity;
import com.stolbunov.roman.data.entities.category.CategoryResponseBody;
import com.stolbunov.roman.data.entities.company.OrganizationEntity;
import com.stolbunov.roman.data.entities.company.OrganizationMinInfoEntity;
import com.stolbunov.roman.data.entities.company.OrganizationResponseBody;
import com.stolbunov.roman.data.entities.company.OrganizationsResponseBody;
import com.stolbunov.roman.data.entities.company.PictureEntity;
import com.stolbunov.roman.data.entities.company.ShareEntity;
import com.stolbunov.roman.data.entities.company.WorkTimeEntity;
import com.stolbunov.roman.data.entities.сity.CityEntity;
import com.stolbunov.roman.data.entities.сity.CityResponseBody;
import com.stolbunov.roman.data.entities.сity.CountryEntity;
import com.stolbunov.roman.domain.entity.Category;
import com.stolbunov.roman.domain.entity.City;
import com.stolbunov.roman.domain.entity.Country;
import com.stolbunov.roman.domain.entity.organization.Organization;
import com.stolbunov.roman.domain.entity.organization.OrganizationMinInfo;
import com.stolbunov.roman.domain.entity.organization.Picture;
import com.stolbunov.roman.domain.entity.organization.Share;
import com.stolbunov.roman.domain.entity.organization.WorkTime;

import java.util.ArrayList;
import java.util.List;

public final class LovecityMapper {
    private LovecityMapper() {
    }

    public static List<Category> transformToCategory(CategoryResponseBody categoryResponseBody) {
        List<Category> result = new ArrayList<>(categoryResponseBody.getData().size());
        for (CategoryEntity entity : categoryResponseBody.getData()) {
            result.add(new Category(
                    entity.getId(),
                    entity.getName(),
                    entity.getIsActive(),
                    entity.getNameEn(),
                    entity.getNameUa()));
        }
        return result;
    }

    public static List<Country> transformToCountryList(CityResponseBody cityResponseBody) {
        List<Country> result = new ArrayList<>(cityResponseBody.getData().size());
        for (CountryEntity countryEntity : cityResponseBody.getData()) {
            result.add(new Country(
                    countryEntity.getName(),
                    countryEntity.getNameEn(),
                    countryEntity.getNameUa(),
                    createCities(countryEntity)));
        }
        return result;
    }

    public static List<OrganizationMinInfo> transformToOrganizationList(OrganizationsResponseBody organizationsResponseBody) {
        List<OrganizationMinInfoEntity> data = organizationsResponseBody.getData();
        List<OrganizationMinInfo> result = new ArrayList<>(data.size());

        for (OrganizationMinInfoEntity entity : organizationsResponseBody.getData()) {
            result.add(transformToOrganizationMinInfo(entity));
        }
        return result;
    }

    public static Organization transformToOrganization(OrganizationResponseBody organizationResponseBody) {
        return transformToOrganization(organizationResponseBody.getData());
    }

    private static OrganizationMinInfo transformToOrganizationMinInfo(OrganizationMinInfoEntity entity) {
        return new OrganizationMinInfo(
                entity.getId(),
                entity.getOwnerId(),
                entity.getCategoryId(),
                entity.getTrcId(),
                entity.getCityId(),
                entity.getName(),
                entity.getSubcategory(),
                entity.getAddress(),
                entity.getLongitude(),
                entity.getLatitude(),
                entity.getPhone(),
                entity.getSite(),
                entity.getDescription(),
                entity.getDiscount(),
                entity.getIsActive(),
                entity.getKeywords(),
                entity.getType(),
                entity.getUpdatedAt(),
                entity.getCreatedAt(),
                entity.getNameUa(),
                entity.getNameEn(),
                entity.getSubcategoryEn(),
                entity.getSubcategoryUa(),
                entity.getAddressUa(),
                entity.getAddressEn(),
                entity.getDescriptionEn(),
                entity.getDescriptionUa(),
                entity.getFb(),
                entity.getInstagram(),
                entity.getHasShare());
    }

    private static Organization transformToOrganization(OrganizationEntity organizationEntity) {
        return new Organization(
                organizationEntity.getId(),
                organizationEntity.getOwnerId(),
                organizationEntity.getCategoryId(),
                organizationEntity.getTrcId(),
                organizationEntity.getCityId(),
                organizationEntity.getName(),
                organizationEntity.getSubcategory(),
                organizationEntity.getAddress(),
                organizationEntity.getLongitude(),
                organizationEntity.getLatitude(),
                organizationEntity.getPhone(),
                organizationEntity.getSite(),
                organizationEntity.getDescription(),
                organizationEntity.getDiscount(),
                organizationEntity.getIsActive(),
                organizationEntity.getKeywords(),
                organizationEntity.getType(),
                organizationEntity.getUpdatedAt(),
                organizationEntity.getCreatedAt(),
                organizationEntity.getNameUa(),
                organizationEntity.getNameEn(),
                organizationEntity.getSubcategoryEn(),
                organizationEntity.getSubcategoryUa(),
                organizationEntity.getAddressUa(),
                organizationEntity.getAddressEn(),
                organizationEntity.getDescriptionEn(),
                organizationEntity.getDescriptionUa(),
                organizationEntity.getFb(),
                organizationEntity.getInstagram(),
                transformToWorkTime(organizationEntity.getWorkTime()),
                transformToPicture(organizationEntity.getPictureEntities()),
                transformToShare(organizationEntity.getShareEntities()),
                organizationEntity.getConditions());
    }

    private static List<WorkTime> transformToWorkTime(List<WorkTimeEntity> workTime) {
        List<WorkTime> result = new ArrayList<>(workTime.size());

        for (WorkTimeEntity entity : workTime) {
            result.add(createWorkTime(entity));
        }
        return result;
    }

    private static List<Picture> transformToPicture(List<PictureEntity> pictureEntities) {
        List<Picture> result = new ArrayList<>(pictureEntities.size());
        for (PictureEntity entity : pictureEntities) {
            result.add(createPicture(entity));
        }
        return result;
    }

    private static List<Share> transformToShare(List<ShareEntity> shareEntities) {
        List<Share> result = new ArrayList<>(shareEntities.size());

        for (ShareEntity entity : shareEntities) {
            result.add(createShare(entity));
        }
        return result;
    }

    private static WorkTime createWorkTime(WorkTimeEntity entity) {
        return new WorkTime(
                entity.getName(),
                entity.getNameUa(),
                entity.getNameEn(),
                entity.getAlias(),
                entity.getFrom(),
                entity.getTo(),
                entity.getIsDayOff());
    }

    private static Picture createPicture(PictureEntity entity) {
        return new Picture(entity.getImage());
    }

    private static Share createShare(ShareEntity entity) {
        return new Share(
                entity.getName(),
                entity.getNameEn(),
                entity.getNameUa(),
                entity.getDescription(),
                entity.getDescriptionEn(),
                entity.getDescriptionUa());
    }

    private static List<City> createCities(CountryEntity countryEntity) {
        List<City> cities = new ArrayList<>(countryEntity.getCities().size());
        for (CityEntity cityEntity : countryEntity.getCities()) {
            cities.add(new City(
                    cityEntity.getId(),
                    cityEntity.getName(),
                    cityEntity.getNameEn(),
                    cityEntity.getNameUa()));
        }
        return cities;
    }
}
