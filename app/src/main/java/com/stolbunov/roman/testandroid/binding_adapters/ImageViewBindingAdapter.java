package com.stolbunov.roman.testandroid.binding_adapters;

import android.content.res.ColorStateList;

import com.bumptech.glide.Glide;
import com.stolbunov.roman.testandroid.R;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingAdapter;

import static com.stolbunov.roman.testandroid.entity.Category.ANIMALS_PLANTS;
import static com.stolbunov.roman.testandroid.entity.Category.AUTO_MOTO;
import static com.stolbunov.roman.testandroid.entity.Category.BEAUTY_HEALTH;
import static com.stolbunov.roman.testandroid.entity.Category.CLUBS_BARS;
import static com.stolbunov.roman.testandroid.entity.Category.ENTERTAINMENT;
import static com.stolbunov.roman.testandroid.entity.Category.HOTELS;
import static com.stolbunov.roman.testandroid.entity.Category.MEDICINE;
import static com.stolbunov.roman.testandroid.entity.Category.RESTAURANTS_CAFE;
import static com.stolbunov.roman.testandroid.entity.Category.SERVICES;
import static com.stolbunov.roman.testandroid.entity.Category.SHOPS;
import static com.stolbunov.roman.testandroid.entity.Category.SPORT;

public class ImageViewBindingAdapter {

    @BindingAdapter("setUriCenterCrop")
    public static void setUrlCenterCrop(AppCompatImageView imageView, String uri) {
        if (uri != null) {
            Glide.with(imageView.getContext())
                    .load(uri)
                    .centerCrop()
                    .into(imageView);
        }
    }

    @BindingAdapter("setUri")
    public static void setUrl(AppCompatImageView imageView, String uri) {
        if (uri != null) {
            Glide.with(imageView.getContext())
                    .load(uri)
                    .into(imageView);
        }
    }

    @BindingAdapter("setIdCategory")
    public static void setIdCategory(AppCompatImageView imageView, Integer categoryId) {
        if (categoryId == RESTAURANTS_CAFE.getIdCategory()) {
            fillingView(imageView, R.color.colorRestaurantsCafe, R.drawable.ic_restaurant);

        } else if (categoryId == ENTERTAINMENT.getIdCategory()) {
            fillingView(imageView, R.color.colorEntertainment, R.drawable.ic_entertainment);

        } else if (categoryId == SHOPS.getIdCategory()) {
            fillingView(imageView, R.color.colorShops, R.drawable.ic_shop);

        } else if (categoryId == SPORT.getIdCategory()) {
            fillingView(imageView, R.color.colorSport, R.drawable.ic_sport);

        } else if (categoryId == MEDICINE.getIdCategory()) {
            fillingView(imageView, R.color.colorMedicine, R.drawable.ic_add);

        } else if (categoryId == CLUBS_BARS.getIdCategory()) {
            fillingView(imageView, R.color.colorClubsBars, R.drawable.ic_bar);

        } else if (categoryId == BEAUTY_HEALTH.getIdCategory()) {
            fillingView(imageView, R.color.colorBeautyHealth, R.drawable.ic_health);

        } else if (categoryId == HOTELS.getIdCategory()) {
            fillingView(imageView, R.color.colorHotels, R.drawable.ic_hotel);

        } else if (categoryId == AUTO_MOTO.getIdCategory()) {
            fillingView(imageView, R.color.colorAutoMoto, R.drawable.ic_moto);

        } else if (categoryId == ANIMALS_PLANTS.getIdCategory()) {
            fillingView(imageView, R.color.colorAnimalsPlants, R.drawable.ic_plant);

        } else if (categoryId == SERVICES.getIdCategory()) {
            fillingView(imageView, R.color.colorServices, R.drawable.ic_service);
        }
    }

    private static void fillingView(AppCompatImageView imageView,int color, int resId) {
        imageView.setImageResource(resId);
        imageView.setSupportBackgroundTintList(ColorStateList.valueOf(
                imageView.getContext().getResources().getColor(color)));

    }
}
