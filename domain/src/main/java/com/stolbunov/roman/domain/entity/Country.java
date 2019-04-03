package com.stolbunov.roman.domain.entity;

import java.util.List;

public class Country {
    private final String name;
    private final String nameEn;
    private final String nameUa;
    private final List<City> cities;

    public Country(String name, String nameEn, String nameUa, List<City> cities) {
        this.name = name;
        this.nameEn = nameEn;
        this.nameUa = nameUa;
        this.cities = cities;
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

    public List<City> getCities() {
        return cities;
    }
}
