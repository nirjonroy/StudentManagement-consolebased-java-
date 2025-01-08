package Model;

public class Course {
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    private String studentId;
    private String[] courses;

    // Constructor, Getters, and Setters
    public Course(String studentId, String[] courses) {
        this.studentId = studentId;
        this.courses = courses;
    }

}
