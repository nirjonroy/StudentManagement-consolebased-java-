package View;

import Model.Student;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner = new Scanner(System.in);

    public void printMenu() {
        System.out.println("\n1. Add Student");
        System.out.println("2. View Student");
        System.out.println("3. Assign Courses");
        System.out.println("4. Search Courses");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public int getUserInput() {
        return scanner.nextInt();
    }

    public String getUsername() {
        System.out.print("Enter username: ");
        return scanner.next();
    }

    public String getPassword() {
        System.out.print("Enter password: ");
        return scanner.next();
    }

    public Student getStudentDetails() {
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Program: ");
        String program = scanner.nextLine();
        System.out.print("Enter Batch: ");
        String batch = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();
        return new Student(id, name, program, batch, password, cgpa);
    }

    public String getStudentId() {
        System.out.print("Enter Student ID: ");
        return scanner.next();
    }

    public String[] getCourses() {
        System.out.print("Enter courses (comma-separated): ");
        scanner.nextLine(); // Consume newline
        String courseInput = scanner.nextLine();
        return courseInput.split(",");
    }

    public void displayStudentDetails(Student student) {
        System.out.println("\nStudent Details:");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Program: " + student.getProgram());
        System.out.println("Batch: " + student.getBatch());
        System.out.println("CGPA: " + student.getCgpa());
    }

    public void displayCourses(List<String> courses) {
        System.out.println("\nCourses:");
        courses.forEach(System.out::println);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
