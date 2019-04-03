package com.stolbunov.roman.data.repository;

import com.stolbunov.roman.data.mapper.LovecityMapper;
import com.stolbunov.roman.data.repository.lovecity_api.LovecityRepository;
import com.stolbunov.roman.domain.entity.Category;
import com.stolbunov.roman.domain.entity.Country;
import com.stolbunov.roman.domain.entity.organization.Organization;
import com.stolbunov.roman.domain.entity.organization.OrganizationMinInfo;
import com.stolbunov.roman.domain.repository.ILovecityRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class RepositoryManager implements ILovecityRepository {
    private final LovecityRepository lovecityRepository;

    @Inject
    public RepositoryManager(LovecityRepository lovecityRepository) {
        this.lovecityRepository = lovecityRepository;
    }

    @Override
    public Single<List<Country>> getCitiesList() {
        return lovecityRepository
                .getCitiesList()
                .map(LovecityMapper::transformToCountryList);
    }

    @Override
    public Single<List<OrganizationMinInfo>> getOrganizations(int idCity, int idCategory) {
        return lovecityRepository
                .getOrganizations(idCity, idCategory)
                .map(LovecityMapper::transformToOrganizationList);
    }

    @Override
    public Single<List<OrganizationMinInfo>> getOrganizationsByCityId(int idCity) {
        return lovecityRepository
                .getOrganizationsByCity(idCity)
                .map(LovecityMapper::transformToOrganizationList);
    }

    @Override
    public Single<Organization> getOrganizationById(int idOrganization) {
        return lovecityRepository
                .getOrganization(idOrganization)
                .map(LovecityMapper::transformToOrganization);
    }

    @Override
    public Single<List<OrganizationMinInfo>> getOrganizationsByCategoryId(int idCategory) {
        return lovecityRepository
                .getOrganizationsByCategoryId(idCategory)
                .map(LovecityMapper::transformToOrganizationList);
    }

    @Override
    public Single<List<Category>> getCategories() {
        return lovecityRepository
                .getCategories()
                .map(LovecityMapper::transformToCategory);
    }
}
