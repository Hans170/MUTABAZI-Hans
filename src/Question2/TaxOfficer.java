package Question2;

import java.util.List;
import java.util.ArrayList;

public class TaxOfficer {

    private String officerId;
    private String fullName;
    private String assignedRegion;
    private List<TaxDeclaration> auditsConducted;

    public TaxOfficer(String officerId, String fullName, String assignedRegion) {
        this.officerId = officerId;
        this.fullName = fullName;
        this.assignedRegion = assignedRegion;
        this.auditsConducted = new ArrayList<>();
    }

    public void auditDeclaration(TaxDeclaration declaration) {
        auditsConducted.add(declaration);
        System.out.println("Audit conducted for declaration: " + declaration.getTaxpayerName());
    }

    public void generateAuditSummary() {
        System.out.println("Audit Summary for Officer: " + fullName);
        for (TaxDeclaration declaration : auditsConducted) {
            System.out.println("Taxpayer: " + declaration.getTaxpayerName() +
                    ", Tax Type: " + declaration.getClass().getSimpleName() +
                    ", Amount: " + declaration.getTaxAmount() +
                    ", Status: " + (declaration.isPaid() ? "Paid" : "Unpaid"));
        }
    }

    public String getOfficerId() {
        return officerId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAssignedRegion() {
        return assignedRegion;
    }

    public List<TaxDeclaration> getAuditsConducted() {
        return auditsConducted;
    }
}
