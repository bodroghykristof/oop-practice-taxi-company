package com.codecool.taxi;

import com.codecool.taxi.cars.*;
import com.codecool.taxi.drivers.Driver;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class TaxiCompany {

    private final Set<Car> cars = new HashSet<>();
    private final Set<Driver> drivers = new HashSet<>();
    private boolean selfDrivingCarsUnderMaintenance = false;
    private double budget;
    private static final Random RANDOM = new Random();

    public TaxiCompany(double budget) {
        this.budget = budget;
    }

    public double getBudget() {
        return budget;
    }

    public void simulateWeek() {
        selfDrivingCarsUnderMaintenance = false;
        payDrivers();
        purchaseNewCars();
        servePassengers();
    }

    public void purchaseInitialCarsAndDrivers() {
        while (GasolineCar.getGasolineCost() < budget ) {
            GasolineCar newCar = new GasolineCar();
            hireNewDriver(newCar);
            cars.add(newCar);
            budget -= newCar.getCost();
            System.out.println("Purchased gasoline car");
        }
    }

    private void hireNewDriver(HumandDrivenCar newCar) {
        List<String> mobileNumbers = drivers.stream().map(Driver::getMobile).collect(Collectors.toList());
        String mobileOfNewDriver = "06-20-331-4557";
        Driver newDriver = new Driver("John", mobileOfNewDriver, mobileNumbers);
        drivers.forEach(driver -> driver.saveNewContact(mobileOfNewDriver));
        drivers.add(newDriver);
        newCar.setDriver(newDriver);
    }

    private void payDrivers() {
        drivers.forEach(driver -> budget -= driver.getSalary());
    }

    private void purchaseNewCars() {
        while (Math.max(ElectronicCar.getElectronicCost(), SelfdrivingCar.getSelfDrivingCost()) < budget ) {
            if (RANDOM.nextBoolean()) {
                HumandDrivenCar newCar = new ElectronicCar();
                hireNewDriver(newCar);
                cars.add(newCar);
                budget -= newCar.getCost();
                System.out.println("Purchased electronic car");
            } else {
                Car newCar = new SelfdrivingCar();
                cars.add(newCar);
                budget -= newCar.getCost();
                selfDrivingCarsUnderMaintenance = true;
                System.out.println("Purchased self-driving car");
            }
        }
    }

    private void servePassengers() {
        for (Car car : cars) {
            if (car instanceof SelfdrivingCar) {
                if (!selfDrivingCarsUnderMaintenance) {
                    useCarForWeek(car);
                }
            } else useCarForWeek(car);
        }
        System.out.println("Budget after week: " + budget);
    }

    private void useCarForWeek(Car car) {
        car.increaseAge();
        budget += car.getWeeklyIncomeProduced();
        if (car instanceof HumandDrivenCar) budget += ((HumandDrivenCar) car).getDriver().getExtraRides();
        System.out.println("Income of " + car.toString() + ": " + car.getWeeklyIncomeProduced());
    }

    public void doYearlyReview() {
//        System.out.println("Divers contacts:");
//        drivers.forEach(driver -> System.out.println(driver.getMobileNumbers()));
    }
}
