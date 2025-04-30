package Question3;

public class Company {
    String companyId;
    String name;
    String industryType;
    String location;

    public Company(String companyId, String name, String industryType, String location) {
        this.companyId = companyId;
        this.name = name;
        this.industryType = industryType;
        this.location = location;
    }

    public String getIndustryType() {
        return industryType;
    }

    public void setIndustryType(String industryType) {
        this.industryType = industryType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
