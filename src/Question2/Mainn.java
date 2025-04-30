package Question2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mainn {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<TaxDeclaration> declarations = new ArrayList<>();
        List<Taxpayer> taxpayers = new ArrayList<>();

        TaxOfficer officer = new TaxOfficer("TAX123", "John Doe", "Kigali");

        while (true) {
            System.out.println("1. Declare PAYE");
            System.out.println("2. Declare VAT");
            System.out.println("3. Declare Withholding Tax");
            System.out.println("4. View Unpaid");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Incorrect option! Please enter a number between 1 and 5.");
                scanner.next();
                System.out.print("Choose an option: ");
            }

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                declarePAYE(scanner, declarations);
            } else if (choice == 2) {
                declareVAT(scanner, declarations);
            } else if (choice == 3) {
                declareWithholdingTax(scanner, declarations);
            } else if (choice == 4) {
                viewUnpaid(declarations);
            } else if (choice == 5) {
                System.out.println("Exiting the system!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void declarePAYE(Scanner scanner, List<TaxDeclaration> declarations) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        if (!name.matches("[a-zA-Z]+")) {
            System.out.println("Name must contain only letters");
            return;
        }

        System.out.print("TIN : ");
        String tin = scanner.nextLine();
        if (tin.length() != 9 || !tin.matches("\\d+")) {
            System.out.println("TIN must be 9 digits");
            return;
        }

        System.out.print("Enter date (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        LocalDate date;
        try {
            date = LocalDate.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Invalid date");
            return;
        }

        System.out.print("Gross Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        PAYEDeclaration paye = new PAYEDeclaration(name, tin, date, salary, true);
        paye.calculateTax();
        paye.generateReceipt();
        declarations.add(paye);
    }

    private static void declareVAT(Scanner scanner, List<TaxDeclaration> declarations) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        if (!name.matches("[a-zA-Z]+")) {
            System.out.println("Name must contain only letters");
            return;
        }

        System.out.print("TIN (9 digits): ");
        String tin = scanner.nextLine();
        if (tin.length() != 9 || !tin.matches("\\d+")) {
            System.out.println("TIN must be 9 digits");
            return;
        }

        System.out.print("Enter date (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        LocalDate date;
        try {
            date = LocalDate.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Invalid date");
            return;
        }

        System.out.print("Sales: ");
        double sales = scanner.nextDouble();
        System.out.print("Purchases: ");
        double purchases = scanner.nextDouble();
        scanner.nextLine();

        VATDeclaration vat = new VATDeclaration(name, tin, date, sales, purchases, true);
        vat.calculateTax();
        vat.generateReceipt();
        declarations.add(vat);
    }

    private static void declareWithholdingTax(Scanner scanner, List<TaxDeclaration> declarations) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        if (!name.matches("[a-zA-Z]+")) {
            System.out.println("Name must contain only letters");
            return;
        }

        System.out.print("TIN (9 digits): ");
        String tin = scanner.nextLine();
        if (tin.length() != 9 || !tin.matches("\\d+")) {
            System.out.println("TIN must be 9 digits");
            return;
        }

        System.out.print("Enter date (yyyy-mm-dd): ");
        String dateInput = scanner.nextLine();
        LocalDate date;
        try {
            date = LocalDate.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Invalid date");
            return;
        }

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline

        WithholdingTax withholdingTax = new WithholdingTax(name, tin, date, amount, true);
        withholdingTax.calculateTax();
        withholdingTax.generateReceipt();
        declarations.add(withholdingTax);
    }

    private static void viewUnpaid(List<TaxDeclaration> declarations) {
        System.out.println("Unpaid Declarations:");
        for (TaxDeclaration declaration : declarations) {
            if (!declaration.isPaid()) {
                System.out.println("Taxpayer: " + declaration.getTaxpayerName() +
                        ", Tax Type: " + declaration.getClass().getSimpleName() +
                        ", Amount: " + declaration.getTaxAmount());
            }
        }
    }
}
