package com.stolbunov.roman.testandroid.binding_adapters;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewBindingAdapter {

    @BindingAdapter("setDataRV")
    public static <T> void setDataRV(RecyclerView recyclerView, List<T> data) {
        IDataAdapter adapter = (IDataAdapter) recyclerView.getAdapter();
        if (adapter != null && data != null) {
            adapter.setData(data);
        }
    }
}
