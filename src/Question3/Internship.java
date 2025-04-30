package Question3;

import java.time.LocalDate;

public abstract class Internship {

    private String internshipId;
    private Student student;
    private String companyName;
    private Supervisor supervisor;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status; // Added status field

    public Internship(String internshipId, Student student, String companyName, Supervisor supervisor, LocalDate startDate, LocalDate endDate) {
        this.internshipId = internshipId;
        this.student = student;
        this.companyName = companyName;
        this.supervisor = supervisor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Active";
    }

    public String getInternshipId() {
        return internshipId;
    }

    public Student getStudent() {
        return student;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public abstract String generateReport();

    public abstract String trackProgress();

    public abstract void validateInternship();
}
