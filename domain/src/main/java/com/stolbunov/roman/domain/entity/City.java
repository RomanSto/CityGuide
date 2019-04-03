package com.stolbunov.roman.domain.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    private final int id;
    private final String name;
    private final String nameEn;
    private final String nameUa;

    public City(int id, String name, String nameEn, String nameUa) {
        this.id = id;
        this.name = name;
        this.nameEn = nameEn;
        this.nameUa = nameUa;
    }

    protected City(Parcel in) {
        id = in.readInt();
        name = in.readString();
        nameEn = in.readString();
        nameUa = in.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameUa() {
        return nameUa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(nameEn);
        dest.writeString(nameUa);
    }
}
