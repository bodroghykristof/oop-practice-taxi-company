package com.codecool.taxi.cars;



public class ElectronicCar extends HumandDrivenCar {

    private static final double ELECTRONIC_COST = 400;
    public static final int MINIMUM_PASSENGERS = 60;
    public static final int MAXIMUM_ADDITIONAL_PASSENGERS = 20;

    public ElectronicCar() {
        super(ELECTRONIC_COST, MINIMUM_PASSENGERS + RANDOM.nextInt(MAXIMUM_ADDITIONAL_PASSENGERS));
    }

    public static double getElectronicCost() {
        return ELECTRONIC_COST;
    }

}
