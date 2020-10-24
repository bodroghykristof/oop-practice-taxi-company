package com.codecool.taxi.drivers;

public enum  ExperienceLevel {

    BEGINNER(10), ADVANCED(25), PROFESSIONAL(40);

    private final int extraRides;

    ExperienceLevel(int extraRides) {
        this.extraRides = extraRides;
    }

    public int getExtraRides() {
        return extraRides;
    }
}
