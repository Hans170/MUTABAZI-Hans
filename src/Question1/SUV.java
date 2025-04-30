package Question1;
import java.util.Calendar;

class SUV extends Vehicle {
    private boolean fourWheelDrive;

    public SUV(String vehicleId, String ownerName, int yearOfFabrication, String registrationNumber, double baseTaxRate, boolean fourWheelDrive) {
        super(vehicleId, ownerName, yearOfFabrication, registrationNumber, baseTaxRate, "SUV");
        this.fourWheelDrive = fourWheelDrive;
    }

    public double calculateTax() {
        double tax = baseTaxRate;
        if (fourWheelDrive) tax *= 1.1;
        if (Calendar.getInstance().get(Calendar.YEAR) - yearOfFabrication > 10) tax *= 0.95;
        return tax;
    }

    public void generateTaxReport() {
        System.out.println(toString());
        System.out.println("Tax: " + calculateTax());
    }
}
