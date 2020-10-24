package com.codecool.taxi.app;

import com.codecool.taxi.TaxiCompany;

public class App {

    public static void main(String[] args) {
        TaxiCompany taxiCompany = new TaxiCompany(1500);
        taxiCompany.purchaseInitialCarsAndDrivers();
        for (int i = 0; i < 52; i++) {
            System.out.println("Week " + (i + 1) + "\n-------------\n");
            taxiCompany.simulateWeek();
        }
        taxiCompany.doYearlyReview();
    }

}
