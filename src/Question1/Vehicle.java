package Question1;

import java.util.*;

abstract class Vehicle {
    protected String vehicleId;
    protected String ownerName;
    protected int yearOfFabrication;
    protected String registrationNumber;
    protected double baseTaxRate;
    protected String vehicleType;

    public Vehicle(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, String vehicleType) {
        if (yearOfFabrication > Calendar.getInstance().get(Calendar.YEAR)) throw new IllegalArgumentException("Year can't be in the future");
        this.vehicleId = vehicleId;
        this.ownerName = ownerName;
        this.yearOfFabrication = yearOfFabrication;
        this.registrationNumber = registrationNumber;
        this.baseTaxRate = baseTaxRate;
        this.vehicleType = vehicleType;
    }

    public abstract double calculateTax();
    public abstract void generateTaxReport();

    public String toString() {
        return "ID: " + vehicleId + ", Owner: " + ownerName + ", Year: " + yearOfFabrication + ", Reg#: " + registrationNumber + ", BaseTax: " + baseTaxRate + ", Type: " + vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getVehicleId() {
        return vehicleId;
    }
}