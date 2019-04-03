package com.stolbunov.roman.data.entities.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OrganizationsResponseBody {
    @SerializedName("code")
    @Expose
    public int code;
    @SerializedName("message")
    @Expose
    public String message;
    @SerializedName("data")
    @Expose
    public List<OrganizationMinInfoEntity> data = null;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public List<OrganizationMinInfoEntity> getData() {
        return data;
    }
}
