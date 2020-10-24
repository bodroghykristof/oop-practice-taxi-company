package com.codecool.taxi.cars;

import java.util.Random;
import java.util.UUID;

public abstract class Car {

    private final UUID id = UUID.randomUUID();
    protected final int weeklyPassengers;
    protected final double cost;
    protected double age;
    protected static final Random RANDOM = new Random();

    public Car(double cost, int weeklyPassengers) {
        this.cost = cost;
        this.age = 0;
        this.weeklyPassengers = weeklyPassengers;
    }

    public double getCost() {
        return cost;
    }

    public double getWeeklyIncomeProduced() {
        return weeklyPassengers;
    }

    public void increaseAge() {
        age += 1;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                '}';
    }
}
