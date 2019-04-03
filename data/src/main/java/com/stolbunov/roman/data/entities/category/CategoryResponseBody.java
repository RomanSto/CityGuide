package com.stolbunov.roman.data.entities.category;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponseBody {
    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<CategoryEntity> data = null;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<CategoryEntity> getData() {
        return data;
    }
}
