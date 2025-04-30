package Question2;

import java.time.LocalDate;

public class WithholdingTax extends TaxDeclaration {

    private double amount;

    public WithholdingTax(String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double amount, boolean isPaid) {
        super(taxpayerName, taxpayerTIN, declarationDate, 0.0, isPaid);
        this.amount = amount;
    }

    @Override
    public void calculateTax() {
        double taxAmount = amount * 0.15;  // Assuming 15% withholding tax
        setTaxAmount(taxAmount);
    }

    @Override
    public void validateDeclaration() {
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        }
    }

    @Override
    public void generateReceipt() {
        System.out.println("Withholding Tax Receipt");
        System.out.println("Name: " + getTaxpayerName());
        System.out.println("TIN: " + getTaxpayerTIN());
        System.out.println("Date: " + getDeclarationDate());
        System.out.println("Amount: " + amount);
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
