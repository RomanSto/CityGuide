package com.stolbunov.roman.data.repository.lovecity_api;

import com.stolbunov.roman.data.entities.category.CategoryResponseBody;
import com.stolbunov.roman.data.entities.company.OrganizationEntity;
import com.stolbunov.roman.data.entities.company.OrganizationResponseBody;
import com.stolbunov.roman.data.entities.company.OrganizationsResponseBody;
import com.stolbunov.roman.data.entities.сity.CityResponseBody;
import com.stolbunov.roman.data.utils.RxRetrofit;

import javax.inject.Inject;

import io.reactivex.Single;

public class LovecityRepository {
    private final NetworkService networkService;

    @Inject
    public LovecityRepository(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Single<CityResponseBody> getCitiesList() {
        return RxRetrofit.enqueue(
                networkService
                        .getLovecityApi()
                        .getCitiesList());
    }

    public Single<OrganizationsResponseBody> getOrganizations(int idCity, int idCategory) {
        return RxRetrofit.enqueue(
                networkService
                        .getLovecityApi()
                        .getAllOrganizationsByCategory(idCity, idCategory)
        );
    }

    public Single<OrganizationsResponseBody> getOrganizationsByCity(int idCity) {
        return RxRetrofit.enqueue(
                networkService
                        .getLovecityApi()
                        .getAllOrganizationsByCity(idCity)
        );
    }

    public Single<OrganizationResponseBody> getOrganization(int idOrganization) {
        return RxRetrofit.enqueue(
                networkService
                        .getLovecityApi()
                        .getOrganizationById(idOrganization)
        );
    }

    public Single<OrganizationsResponseBody> getOrganizationsByCategoryId(int idCategory) {
        return RxRetrofit.enqueue(
                networkService
                        .getLovecityApi()
                        .getOrganizationsByCategoryId(idCategory)
        );
    }

    public Single<CategoryResponseBody> getCategories() {
        return RxRetrofit.enqueue(
                networkService
                        .getLovecityApi()
                        .getCategories()
        );
    }
}
