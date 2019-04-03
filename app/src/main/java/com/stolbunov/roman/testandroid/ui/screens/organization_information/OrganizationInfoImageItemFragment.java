package com.stolbunov.roman.testandroid.ui.screens.organization_information;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.FragmentOrganizationInfoImageItemBinding;
import com.stolbunov.roman.testandroid.ui.screens.base.OnItemClickListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import dagger.android.support.DaggerFragment;

public class OrganizationInfoImageItemFragment extends DaggerFragment {
    private static final String KEY_IMAGES_URI = "KEY_IMAGES_URI";
    private static final String KEY_IMAGES_POSITION = "KEY_IMAGES_POSITION";
    private int position;
    private OnItemClickListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getParentFragment() instanceof OnItemClickListener) {
            listener = (OnItemClickListener) context;
        } else {
            throw new ClassCastException("Implement OnItemClickListener");
        }
    }

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        if (getParentFragment() instanceof OnItemClickListener) {
            listener = (OnItemClickListener) activity;
        } else {
            throw new ClassCastException("Implement OnItemClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public static OrganizationInfoImageItemFragment newInstance(String uri, int position) {
        OrganizationInfoImageItemFragment fragment = new OrganizationInfoImageItemFragment();
        Bundle args = new Bundle();
        args.putString(KEY_IMAGES_URI, uri);
        args.putInt(KEY_IMAGES_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentOrganizationInfoImageItemBinding binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_organization_info_image_item,
                container,
                false);
        binding.setLifecycleOwner(this);

        Bundle arguments = getArguments();

        if (arguments != null) {
            position = arguments.getInt(KEY_IMAGES_POSITION, 0);
            String uri = arguments.getString(KEY_IMAGES_URI, "");
            binding.setUri(uri);
        }

        View view = binding.getRoot();
        view.setOnClickListener(v -> onItemClick(position));
        return view;
    }

    private void onItemClick(int position) {
        if (listener != null) {
            listener.onItemClick(position);
        }
    }
}
