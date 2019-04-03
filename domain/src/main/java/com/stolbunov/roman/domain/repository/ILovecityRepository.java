package com.stolbunov.roman.domain.repository;

import com.stolbunov.roman.domain.entity.Category;
import com.stolbunov.roman.domain.entity.Country;
import com.stolbunov.roman.domain.entity.organization.Organization;
import com.stolbunov.roman.domain.entity.organization.OrganizationMinInfo;

import java.util.List;

import io.reactivex.Single;

public interface ILovecityRepository {
    Single<List<Country>> getCitiesList();

    Single<List<OrganizationMinInfo>> getOrganizations(int idCity, int idCategory);

    Single<List<OrganizationMinInfo>> getOrganizationsByCityId(int idCity);

    Single<Organization> getOrganizationById(int idOrganization);

    Single<List<OrganizationMinInfo>> getOrganizationsByCategoryId(int idCategory);

    Single<List<Category>> getCategories();
}
