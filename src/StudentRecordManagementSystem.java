import java.util.ArrayList;
import java.util.Scanner;

// Class to store student details
class Student {
    String name;
    String id;
    int age;
    String grade;

    // Constructor
    public Student(String name, String id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }
}

// Class to manage the students
class StudentManagement {
    static ArrayList<Student> studentList = new ArrayList<>();
    static int totalStudents = 0;

    // Method to add a new student
    static void addStudent(String name, String id, int age, String grade) {
        Student newStudent = new Student(name, id, age, grade);
        studentList.add(newStudent);
        totalStudents++;
        System.out.println("Student added successfully!");
    }

    // Method to update student information
    static void updateStudent(String id, String name, int age, String grade) {
        for (Student student : studentList) {
            if (student.id.equals(id)) {
                student.name = name;
                student.age = age;
                student.grade = grade;
                System.out.println("Student information updated successfully!");
                return;
            }
        }
        System.out.println("Error: Student ID not found!");
    }

    // Method to view student details
    static void viewStudent(String id) {
        for (Student student : studentList) {
            if (student.id.equals(id)) {
                System.out.println("Student ID: " + student.id);
                System.out.println("Student Name: " + student.name);
                System.out.println("Student Age: " + student.age);
                System.out.println("Student Grade: " + student.grade);
                return;
            }
        }
        System.out.println("Error: Student ID not found!");
    }
}

// Main class to provide the administrator interface
public class StudentRecordManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Student Record Management System ===");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // Input validation handling
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Adding new student
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();
                    StudentManagement.addStudent(name, id, age, grade);
                    break;
                case 2:
                    // Updating student information
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    break;
                case 3:
                    // Viewing student details
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student ID to view: ");
                    String viewId = scanner.nextLine();
                    StudentManagement.viewStudent(viewId);
                    break;
                case 4:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}