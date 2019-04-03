package com.stolbunov.roman.data.entities.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PictureEntity {
    @SerializedName("image")
    @Expose
    private String image;

    public String getImage() {
        return image;
    }
}
