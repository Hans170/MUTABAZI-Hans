package Question2;

import java.time.LocalDate;

public abstract class TaxDeclaration {

    private String taxpayerName;
    private String taxpayerTIN;
    private LocalDate declarationDate;
    protected double taxAmount;
    private boolean isPaid;

    public TaxDeclaration(String taxpayerName, String taxpayerTIN, LocalDate declarationDate, double taxAmount, boolean isPaid) {
        this.taxpayerName = taxpayerName;
        this.taxpayerTIN = taxpayerTIN;
        this.declarationDate = declarationDate;
        this.taxAmount = taxAmount;
        this.isPaid = isPaid;
    }

    public String getTaxpayerName() {
        return taxpayerName;
    }

    public String getTaxpayerTIN() {
        return taxpayerTIN;
    }

    public LocalDate getDeclarationDate() {
        return declarationDate;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public abstract void calculateTax();

    public abstract void validateDeclaration();

    public abstract void generateReceipt();

    public abstract void enforceCompliance();
}
