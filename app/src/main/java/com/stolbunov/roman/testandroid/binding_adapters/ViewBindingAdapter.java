package com.stolbunov.roman.testandroid.binding_adapters;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class ViewBindingAdapter {

    @BindingAdapter("setEnabled")
    public static void setEnabled(View view, Boolean enabled) {
        if (enabled != null) {
            view.setEnabled(enabled);
        }
    }
}
