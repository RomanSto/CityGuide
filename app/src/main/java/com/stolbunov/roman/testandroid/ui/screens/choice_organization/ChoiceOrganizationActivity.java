package com.stolbunov.roman.testandroid.ui.screens.choice_organization;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.ActivityChoiceOrganizationBinding;
import com.stolbunov.roman.testandroid.ui.screens.base.OnItemClickListener;
import com.stolbunov.roman.testandroid.ui.screens.choice_organization.adapter.ChoiceOrganizationViewPagerAdapter;
import com.stolbunov.roman.testandroid.ui.screens.organization_information.OrganizationInfoActivity;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import dagger.android.support.DaggerAppCompatActivity;

public class ChoiceOrganizationActivity extends DaggerAppCompatActivity implements OnItemClickListener {
    private static final String KEY_SELECTED_CITY_ID = "KEY_SELECTED_CITY_ID";
    private static final String KEY_SELECTED_CATEGORY_ID = "KEY_SELECTED_CATEGORY_ID";
    private static final int FRAGMENT_MAP_POSITION = 0;
    private static final int FRAGMENT_LIST_POSITION = 1;

    private ViewPager viewPager;
    private ChoiceOrganizationViewModel vm;
    @Inject
    ChoiceOrganizationViewModelFactory factory;

    public static Intent getIntent(Context packageContext, int idCity, int idCategory) {
        Intent intent = new Intent(packageContext, ChoiceOrganizationActivity.class);
        intent.putExtra(KEY_SELECTED_CITY_ID, idCity);
        intent.putExtra(KEY_SELECTED_CATEGORY_ID, idCategory);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vm = ViewModelProviders
                .of(this, factory)
                .get(ChoiceOrganizationViewModel.class);

        ActivityChoiceOrganizationBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_choice_organization);

        vm.setSelectedId(
                getIntent().getIntExtra(KEY_SELECTED_CITY_ID, 0),
                getIntent().getIntExtra(KEY_SELECTED_CATEGORY_ID, 0));

        initView(binding);
    }

    private void initView(ActivityChoiceOrganizationBinding binding) {
        viewPager = binding.organizationViewPager;
        viewPager.setAdapter(new ChoiceOrganizationViewPagerAdapter(getSupportFragmentManager()));

        binding.navigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelectedListener);
    }

    private boolean onNavigationItemSelectedListener(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.navigation_map:
                viewPager.setCurrentItem(FRAGMENT_MAP_POSITION, true);
                return true;
            case R.id.navigation_list:
                viewPager.setCurrentItem(FRAGMENT_LIST_POSITION, true);
                return true;
        }
        return false;
    }

    @Override
    public void onItemClick(int id) {
        Intent intent = OrganizationInfoActivity.getIntent(this, id);
        startActivity(intent);
    }
}
