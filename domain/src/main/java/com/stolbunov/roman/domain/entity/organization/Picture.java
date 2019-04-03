package com.stolbunov.roman.domain.entity.organization;

import android.os.Parcel;
import android.os.Parcelable;

public class Picture implements Parcelable {
    private final String image;

    public Picture(String image) {
        this.image = image;
    }

    protected Picture(Parcel in) {
        image = in.readString();
    }

    public static final Creator<Picture> CREATOR = new Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel in) {
            return new Picture(in);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[size];
        }
    };

    public String getImage() {
        return image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
    }
}
