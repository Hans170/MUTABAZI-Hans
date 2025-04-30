package Question2;

import java.time.LocalDate;

public class VATDeclaration extends TaxDeclaration {

    private double sales;
    private double purchases;

    public VATDeclaration(String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double sales, double purchases, boolean isPaid) {
        super(taxpayerName, taxpayerTIN, declarationDate, 0.0, isPaid);
        this.sales = sales;
        this.purchases = purchases;
    }

    @Override
    public void calculateTax() {
        double taxAmount = (sales - purchases) * 0.18;
        setTaxAmount(taxAmount);
    }

    @Override
    public void validateDeclaration() {
        if (sales <= purchases) {
            System.out.println("Sales must be greater than purchases.");
        }
    }

    @Override
    public void generateReceipt() {
        System.out.println("VAT Receipt");
        System.out.println("Name: " + getTaxpayerName());
        System.out.println("TIN: " + getTaxpayerTIN());
        System.out.println("Date: " + getDeclarationDate());
        System.out.println("Sales: " + sales);
        System.out.println("Purchases: " + purchases);
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
