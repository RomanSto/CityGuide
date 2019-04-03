package com.stolbunov.roman.data.entities.company;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrganizationResponseBody {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private OrganizationEntity data;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public OrganizationEntity getData() {
        return data;
    }
}
