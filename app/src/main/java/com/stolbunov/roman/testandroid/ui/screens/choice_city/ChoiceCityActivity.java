package com.stolbunov.roman.testandroid.ui.screens.choice_city;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.stolbunov.roman.testandroid.R;
import com.stolbunov.roman.testandroid.databinding.ActivityChoiceCityBinding;
import com.stolbunov.roman.testandroid.databinding.NavHeaderMainBinding;
import com.stolbunov.roman.testandroid.ui.screens.choice_category.ChoiceCategoryActivity;
import com.stolbunov.roman.testandroid.ui.screens.choice_city.ChoiceCityFragment.OnResultClickListener;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

public class ChoiceCityActivity extends DaggerAppCompatActivity implements OnResultClickListener,
        NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_GALLERY = 2;

    private Uri userImageURI;
    private ActivityChoiceCityBinding binding;

    private NavigationViewModel vm;
    @Inject
    NavigationViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vm = ViewModelProviders
                .of(this, factory)
                .get(NavigationViewModel.class);

        binding = DataBindingUtil
                .setContentView(this, R.layout.activity_choice_city);
        binding.setLifecycleOwner(this);
        binding.setVm(vm);

        Toolbar toolbar = binding.appBarMain.toolbar;
        setSupportActionBar(toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);
        NavHeaderMainBinding navHeaderBinding =
                DataBindingUtil.bind(navigationView.getHeaderView(0));

        if (navHeaderBinding != null) {
            navHeaderBinding.setVm(vm);
            navHeaderBinding.setLifecycleOwner(this);
        }

        addFragment(savedInstanceState);
    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_choose_city, ChoiceCityFragment.newInstance())
                    .commitNow();
        }
    }

    @Override
    public void onResultClick(int idCity) {
        startActivity(ChoiceCategoryActivity.getIntent(this, idCity));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startCamera();
        } else if (id == R.id.nav_gallery) {
            startGallery();
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void startGallery() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_IMAGE_GALLERY);
    }

    private void startCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
            }

            if (photoFile != null) {
                userImageURI = FileProvider.getUriForFile(this,
                        "com.stolbunov.roman.testandroid",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, userImageURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        return File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir);
    }

    private void galleryAddPic(Uri uri) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        mediaScanIntent.setData(uri);
        sendBroadcast(mediaScanIntent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_IMAGE_CAPTURE:
                    vm.setUserImagePath(userImageURI);
                    galleryAddPic(userImageURI);
                    break;
                case REQUEST_IMAGE_GALLERY:
                    vm.setUserImagePath(data.getData());
                    break;
            }
        }
    }
}

