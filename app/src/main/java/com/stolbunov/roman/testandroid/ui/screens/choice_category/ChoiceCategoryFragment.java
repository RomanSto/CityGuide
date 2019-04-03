package com.stolbunov.roman.testandroid.ui.screens.choice_category;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.FragmentChoiceCategoryBinding;
import com.stolbunov.roman.testandroid.ui.screens.base.OnItemClickListener;
import com.stolbunov.roman.testandroid.ui.screens.choice_category.adapter.ChoiceCategoryAdapter;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import dagger.android.support.DaggerFragment;

public class ChoiceCategoryFragment extends DaggerFragment
        implements OnItemClickListener {

    private static final String KEY_SELECTED_CITY_ID = "KEY_SELECTED_CITY_ID";
    private static final int NUMBER_COLUMNS_RV = 2;
    private OnCategoryClickListener listener;
    private ChoiceCategoryViewModel vm;

    @Inject
    ChoiceCategoryViewModelFactory factory;
    @Inject
    ChoiceCategoryAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCategoryClickListener) {
            listener = (OnCategoryClickListener) context;
        } else {
            throw new ClassCastException("Implement OnCategoryClickListener");
        }
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnCategoryClickListener) {
            listener = (OnCategoryClickListener) activity;
        } else {
            throw new ClassCastException("Implement OnCategoryClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public static ChoiceCategoryFragment newInstance(int idSelectedCity) {
        ChoiceCategoryFragment fragment = new ChoiceCategoryFragment();
        Bundle args = new Bundle();
        args.putInt(KEY_SELECTED_CITY_ID, idSelectedCity);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = ViewModelProviders
                .of(this, factory)
                .get(ChoiceCategoryViewModel.class);

        Bundle arguments = getArguments();
        if (arguments != null) {
            vm.setSelectedCityId(arguments.getInt(KEY_SELECTED_CITY_ID, 0));
        }

        FragmentChoiceCategoryBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_choice_category,
                container,
                false);
        binding.setLifecycleOwner(this);
        binding.setVm(vm);

        adapter.setListener(this);
        binding.rvCategories.setAdapter(adapter);
        binding.rvCategories.setLayoutManager(new GridLayoutManager(getActivity(), NUMBER_COLUMNS_RV));
        return binding.getRoot();
    }

    @Override
    public void onItemClick(int id) {
        Integer idCity = vm.getSelectedCityId();
        if (listener != null && idCity != null) {
            listener.onCategoryClick(idCity, id);
        }
    }

    public interface OnCategoryClickListener {
        void onCategoryClick(int idCity, int idCategory);
    }

}
