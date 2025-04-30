package Question1;

import java.util.Calendar;

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, double loadCapacity) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, "Truck");
        this.loadCapacity = loadCapacity;
    }

    public double calculateTax() {
        double tax = baseTaxRate;
        if (Calendar.getInstance().get(Calendar.YEAR) - yearOfFabrication > 15) tax *= 1.15;
        if (loadCapacity > 10) tax *= 1.25;
        return tax;
    }

    public void generateTaxReport() {
        System.out.println(toString());
        System.out.println("Tax: " + calculateTax());
    }
}