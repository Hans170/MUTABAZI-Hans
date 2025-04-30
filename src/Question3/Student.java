package Question3;

public class Student {
    private String studentId;
    private String studentName;
    private String university;
    private String email;

    public Student(String studentId, String studentName, String university, String email) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.university = university;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getUniversity() {
        return university;
    }

    public String getEmail() {
        return email;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return studentName;
    }
}
