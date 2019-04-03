package com.stolbunov.roman.domain.entity.organization;

public class WorkTime {
    private final String name;
    private final String nameUa;
    private final String nameEn;
    private final String alias;
    private final String from;
    private final String to;
    private final Integer isDayOff;

    public WorkTime(String name, String nameUa, String nameEn, String alias, String from, String to, Integer isDayOff) {
        this.name = name;
        this.nameUa = nameUa;
        this.nameEn = nameEn;
        this.alias = alias;
        this.from = from;
        this.to = to;
        this.isDayOff = isDayOff;
    }

    public String getName() {
        return name;
    }

    public String getNameUa() {
        return nameUa;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getAlias() {
        return alias;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Integer getIsDayOff() {
        return isDayOff;
    }
}
