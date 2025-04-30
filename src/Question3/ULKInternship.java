package Question3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ULKInternship extends Internship {

    public ULKInternship(String internshipId, Student student, String companyName, Supervisor supervisor, LocalDate startDate, LocalDate endDate) {
        super(internshipId, student, companyName, supervisor, startDate, endDate);
    }

    @Override
    public String generateReport() {
        return "ULK Internship Report: \n" +
                "Student: " + getStudent().getName() + "\n" +
                "University: " + getStudent().getUniversity() + "\n" +
                "Company: " + getCompanyName() + "\n" +
                "Supervisor: " + getSupervisor().getName() + "\n" +
                "Start Date: " + getStartDate() + "\n" +
                "End Date: " + getEndDate() + "\n" +
                "Duration: " + getDuration() + " weeks\n" +
                "Progress: " + trackProgress() + "\n" +
                "Internship Status: " + getStatus();
    }

    @Override
    public String trackProgress() {
        return "Progress details for ULK Internship will be updated as required.";
    }

    @Override
    public void validateInternship() {
        if (ChronoUnit.DAYS.between(getStartDate(), getEndDate()) < 42) {
            System.out.println("Internship duration cannot be less than 6 weeks.");
        } else {
            System.out.println("Internship duration is valid.");
        }
    }


    public int getDuration() {
        return (int) ChronoUnit.WEEKS.between(getStartDate(), getEndDate());
    }
}
