package com.codecool.taxi.cars;

import com.codecool.taxi.drivers.Driver;

public class HumandDrivenCar extends Car {

    private Driver driver;

    public HumandDrivenCar(double cost, int weeklyPassengers) {
        super(cost, weeklyPassengers);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
