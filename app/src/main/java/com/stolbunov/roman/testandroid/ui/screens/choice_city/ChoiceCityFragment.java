package com.stolbunov.roman.testandroid.ui.screens.choice_city;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.FragmentChoiceCityBinding;
import com.stolbunov.roman.testandroid.ui.screens.choice_city.adapters.CityAdapter;
import com.stolbunov.roman.testandroid.ui.screens.choice_city.adapters.CountyAdapter;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;

public class ChoiceCityFragment extends DaggerFragment implements AdapterView.OnItemSelectedListener {
    private ChoiceCityFragmentViewModel vm;
    private OnResultClickListener listener;
    @Inject
    ChoiceCityFragmentViewModelFactory factory;
    @Inject
    CountyAdapter countyAdapter;
    @Inject
    CityAdapter cityAdapter;

    public static ChoiceCityFragment newInstance() {
        return new ChoiceCityFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnResultClickListener) {
            listener = (OnResultClickListener) context;
        } else {
            throw new ClassCastException("Implement OnResultClickListener");
        }
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnResultClickListener) {
            listener = (OnResultClickListener) activity;
        } else {
            throw new ClassCastException("Implement OnResultClickListener");
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
                .of(this, factory)
                .get(ChoiceCityFragmentViewModel.class);

        FragmentChoiceCityBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_choice_city,
                container,
                false);

        binding.setLifecycleOwner(this);
        binding.setVm(vm);

        initView(binding);
        subscribeLiveData();
        return binding.getRoot();
    }

    private void subscribeLiveData() {
        vm.getPositionSelectedCityResultLD().observe(this, this::notifyListener);
    }

    private void initView(FragmentChoiceCityBinding binding) {
        AppCompatSpinner spinCountry = binding.spinCountry;
        spinCountry.setAdapter(countyAdapter);
        spinCountry.setOnItemSelectedListener(this);
        spinCountry.setSelection(vm.getPositionSelectedCountry());

        AppCompatSpinner spinCity = binding.spinCity;
        spinCity.setAdapter(cityAdapter);
        spinCity.setOnItemSelectedListener(this);
        spinCity.setSelection(vm.getPositionSelectedCity());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()) {
            case R.id.spin_country:
                vm.setPositionOfSelectedCountry(position);
                break;
            case R.id.spin_city:
                vm.setPositionOfSelectedCity(position);
                break;
        }
    }

    private void notifyListener(Integer idCity) {
        if (listener != null) {
            listener.onResultClick(idCity);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public interface OnResultClickListener {
        void onResultClick(int idCity);
    }
}