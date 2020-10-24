package com.codecool.taxi.cars;

public class GasolineCar extends HumandDrivenCar {

    private static final double GASOLINE_COST = 350;
    public static final int MINIMUM_PASSENGERS = 100;
    public static final int MAXIMUM_ADDITIONAL_PASSENGERS = 60;
    public static final int MAINTENANCE_BASE_VALUE = 20;

    public GasolineCar() {
        super(GASOLINE_COST, MINIMUM_PASSENGERS + RANDOM.nextInt(MAXIMUM_ADDITIONAL_PASSENGERS));
    }

    public static double getGasolineCost() {
        return GASOLINE_COST;
    }

    @Override
    public double getWeeklyIncomeProduced() {
        return weeklyPassengers - MAINTENANCE_BASE_VALUE * (1 + 0.1 * age);
    }
}
