package Question1;

import java.util.Calendar;

class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, int engineCapacity) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, "Motorcycle");
        this.engineCapacity = engineCapacity;
    }

    public double calculateTax() {
        double tax = baseTaxRate;
        if (engineCapacity > 500) tax *= 1.2;
        int age = Calendar.getInstance().get(Calendar.YEAR) - yearOfFabrication;
        tax *= (1 - (0.05 * (age / 5)));
        return tax;
    }

    public void generateTaxReport() {
        System.out.println(toString());
        System.out.println("Tax: " + calculateTax());
    }
}
