package com.stolbunov.roman.testandroid.ui.screens.show_image_organization;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.stolbunov.roman.domain.entity.organization.Picture;
import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.ui.screens.organization_information.OrganizationInfoActivity;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import dagger.android.support.DaggerAppCompatActivity;

public class ShowImageOrganizationActivity extends DaggerAppCompatActivity implements
        ShowImageOrganizationFragment.OnPageSelectedListener {

    private static final String KEY_SELECTED_IMAGE_POSITION = "KEY_SELECTED_IMAGE_POSITION";
    private static final String KEY_IMAGE_LIST_URI = "KEY_IMAGE_LIST_URI";
    private int selectedPosition;

    public static Intent getIntent(Context packageContext, int positionImage, ArrayList<Picture> imageUri) {
        Intent intent = new Intent(packageContext, ShowImageOrganizationActivity.class);
        intent.putExtra(KEY_SELECTED_IMAGE_POSITION, positionImage);
        intent.putParcelableArrayListExtra(KEY_IMAGE_LIST_URI, imageUri);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image_organization);

        Intent intent = getIntent();
        selectedPosition = intent.getIntExtra(KEY_SELECTED_IMAGE_POSITION, 0);
        ArrayList<Picture> uri = intent.getParcelableArrayListExtra(KEY_IMAGE_LIST_URI);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_image,
                            ShowImageOrganizationFragment.newInstance(selectedPosition, uri),
                            "ShowImageOrganizationFragment")
                    .commitNow();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SELECTED_IMAGE_POSITION, selectedPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        selectedPosition = savedInstanceState.getInt(KEY_SELECTED_IMAGE_POSITION, 0);
    }

    @Override
    public void onPageSelected(int position) {
        selectedPosition = position;
    }

    @Override
    public void onBackPressed() {
        setResult(
                RESULT_OK,
                OrganizationInfoActivity.getIntentForSelectedPosition(selectedPosition));
        finish();
    }
}
