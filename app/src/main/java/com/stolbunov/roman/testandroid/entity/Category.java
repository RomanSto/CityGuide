package com.stolbunov.roman.testandroid.entity;

public enum Category {
    RESTAURANTS_CAFE(6),
    ENTERTAINMENT(7),
    SHOPS(8),
    SPORT(9),
    MEDICINE(10),
    CLUBS_BARS(11),
    BEAUTY_HEALTH(12),
    HOTELS(13),
    AUTO_MOTO(14),
    ANIMALS_PLANTS(15),
    SERVICES(16);

    private int id;
    Category(int id) {
        this.id = id;
    }

    public int getIdCategory() {
        return id;
    }
}
