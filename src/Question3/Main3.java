package Question3;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Internship> internships = new ArrayList<>();

        while (true) {
            System.out.println("Welcome to the Internship Management System");
            System.out.println("1. Register Internship");
            System.out.println("2. Generate and View Reports");
            System.out.println("3. Search Internships");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            String input = scanner.nextLine();
            if (!input.matches("\\d") || Integer.parseInt(input) < 1 || Integer.parseInt(input) > 4) {
                System.out.println("Invalid option. Try again.");
                continue;
            }
            int choice = Integer.parseInt(input);

            if (choice == 1) {
                registerInternship(scanner, internships);
            } else if (choice == 2) {
                generateAndViewReports(internships);
            } else if (choice == 3) {
                searchInternships(scanner, internships);
            } else {
                break;
            }
        }
        scanner.close();
    }

    public static void registerInternship(Scanner scanner, ArrayList<Internship> internships) {

        String studentName = promptOnlyLetters(scanner, "Student Name: ", true);
        String studentId = promptOnlyNumbers(scanner, "Student ID: "); // Ensuring only numbers for studentId
        String university = promptUniversity(scanner);
        String studentEmail = promptEmail(scanner);

        Student student = new Student(studentId, studentName, university, studentEmail);

        if (hasActiveInternship(student, internships)) {
            System.out.println("Student already has an active internship.");
            return;
        }

        String supervisorId = promptOnlyNumbers(scanner, "Supervisor ID: ");
        String supervisorName = promptOnlyLetters(scanner, "Supervisor Name: ", true);
        String qualification = promptSupervisorQualification(scanner, university);
        String supervisorEmail = promptEmail(scanner);

        Supervisor supervisor = new Supervisor(supervisorId, supervisorName, qualification, supervisorEmail);

        String internshipId = promptUniqueInternshipId(scanner, internships);
        String company = promptText(scanner, "Company Name: ");
        LocalDate start = promptDate(scanner, "Start Date (YYYY-MM-DD): ");
        LocalDate end = promptDate(scanner, "End Date (YYYY-MM-DD): ");
        long duration = ChronoUnit.DAYS.between(start, end);
        if (duration > 42) {
            System.out.println("Internship cannot exceed 6 weeks.");
            return;
        }

        Internship internship = new ULKInternship(internshipId, student, company, supervisor, start, end);
        internships.add(internship);
        System.out.println("Internship registered successfully.");
    }

    public static void generateAndViewReports(ArrayList<Internship> internships) {
        if (internships.isEmpty()) {
            System.out.println("No internships found.");
            return;
        }

        for (Internship i : internships) {
            System.out.println("------ Internship Report ------");
            System.out.println("Student Name: " + i.getStudent().getStudentName());
            System.out.println("University: " + i.getStudent().getUniversity());
            System.out.println("Company: " + i.getCompanyName());
            System.out.println("Duration: " + i.getStartDate() + " to " + i.getEndDate());
            System.out.println("Supervisor: " + i.getSupervisor().getName());
            System.out.println("Supervisor Qualification: " + i.getSupervisor().getQualification());
            System.out.println("Internship Status: " + (ChronoUnit.DAYS.between(i.getStartDate(), LocalDate.now()) > 42 ? "Completed" : "Ongoing"));
            System.out.println("Progress: In progress...");
            System.out.println("Completion: Pending\n");
        }
    }

    public static void searchInternships(Scanner scanner, ArrayList<Internship> internships) {
        System.out.println("Search by:\n1. Student ID\n2. University");
        String option = scanner.nextLine();
        if (option.equals("1")) {
            String studentId = promptText(scanner, "Enter Student ID: ");
            for (Internship i : internships) {
                if (i.getStudent().getStudentId().equalsIgnoreCase(studentId)) {
                    System.out.println("Found:\n" + i.getStudent().getStudentName() + " at " + i.getStudent().getUniversity());
                }
            }
        } else if (option.equals("2")) {
            String uni = promptUniversity(scanner);
            for (Internship i : internships) {
                if (i.getStudent().getUniversity().equalsIgnoreCase(uni)) {
                    System.out.println("Found:\n" + i.getStudent().getStudentName() + " at " + uni);
                }
            }
        } else {
            System.out.println("Invalid search option.");
        }
    }

    public static boolean hasActiveInternship(Student student, ArrayList<Internship> internships) {
        for (Internship i : internships) {
            if (i.getStudent().getStudentId().equalsIgnoreCase(student.getStudentId())) {
                return true;
            }
        }
        return false;
    }

    public static String promptOnlyLetters(Scanner s, String msg, boolean allowSpaces) {
        while (true) {
            System.out.print(msg);
            String in = s.nextLine().trim();
            if (allowSpaces && in.matches("[a-zA-Z ]+")) return in;
            if (!allowSpaces && in.matches("[a-zA-Z]+")) return in;
            System.out.println("Letters only. Try again.");
        }
    }

    public static String promptOnlyNumbers(Scanner s, String msg) {
        while (true) {
            System.out.print(msg);
            String in = s.nextLine().trim();

            // Check if input is numeric
            if (in.matches("\\d+")) {
                return in;
            } else {
                System.out.println("Please enter numbers only. Try again.");
            }
        }
    }

    public static String promptEmail(Scanner s) {
        while (true) {
            System.out.print("Email: ");
            String email = s.nextLine().trim();
            if (email.contains("@")) return email;
            System.out.println("Invalid email. Try again.");
        }
    }

    public static String promptText(Scanner s, String msg) {
        System.out.print(msg);
        return s.nextLine().trim();
    }

    public static String promptUniversity(Scanner s) {
        while (true) {
            System.out.print("University (ULK, UR, AUCA, UK): ");
            String uni = s.nextLine().trim().toUpperCase();
            if (uni.matches("ULK|UR|AUCA|UK")) return uni;
            System.out.println("Invalid university. Try again.");
        }
    }

    public static String promptSupervisorQualification(Scanner s, String uni) {
        while (true) {
            System.out.print("Supervisor Qualification (Bachelors, Masters, PhD): ");
            String q = s.nextLine().trim();
            if (q.equals("Bachelors") || q.equals("Masters") || q.equals("PhD")) return q;
            System.out.println("Invalid qualification. Try again.");
        }
    }

    public static LocalDate promptDate(Scanner s, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return LocalDate.parse(s.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid date format. Use YYYY-MM-DD.");
            }
        }
    }

    public static String promptUniqueInternshipId(Scanner s, ArrayList<Internship> internships) {
        while (true) {
            System.out.print("Internship ID (number only): ");
            String id = s.nextLine().trim();
            if (!id.matches("\\d+")) {
                System.out.println("Invalid ID format.");
                continue;
            }
            boolean exists = false;
            for (Internship i : internships) {
                if (i.getInternshipId().equals(id)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) return id;
            System.out.println("ID already exists. Try again.");
        }
    }
}
