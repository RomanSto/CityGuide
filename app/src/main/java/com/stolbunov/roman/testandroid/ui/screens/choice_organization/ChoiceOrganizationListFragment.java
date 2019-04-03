package com.stolbunov.roman.testandroid.ui.screens.choice_organization;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.FragmentChoiceOrganizationListBinding;
import com.stolbunov.roman.testandroid.ui.screens.base.OnItemClickListener;
import com.stolbunov.roman.testandroid.ui.screens.choice_organization.adapter.ChoiceOrganizationAdapter;

import java.util.Objects;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.android.support.DaggerFragment;

public class ChoiceOrganizationListFragment extends DaggerFragment implements OnItemClickListener {
    private OnItemClickListener listener;
    private ChoiceOrganizationViewModel vm;
    @Inject
    ChoiceOrganizationViewModelFactory factory;
    @Inject
    ChoiceOrganizationAdapter adapter;

    public static ChoiceOrganizationListFragment newInstance() {
        return new ChoiceOrganizationListFragment();
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = ViewModelProviders
                .of(Objects.requireNonNull(getActivity()), factory)
                .get(ChoiceOrganizationViewModel.class);

        FragmentChoiceOrganizationListBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_choice_organization_list,
                container,
                false);

        binding.setLifecycleOwner(this);
        binding.setVm(vm);

        adapter.setListener(this);
        binding.rvOrganizations.setAdapter(adapter);
        binding.rvOrganizations.setLayoutManager(new LinearLayoutManager(getActivity()));
        return binding.getRoot();
    }

    @Override
    public void onItemClick(int id) {
        if (listener != null) {
            listener.onItemClick(id);
        }
    }
}
