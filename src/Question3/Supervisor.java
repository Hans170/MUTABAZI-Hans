package Question3;

public class Supervisor {
    private String supervisorId;
    private String name;
    private String qualification;
    private String email;

    public Supervisor(String supervisorId, String name, String qualification, String email) {
        this.supervisorId = supervisorId;
        this.name = name;
        this.qualification = qualification;
        this.email = email;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public String getName() {
        return name;
    }

    public String getQualification() {
        return qualification;
    }

    public String getEmail() {
        return email;
    }
}
