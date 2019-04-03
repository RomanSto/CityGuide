package com.stolbunov.roman.testandroid.ui.screens.choice_organization;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;
import com.stolbunov.roman.testandroid.R;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerFragment;

public class ChoiceOrganizationMapFragment extends DaggerFragment implements OnMapReadyCallback {

    private ChoiceOrganizationViewModel vm;
    @Inject
    ChoiceOrganizationViewModelFactory factory;
    private GoogleMap map;


    public static ChoiceOrganizationMapFragment newInstance() {
        return new ChoiceOrganizationMapFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = ViewModelProviders
                .of(Objects.requireNonNull(getActivity()), factory)
                .get(ChoiceOrganizationViewModel.class);

        View view = inflater.inflate(
                R.layout.fragment_choice_organization_map,
                container,
                false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        vm.getMapMarkers().observe(getActivity(), this::addMarkersToMap);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
    }

    private void addMarkersToMap(List<MarkerOptions> markerOptions) {
        if (map != null) {
            for (MarkerOptions marker : markerOptions) {
                map.addMarker(marker);
            }
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(markerOptions.get(0).getPosition(), 10));
        }
    }
}
