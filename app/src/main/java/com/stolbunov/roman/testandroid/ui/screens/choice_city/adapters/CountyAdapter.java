package com.stolbunov.roman.testandroid.ui.screens.choice_city.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.stolbunov.roman.domain.entity.Country;
import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.binding_adapters.IDataAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class CountyAdapter extends ArrayAdapter implements IDataAdapter {
    private final Country hint;
    private static int textViewResourceId = android.R.layout.simple_spinner_item;
    private static int dropDownViewResourceId = android.R.layout.simple_spinner_dropdown_item;
    private List<Country> countries;

    @Inject
    public CountyAdapter(@NonNull Context context) {
        super(context, textViewResourceId);
        hint = createHint();
        countries = new ArrayList<>();
        countries.add(hint);
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
        countryName.setText(countries.get(position).getNameEn());

        if (position == 0) {
            countryName.setTextColor(Color.GRAY);
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return countries.size();
    }


    @Override
    public <T> void setData(List<T> data) {
        //noinspection unchecked
        List<Country> countries = (List<Country>) data;
        this.countries.clear();
        this.countries.add(hint);
        this.countries.addAll(countries);
        notifyDataSetChanged();
    }

    private Country createHint() {
        return new Country(
                "Страна",
                getContext().getString(R.string.country),
                "Країна",
                Collections.emptyList());
    }
}