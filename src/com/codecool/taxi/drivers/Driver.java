package com.codecool.taxi.drivers;

import java.util.List;
import java.util.Random;

public class Driver {

    private static final int MINIMUM_SALARY = 30;
    private static final int MAXIMUM_EXTRA_SALARY = 40;

    private String mobile;
    private final String name;
    private int age;
    private double salary;
    private List<String> mobileNumbers;
    private final ExperienceLevel experience;
    private static final Random RANDOM = new Random();

    public Driver(String name, String mobile, List<String> mobileNumbers) {
        this.name = name;
        this.mobile = mobile;
        this.mobileNumbers = mobileNumbers;
        this.experience =  ExperienceLevel.values()[RANDOM.nextInt(ExperienceLevel.values().length)];
        this.salary = MINIMUM_SALARY + RANDOM.nextInt(MAXIMUM_EXTRA_SALARY);
    }

    public String getMobile() {
        return mobile;
    }

    public void saveNewContact(String phoneNumber) {
        mobileNumbers.add(phoneNumber);
    }

    public List<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public double getSalary() {
        return salary;
    }

    public int getExtraRides() {
        return experience.getExtraRides();
    }
}
