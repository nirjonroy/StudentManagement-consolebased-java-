package Controller;

import Model.Student;
import View.ConsoleView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdmissionController {
    private ConsoleView view;
    private boolean isAuthenticated = false;

    public AdmissionController() {
        view = new ConsoleView();
    }

    public void start() {
        if (authenticateUser()) {
            showMenu();
        } else {
            view.printMessage("Authentication failed. Exiting...");
        }
    }

    private boolean authenticateUser() {
        int attempts = 3;
        while (attempts > 0) {
            String username = view.getUsername();
            String password = view.getPassword();

            if (validateCredentials(username, password)) {
                view.printMessage("Authentication successful!");
                isAuthenticated = true;
                return true;
            } else {
                attempts--;
                view.printMessage("Invalid credentials. Attempts remaining: " + attempts);
            }
        }
        return false;
    }

    private boolean validateCredentials(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Data/users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            view.printMessage("Error reading user data.");
        }
        return false;
    }

    private void showMenu() {
        int choice;
        do {
            view.printMenu();
            choice = view.getUserInput();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudent();
                case 3 -> assignCourses();
                case 4 -> searchCourses();
                case 0 -> view.printMessage("Exiting...");
                default -> view.printMessage("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    private void addStudent() {
        Student student = view.getStudentDetails();
        saveStudentToFile(student);
    }

    private void saveStudentToFile(Student student) {
        try (FileWriter writer = new FileWriter("src/Data/students.txt", true)) {
            writer.write(String.format("%s,%s,%s,%s,%s,%.2f\n",
                    student.getId(),
                    student.getName(),
                    student.getProgram(),
                    student.getBatch(),
                    student.getPassword(),
                    student.getCgpa()));
            view.printMessage("Student added successfully!");
        } catch (IOException e) {
            view.printMessage("Error saving student data.");
        }
    }

    private void viewStudent() {
        String id = view.getStudentId();
        Student student = getStudentById(id);
        if (student != null) {
            view.displayStudentDetails(student);
        } else {
            view.printMessage("Student not found!");
        }
    }

    private Student getStudentById(String id) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Data/students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(id)) {
                    return new Student(parts[0], parts[1], parts[2], parts[3], parts[4], Double.parseDouble(parts[5]));
                }
            }
        } catch (IOException e) {
            view.printMessage("Error reading student data.");
        }
        return null;
    }

    private void assignCourses() {
        String id = view.getStudentId();
        String[] courses = view.getCourses();
        saveCoursesToFile(id, courses);
    }

    private void saveCoursesToFile(String studentId, String[] courses) {
        try (FileWriter writer = new FileWriter("src/Data/courses.txt", true)) {
            writer.write(studentId + "," + String.join(",", courses) + "\n");
            view.printMessage("Courses assigned successfully!");
        } catch (IOException e) {
            view.printMessage("Error saving course data.");
        }
    }

    private void searchCourses() {
        String id = view.getStudentId();
        List<String> courses = getCoursesByStudentId(id);
        if (!courses.isEmpty()) {
            view.displayCourses(courses);
        } else {
            view.printMessage("No courses found for this student.");
        }
    }

    private List<String> getCoursesByStudentId(String id) {
        List<String> courses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Data/courses.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(id)) {
                    for (int i = 1; i < parts.length; i++) {
                        courses.add(parts[i]);
                    }
                }
            }
        } catch (IOException e) {
            view.printMessage("Error reading course data.");
        }
        return courses;
    }
}
