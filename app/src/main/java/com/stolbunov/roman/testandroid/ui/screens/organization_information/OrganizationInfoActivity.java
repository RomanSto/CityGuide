package com.stolbunov.roman.testandroid.ui.screens.organization_information;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.stolbunov.roman.domain.entity.organization.Organization;
import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.ActivityOrganizationInfoBinding;
import com.stolbunov.roman.testandroid.ui.screens.base.OnItemClickListener;
import com.stolbunov.roman.testandroid.ui.screens.show_image_organization.ShowImageOrganizationActivity;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

public class OrganizationInfoActivity extends DaggerAppCompatActivity implements OnItemClickListener {
    private static final String KEY_SELECTED_ORGANIZATION_ID = "KEY_SELECTED_ORGANIZATION_ID";
    private static final String KEY_SELECTED_POSITION = "KEY_SELECTED_POSITION";
    private static final int REQUEST_SELECTED_POSITION = 320;
    private OrganizationInfoViewModel vm;
    private ActivityOrganizationInfoBinding binding;

    @Inject
    OrganizationInfoViewModelFactory factory;

    public static Intent getIntent(Context packageContext, int idOrganization) {
        Intent intent = new Intent(packageContext, OrganizationInfoActivity.class);
        intent.putExtra(KEY_SELECTED_ORGANIZATION_ID, idOrganization);
        return intent;
    }

    public static Intent getIntentForSelectedPosition(Context packageContext, int selectedPosition) {
        Intent intent = new Intent(packageContext, OrganizationInfoActivity.class);
        intent.putExtra(KEY_SELECTED_POSITION, selectedPosition);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vm = ViewModelProviders
                .of(this, factory)
                .get(OrganizationInfoViewModel.class);

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_organization_info);
        binding.setLifecycleOwner(this);
        binding.setVm(vm);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_view_pager,
                            OrganizationInfoImageFragment.newInstance(),
                            "OrganizationInfoImageFragment")
                    .commitNow();
        }

        vm.setOrganizationId(getIntent().getIntExtra(KEY_SELECTED_ORGANIZATION_ID, 0));
        vm.getOrganizationLD().observe(this, this::showOrganizationInfo);
    }

    private void showOrganizationInfo(Organization organization) {
        binding.setOrganization(organization);
    }

    @Override
    public void onItemClick(int id) {
        startActivityForResult(ShowImageOrganizationActivity.getIntent(
                this, id, vm.getPictureUriList()), REQUEST_SELECTED_POSITION);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_SELECTED_POSITION:
                    if (data != null) {
                        processingSelectedPosition(
                                data.getIntExtra(KEY_SELECTED_POSITION, 0));
                    }
                    break;
            }
        }
    }

    private void processingSelectedPosition(int selectedPosition) {
        vm.setCurrentImagePosition(selectedPosition);
    }
}