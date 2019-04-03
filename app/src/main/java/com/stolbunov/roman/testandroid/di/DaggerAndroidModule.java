package com.stolbunov.roman.testandroid.di;

import com.stolbunov.roman.testandroid.di.scope.ActivityScope;
import com.stolbunov.roman.testandroid.di.scope.FragmentScope;
import com.stolbunov.roman.testandroid.ui.screens.choice_category.ChoiceCategoryActivity;
import com.stolbunov.roman.testandroid.ui.screens.choice_category.ChoiceCategoryFragment;
import com.stolbunov.roman.testandroid.ui.screens.choice_city.ChoiceCityActivity;
import com.stolbunov.roman.testandroid.ui.screens.choice_city.ChoiceCityFragment;
import com.stolbunov.roman.testandroid.ui.screens.choice_organization.ChoiceOrganizationActivity;
import com.stolbunov.roman.testandroid.ui.screens.choice_organization.ChoiceOrganizationListFragment;
import com.stolbunov.roman.testandroid.ui.screens.choice_organization.ChoiceOrganizationMapFragment;
import com.stolbunov.roman.testandroid.ui.screens.organization_information.OrganizationInfoImageItemFragment;
import com.stolbunov.roman.testandroid.ui.screens.organization_information.OrganizationInfoImageFragment;
import com.stolbunov.roman.testandroid.ui.screens.show_image_organization.ShowImageOrganizationFragment;
import com.stolbunov.roman.testandroid.ui.screens.show_image_organization.ShowImageOrganizationActivity;
import com.stolbunov.roman.testandroid.ui.screens.show_image_organization.ShowImageOrganizationItemFragment;
import com.stolbunov.roman.testandroid.ui.screens.organization_information.OrganizationInfoActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Module(includes = AndroidSupportInjectionModule.class)
public interface DaggerAndroidModule {

    @ActivityScope
    @ContributesAndroidInjector
    ChoiceCityActivity chooseCityActivity();

    @FragmentScope
    @ContributesAndroidInjector
    ChoiceCityFragment choiceCityFragment();

    @ActivityScope
    @ContributesAndroidInjector
    ChoiceCategoryActivity choiceCategoryActivity();

    @ActivityScope
    @ContributesAndroidInjector
    ChoiceCategoryFragment choiceCategoryFragment();

    @ActivityScope
    @ContributesAndroidInjector
    ChoiceOrganizationActivity choiceOrganizationActivity();

    @FragmentScope
    @ContributesAndroidInjector
    ChoiceOrganizationListFragment choiceOrganizationListFragment();

    @FragmentScope
    @ContributesAndroidInjector
    ChoiceOrganizationMapFragment choiceOrganizationMapFragment();

    @ActivityScope
    @ContributesAndroidInjector
    OrganizationInfoActivity organizationInfoActivity();

    @FragmentScope
    @ContributesAndroidInjector
    ShowImageOrganizationItemFragment imageCompanyFragment();

    @ActivityScope
    @ContributesAndroidInjector
    ShowImageOrganizationActivity showImageOrganizationActivity();

    @FragmentScope
    @ContributesAndroidInjector
    ShowImageOrganizationFragment containerImageOrganizationFragment();

    @FragmentScope
    @ContributesAndroidInjector
    OrganizationInfoImageItemFragment imageOrganizationFragment();

    @FragmentScope
    @ContributesAndroidInjector
    OrganizationInfoImageFragment imageOrganizationInfoFragment();
}
