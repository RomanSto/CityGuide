package com.stolbunov.roman.testandroid.ui.screens.choice_organization.adapter;

import com.stolbunov.roman.testandroid.ui.screens.choice_organization.ChoiceOrganizationListFragment;
import com.stolbunov.roman.testandroid.ui.screens.choice_organization.ChoiceOrganizationMapFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ChoiceOrganizationViewPagerAdapter extends FragmentPagerAdapter {
    private static final int COUNT = 2;
    private static final int MAP_POSITION = 0;
    private static final int LIST_POSITION = 1;

    public ChoiceOrganizationViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == MAP_POSITION) {
            fragment = ChoiceOrganizationMapFragment.newInstance();
        } else if (position == LIST_POSITION) {
            fragment = ChoiceOrganizationListFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return COUNT;
    }
}
