package com.stolbunov.roman.testandroid.binding_adapters;

import java.util.List;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BindingAdapter;

public class SpinnerBindingAdapter {

    @BindingAdapter("setDataSpin")
    public static <T> void setDataSpin(AppCompatSpinner spinner, List<T> data) {
        IDataAdapter adapter = (IDataAdapter) spinner.getAdapter();
        if (adapter != null && data != null) {
            adapter.setData(data);
        }
    }
}
