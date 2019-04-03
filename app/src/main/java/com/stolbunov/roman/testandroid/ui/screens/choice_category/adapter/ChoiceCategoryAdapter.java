package com.stolbunov.roman.testandroid.ui.screens.choice_category.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.binding_adapters.IDataAdapter;
import com.stolbunov.roman.testandroid.databinding.ItemCategoryBinding;
import com.stolbunov.roman.testandroid.entity.CategoryForAdapter;
import com.stolbunov.roman.testandroid.ui.screens.base.OnItemClickListener;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class ChoiceCategoryAdapter extends Adapter<ChoiceCategoryAdapter.ChoiceCategoryViewHolder>
        implements IDataAdapter {

    private List<CategoryForAdapter> data;
    private OnItemClickListener listener;

    @Inject
    public ChoiceCategoryAdapter() {
        data = Collections.emptyList();
    }

    @NonNull
    @Override
    public ChoiceCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCategoryBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_category,
                parent,
                false);

        return new ChoiceCategoryViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ChoiceCategoryViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    private void onItemClick(int id) {
        if (listener != null) {
            listener.onItemClick(id);
        }
    }

    @Override
    public <T> void setData(List<T> data) {
        this.data = (List<CategoryForAdapter>) data;
        notifyDataSetChanged();
    }


    class ChoiceCategoryViewHolder extends RecyclerView.ViewHolder {
        private ItemCategoryBinding binding;

        ChoiceCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        void bind(CategoryForAdapter categoryForAdapter) {
            binding.setCategory(categoryForAdapter);
            itemView.setOnClickListener(v -> onItemClick(categoryForAdapter.getId()));
        }
    }
}
