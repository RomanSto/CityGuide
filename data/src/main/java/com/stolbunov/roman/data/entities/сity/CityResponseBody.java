package com.stolbunov.roman.data.entities.сity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CityResponseBody {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<CountryEntity> data = null;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<CountryEntity> getData() {
        return data;
    }
}
