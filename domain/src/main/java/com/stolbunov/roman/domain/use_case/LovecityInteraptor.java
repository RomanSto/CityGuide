package com.stolbunov.roman.domain.use_case;

import android.net.Uri;

import com.stolbunov.roman.domain.entity.Category;
import com.stolbunov.roman.domain.entity.Country;
import com.stolbunov.roman.domain.entity.organization.Organization;
import com.stolbunov.roman.domain.entity.organization.OrganizationMinInfo;
import com.stolbunov.roman.domain.repository.IAppPreferencesRepository;
import com.stolbunov.roman.domain.repository.ILovecityRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class LovecityInteraptor implements ILovecityUseCase, IAppPreferencesUseCase {
    private final ILovecityRepository repository;
    private final IAppPreferencesRepository preferencesRepository;

    @Inject
    public LovecityInteraptor(ILovecityRepository repository,
                              IAppPreferencesRepository preferencesRepository) {
        this.repository = repository;
        this.preferencesRepository = preferencesRepository;
    }

    @Override
    public Single<List<Country>> getCitiesList() {
        return repository.getCitiesList();
    }

    @Override
    public Single<List<OrganizationMinInfo>> getOrganizations(int idCity, int idCategory) {
        return repository.getOrganizations(idCity, idCategory);
    }

    @Override
    public Single<List<OrganizationMinInfo>> getOrganizationsByCity(int idCity) {
        return repository.getOrganizationsByCityId(idCity);
    }

    @Override
    public Single<Organization> getOrganizationById(int idOrganization) {
        return repository.getOrganizationById(idOrganization);
    }

    @Override
    public Single<List<OrganizationMinInfo>> getOrganizationsByCategoryId(int idCategory) {
        return repository.getOrganizationsByCategoryId(idCategory);
    }

    @Override
    public Single<List<Category>> getCategories() {
        return repository.getCategories();
    }

    @Override
    public Completable saveUserIconPath(Uri uri) {
        return preferencesRepository.saveUserIconPath(uri);
    }

    @Override
    public Single<Uri> getUserIconPath() {
        return preferencesRepository.getUserIconPath();
    }
}
