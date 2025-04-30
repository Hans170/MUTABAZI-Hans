package Question2;

public class Taxpayer {

    private String tin;
    private String name;
    private String type; // Individual or Company
    private int complianceScore;

    public Taxpayer(String tin, String name, String type) {
        this.tin = tin;
        this.name = name;
        this.type = type;
        this.complianceScore = 100; // Default compliance score is 100
    }

    public String getTin() {
        return tin;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getComplianceScore() {
        return complianceScore;
    }

    public void setComplianceScore(int complianceScore) {
        this.complianceScore = complianceScore;
    }

    public void updateComplianceScore(boolean isPaid) {
        if (isPaid) {
            complianceScore += 10;
        } else {
            complianceScore -= 5;
        }
    }
}
