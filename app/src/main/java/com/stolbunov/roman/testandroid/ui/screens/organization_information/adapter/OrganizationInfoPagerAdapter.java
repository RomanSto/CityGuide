package com.stolbunov.roman.testandroid.ui.screens.organization_information.adapter;

import com.stolbunov.roman.domain.entity.organization.Picture;
import com.stolbunov.roman.testandroid.binding_adapters.IDataAdapter;
import com.stolbunov.roman.testandroid.ui.screens.organization_information.OrganizationInfoImageItemFragment;

import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class OrganizationInfoPagerAdapter extends FragmentPagerAdapter implements IDataAdapter {
    private List<Picture> imagesUri;

    public OrganizationInfoPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        imagesUri = Collections.emptyList();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return OrganizationInfoImageItemFragment.newInstance(
                imagesUri.get(position).getImage(),
                position);
    }

    @Override
    public int getCount() {
        return imagesUri.size();
    }

    @Override
    public <T> void setData(List<T> data) {
        imagesUri = (List<Picture>) data;
        notifyDataSetChanged();
    }
}
