package com.stolbunov.roman.testandroid.ui.screens.choice_organization.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stolbunov.roman.domain.entity.organization.OrganizationMinInfo;
import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.binding_adapters.IDataAdapter;
import com.stolbunov.roman.testandroid.databinding.ItemOrganizationListBinding;
import com.stolbunov.roman.testandroid.ui.screens.base.OnItemClickListener;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

public class ChoiceOrganizationAdapter extends Adapter<ChoiceOrganizationAdapter.ChoiceOrganizationViewHolder>
        implements IDataAdapter {

    private List<OrganizationMinInfo> data;
    private OnItemClickListener listener;

    @Inject
    public ChoiceOrganizationAdapter() {
        data = Collections.emptyList();
    }

    @NonNull
    @Override
    public ChoiceOrganizationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOrganizationListBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_organization_list,
                parent,
                false);

        return new ChoiceOrganizationViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ChoiceOrganizationViewHolder holder, int position) {
        holder.bind(position);
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
        this.data = (List<OrganizationMinInfo>) data;
        notifyDataSetChanged();
    }


    class ChoiceOrganizationViewHolder extends RecyclerView.ViewHolder {
        private ItemOrganizationListBinding binding;

        ChoiceOrganizationViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        void bind(int position) {
            OrganizationMinInfo organization = data.get(position);
            binding.setOrganization(organization);
            binding.positionInList.setText(String.valueOf(position + 1));
            itemView.setOnClickListener(v -> onItemClick(organization.getId()));
        }

    }

}
