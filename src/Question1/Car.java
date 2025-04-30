package Question1;

import java.util.Calendar;


class Car extends Vehicle {
    private boolean isElectric;

    public Car(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, boolean isElectric) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, "Car");
        this.isElectric = isElectric;
    }

    public double calculateTax() {
        double tax = baseTaxRate;
        if (Calendar.getInstance().get(Calendar.YEAR) - yearOfFabrication > 10) tax *= 0.9;
        if (isElectric) tax *= 0.8;
        return tax;
    }

    public void generateTaxReport() {
        System.out.println(toString());
        System.out.println("Tax: " + calculateTax());
    }
}
