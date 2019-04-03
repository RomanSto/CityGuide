package com.stolbunov.roman.testandroid.ui.screens.show_image_organization;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stolbunov.roman.domain.entity.organization.Picture;
import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.FragmentShowImageOrganizationBinding;
import com.stolbunov.roman.testandroid.ui.screens.show_image_organization.adapter.ShowImageOrganizationPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import dagger.android.support.DaggerFragment;

public class ShowImageOrganizationFragment extends DaggerFragment implements ViewPager.OnPageChangeListener {
    private static final String KEY_SELECTED_IMAGE_POSITION = "KEY_SELECTED_IMAGE_POSITION";
    private static final String KEY_IMAGE_LIST_URI = "KEY_IMAGE_LIST_URI";
    private OnPageSelectedListener listener;

    public static ShowImageOrganizationFragment newInstance(int position, ArrayList<Picture> uriImage) {
        ShowImageOrganizationFragment fragment = new ShowImageOrganizationFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_SELECTED_IMAGE_POSITION, position);
        args.putParcelableArrayList(KEY_IMAGE_LIST_URI, uriImage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPageSelectedListener) {
            listener = (OnPageSelectedListener) context;
        } else {
            throw new ClassCastException("Implement OnPageSelectedListener");
        }
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnPageSelectedListener) {
            listener = (OnPageSelectedListener) activity;
        } else {
            throw new ClassCastException("Implement OnPageSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentShowImageOrganizationBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_show_image_organization,
                container,
                false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            int position = arguments.getInt(KEY_SELECTED_IMAGE_POSITION, 0);
            List<Picture> uri = arguments.getParcelableArrayList(KEY_IMAGE_LIST_URI);
            initViewPager(binding, position, uri);
        }
        return binding.getRoot();
    }

    private void initViewPager(FragmentShowImageOrganizationBinding binding,
                               int position, List<Picture> uri) {

        ShowImageOrganizationPagerAdapter adapter =
                new ShowImageOrganizationPagerAdapter(getChildFragmentManager());
        adapter.setData(uri);
        binding.imageViewPager.setAdapter(adapter);
        binding.imageViewPager.setCurrentItem(position);
        binding.imageViewPager.addOnPageChangeListener(this);
        binding.imageIndicator.setViewPager(binding.imageViewPager);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (listener != null) {
            listener.onPageSelected(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public interface OnPageSelectedListener {
        void onPageSelected(int position);
    }
}
