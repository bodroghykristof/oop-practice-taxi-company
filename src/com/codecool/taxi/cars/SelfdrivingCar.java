package com.codecool.taxi.cars;

public class SelfdrivingCar extends Car {

    private static final double SELF_DRIVING_COST = 740;
    private static final int SELF_DRIVING_WEEKLY_PASSENGERS = 70;

    public SelfdrivingCar() {
        super(SELF_DRIVING_COST, SELF_DRIVING_WEEKLY_PASSENGERS);
    }

    public static double getSelfDrivingCost() {
        return SELF_DRIVING_COST;
    }
}
