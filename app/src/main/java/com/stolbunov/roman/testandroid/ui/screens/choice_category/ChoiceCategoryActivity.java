package com.stolbunov.roman.testandroid.ui.screens.choice_category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.ActivityChoiceCategoryBinding;
import com.stolbunov.roman.testandroid.ui.screens.choice_category.ChoiceCategoryFragment.OnCategoryClickListener;
import com.stolbunov.roman.testandroid.ui.screens.choice_organization.ChoiceOrganizationActivity;

import androidx.databinding.DataBindingUtil;
import dagger.android.support.DaggerAppCompatActivity;

public class ChoiceCategoryActivity extends DaggerAppCompatActivity implements OnCategoryClickListener {
    private static final String KEY_SELECTED_CITY_ID = "KEY_SELECTED_CITY_ID";

    public static Intent getIntent(Context packageContext, int idSelectedCity) {
        Intent intent = new Intent(packageContext, ChoiceCategoryActivity.class);
        intent.putExtra(KEY_SELECTED_CITY_ID, idSelectedCity);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChoiceCategoryBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_choice_category);

        int idSelectedCity = getIntent().getIntExtra(KEY_SELECTED_CITY_ID, 0);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_categories, ChoiceCategoryFragment.newInstance(idSelectedCity))
                    .commitNow();
        }
    }

    @Override
    public void onCategoryClick(int idCity, int idCategory) {
        startActivity(ChoiceOrganizationActivity.getIntent(this, idCity, idCategory));
    }
}
