package com.stolbunov.roman.testandroid.ui.screens.choice_city.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.stolbunov.roman.domain.entity.City;
import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.binding_adapters.IDataAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CityAdapter extends ArrayAdapter<City> implements IDataAdapter {
    private final City hint;
    private static int textViewResourceId = android.R.layout.simple_spinner_item;
    private static int dropDownViewResourceId = android.R.layout.simple_spinner_dropdown_item;
    private List<City> cities;

    @Inject
    public CityAdapter(Context context) {
        super(context, textViewResourceId);
        hint = createHint();
        cities = new ArrayList<>();
        cities.add(hint);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getView(convertView, parent, textViewResourceId, position);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(convertView, parent, dropDownViewResourceId, position);
    }

    private View getView(View convertView, ViewGroup parent, int resource, int position) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(resource, parent, false);
        }

        TextView countryName = (TextView) convertView;
        countryName.setText(cities.get(position).getNameEn());

        if (position == 0) {
            countryName.setTextColor(Color.GRAY);
        }
        return convertView;
    }

    @Override
    public void setDropDownViewResource(int resource) {
        dropDownViewResourceId = resource;
        super.setDropDownViewResource(resource);
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public <T> void setData(List<T> items) {
        //noinspection unchecked
        List<City> cities = (List<City>) items;
        this.cities.clear();
        this.cities.add(hint);
        this.cities.addAll(cities);
        notifyDataSetChanged();
    }

    private City createHint() {
        return new City(
                -1,
                "Город",
                getContext().getString(R.string.city),
                "Місто");
    }
}