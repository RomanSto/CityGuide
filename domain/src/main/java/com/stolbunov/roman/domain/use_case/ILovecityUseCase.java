package com.stolbunov.roman.domain.use_case;

import com.stolbunov.roman.domain.entity.Category;
import com.stolbunov.roman.domain.entity.Country;
import com.stolbunov.roman.domain.entity.organization.Organization;
import com.stolbunov.roman.domain.entity.organization.OrganizationMinInfo;

import java.util.List;

import io.reactivex.Single;

public interface ILovecityUseCase {
    Single<List<Country>> getCitiesList();

    Single<List<OrganizationMinInfo>> getOrganizations(int idCity, int idCompanyCategory);

    Single<List<OrganizationMinInfo>> getOrganizationsByCity(int idCity);

    Single<Organization> getOrganizationById(int idOrganization);

    Single<List<OrganizationMinInfo>> getOrganizationsByCategoryId(int idCategory);

    Single<List<Category>> getCategories();
}
