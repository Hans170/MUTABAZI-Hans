package Question1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class Main1 {
    static Scanner sc = new Scanner(System.in);
    static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register vehicle\n2. View vehicles\n3. Calculate taxes\n4. Generate reports\n5. Exit");
            String choice = sc.nextLine();
            if (choice.equals("1")) registerVehicle();
            else if (choice.equals("2")) viewVehicles();
            else if (choice.equals("3")) calcAllTaxes();
            else if (choice.equals("4")) generateReports();
            else if (choice.equals("5")) break;
            else System.out.println("Invalid choice");
        }
    }

    static void registerVehicle() {
        String type;
        while (true) {
            type = inputString("Vehicle Type (Car/Truck/Motorcycle/Bus/SUV):").toLowerCase();
            if (type.equals("car") || type.equals("truck") || type.equals("motorcycle") || type.equals("bus") || type.equals("suv")) {
                break;
            } else {
                System.out.println("Unknown vehicle type. Please enter a valid one.");
            }
        }

        String id;
        while (true) {
            id = inputString("Vehicle ID:");
            boolean duplicateId = false;
            // Check if the id already exists
            for (Vehicle v : vehicles) {
                if (v.getVehicleId().equals(id)) {
                    duplicateId = true;
                    break;
                }
            }
            if (duplicateId) {
                System.out.println("Duplicate vehicle ID.");
            } else {
                break;
            }
        }

        String owner;
        while (true) {
            owner = inputString("Owner Name:");
            if (owner.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Owner name must be text only.");
            }
        }

        int year;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        while (true) {
            year = inputInt("Year of Fabrication:");
            if (year > 0 && year <= currentYear) {
                break;
            } else {
                System.out.println("Enter a valid year (not in the future).");
            }
        }

        String reg;
        while (true) {
            reg = inputString("Registration Number:");
            boolean duplicateReg = false;

            for (Vehicle v : vehicles) {
                if (v.getRegistrationNumber().equals(reg)) {
                    duplicateReg = true;
                    break;
                }
            }
            if (duplicateReg) {
                System.out.println("Duplicate registration number.");
            } else {
                break;
            }
        }

        double rate = inputDouble("Base Tax Rate:");

        if (type.equals("car")) {
            boolean elec = inputBoolean("Is Electric (true/false):");
            vehicles.add(new Car(id, owner, year, reg, rate, elec));
        } else if (type.equals("truck")) {
            double cap = inputDouble("Load Capacity (tons):");
            vehicles.add(new Truck(id, owner, year, reg, rate, cap));
        } else if (type.equals("motorcycle")) {
            int eng = inputInt("Engine Capacity (cc):");
            vehicles.add(new Motorcycle(id, owner, year, reg, rate, eng));
        } else if (type.equals("bus")) {
            int pass = inputInt("Passenger Capacity:");
            vehicles.add(new Bus(id, owner, year, reg, rate, pass));
        } else if (type.equals("suv")) {
            boolean four = inputBoolean("Four Wheel Drive (true/false):");
            vehicles.add(new SUV(id, owner, year, reg, rate, four));
        }
    }

    static void viewVehicles() {
        for (Vehicle v : vehicles) System.out.println(v);
    }

    static void calcAllTaxes() {
        for (Vehicle v : vehicles) System.out.println(v.calculateTax());
    }

    static void generateReports() {
        for (Vehicle v : vehicles) v.generateTaxReport();
    }

    static String inputString(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            if (!s.trim().isEmpty()) return s;
            System.out.println("Input required");
        }
    }

    static int inputInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid number");
            }
        }
    }

    static double inputDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid decimal number");
            }
        }
    }

    static boolean inputBoolean(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("true")) return true;
            if (input.equalsIgnoreCase("false")) return false;
            System.out.println("Enter true or false only");
        }
    }
}
