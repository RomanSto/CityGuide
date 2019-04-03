package com.stolbunov.roman.data.repository.lovecity_api;

import com.stolbunov.roman.data.entities.category.CategoryResponseBody;
import com.stolbunov.roman.data.entities.company.OrganizationResponseBody;
import com.stolbunov.roman.data.entities.сity.CityResponseBody;
import com.stolbunov.roman.data.entities.company.OrganizationEntity;
import com.stolbunov.roman.data.entities.company.OrganizationsResponseBody;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ILovecityHolderApi {

    @GET("cities")
    Call<CityResponseBody> getCitiesList();

    @GET("cities/{id_city}/categories/{id}/companies")
    Call<OrganizationsResponseBody> getAllOrganizationsByCategory(
            @Path("id_city") int idCity,
            @Path("id") int idOrganizationCategory);

    @GET("cities/{id_city}/companies")
    Call<OrganizationsResponseBody> getAllOrganizationsByCity(
            @Path("id_city") int idCity);

    @GET("companies/{id}")
    Call<OrganizationResponseBody> getOrganizationById(
            @Path("id") int idOrganization);

    @GET("categories/{id}/companies")
    Call<OrganizationsResponseBody> getOrganizationsByCategoryId(
            @Path("id") int idCategory);

    @GET("categories")
    Call<CategoryResponseBody> getCategories();


}
