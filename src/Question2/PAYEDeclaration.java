package Question2;

import java.time.LocalDate;

public class PAYEDeclaration extends TaxDeclaration {

    private double grossSalary;

    public PAYEDeclaration(String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double grossSalary, boolean isPaid) {
        super(taxpayerName, taxpayerTIN, declarationDate, 0.0, isPaid);
        this.grossSalary = grossSalary;
    }

    @Override
    public void calculateTax() {
        double taxRate = 0.1; // Simplified tax rate for demonstration
        double taxAmount = grossSalary * taxRate;
        setTaxAmount(taxAmount);
    }

    @Override
    public void validateDeclaration() {
        if (grossSalary <= 0) {
            System.out.println("Salary must be greater than zero.");
        }
    }

    @Override
    public void generateReceipt() {
        System.out.println("PAYE Receipt");
        System.out.println("Name: " + getTaxpayerName());
        System.out.println("TIN: " + getTaxpayerTIN());
        System.out.println("Date: " + getDeclarationDate());
        System.out.println("Gross Salary: " + grossSalary);
        System.out.println("Tax: " + getTaxAmount());
        System.out.println("Paid: " + (isPaid() ? "Yes" : "No"));
    }

    @Override
    public void enforceCompliance() {
        if (!isPaid()) {
            System.out.println("Penalty for late payment applied.");
        }
    }

    private void setTaxAmount(double taxAmount) {
        super.taxAmount = taxAmount;
    }
}
