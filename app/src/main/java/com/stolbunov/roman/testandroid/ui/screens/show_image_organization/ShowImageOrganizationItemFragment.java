package com.stolbunov.roman.testandroid.ui.screens.show_image_organization;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.FragmentShowImageOrganizationItemBinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import dagger.android.support.DaggerFragment;

public class ShowImageOrganizationItemFragment extends DaggerFragment {
    private static final String KEY_IMAGES_URI = "KEY_IMAGES_URI";

    public static ShowImageOrganizationItemFragment newInstance(String uri) {
        ShowImageOrganizationItemFragment fragment = new ShowImageOrganizationItemFragment();
        Bundle args = new Bundle();
        args.putString(KEY_IMAGES_URI, uri);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentShowImageOrganizationItemBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_show_image_organization_item,
                container,
                false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String uri = arguments.getString(KEY_IMAGES_URI, "");
            binding.setUri(uri);
        }

        return binding.getRoot();
    }
}
