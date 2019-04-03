package com.stolbunov.roman.testandroid.binding_adapters;

import android.net.Uri;

import com.stolbunov.roman.testandroid.R;

import androidx.databinding.BindingAdapter;
import de.hdodenhof.circleimageview.CircleImageView;

public class CircleImageViewBindingAdapter {
    @BindingAdapter("setImageURI")
    public static void setImageURI(CircleImageView imageView, Uri uri) {
        if (uri != null) {
            imageView.setImageURI(uri);
        } else {
            imageView.setImageResource(R.mipmap.ic_launcher_round);
        }
    }
}
