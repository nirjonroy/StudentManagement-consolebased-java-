package Model;

public class Student {
    private String id;
    private String name;
    private String program;
    private String batch;
    private String password;
    private double cgpa;

    // Constructor
    public Student(String id, String name, String program, String batch, String password, double cgpa) {
        this.id = id;
        this.name = name;
        this.program = program;
        this.batch = batch;
        this.password = password;
        this.cgpa = cgpa;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}
