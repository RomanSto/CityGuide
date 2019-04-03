package com.stolbunov.roman.testandroid.ui.screens.organization_information;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.FragmentOrganizationInfoImageBinding;
import com.stolbunov.roman.testandroid.ui.screens.base.OnItemClickListener;
import com.stolbunov.roman.testandroid.ui.screens.organization_information.adapter.OrganizationInfoPagerAdapter;

import java.util.Objects;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;

public class OrganizationInfoImageFragment extends DaggerFragment implements OnItemClickListener {
    private OrganizationInfoViewModel vm;
    private OnItemClickListener listener;

    @Inject
    OrganizationInfoViewModelFactory factory;

    public static OrganizationInfoImageFragment newInstance() {
        return new OrganizationInfoImageFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemClickListener) {
            listener = (OnItemClickListener) context;
        } else {
            throw new ClassCastException("Implement OnItemClickListener");
        }
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemClickListener) {
            listener = (OnItemClickListener) activity;
        } else {
            throw new ClassCastException("Implement OnItemClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onItemClick(int id) {
        if (listener != null) {
            listener.onItemClick(id);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = ViewModelProviders.
                of(Objects.requireNonNull(getActivity()), factory)
                .get(OrganizationInfoViewModel.class);

        FragmentOrganizationInfoImageBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_organization_info_image,
                container,
                false);
        binding.setLifecycleOwner(this);
        binding.setVm(vm);

        initViewPager(binding);
        return binding.getRoot();
    }

    private void initViewPager(FragmentOrganizationInfoImageBinding binding) {
        OrganizationInfoPagerAdapter adapter =
                new OrganizationInfoPagerAdapter(getChildFragmentManager());
        binding.imageOrganizationVp.setAdapter(adapter);
        binding.indicator.setViewPager(binding.imageOrganizationVp);
    }
}
