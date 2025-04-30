package Question1;

import java.util.Calendar;


class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, int passengerCapacity) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, "Bus");
        this.passengerCapacity = passengerCapacity;
    }

    public double calculateTax() {
        double tax = baseTaxRate;
        tax += baseTaxRate * 0.02 * (passengerCapacity / 10);
        if (Calendar.getInstance().get(Calendar.YEAR) - yearOfFabrication > 20) tax *= 1.1;
        return tax;
    }

    public void generateTaxReport() {
        System.out.println(toString());
        System.out.println("Tax: " + calculateTax());
    }
}