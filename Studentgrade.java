package com.Assignment2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
class Student {
    int studentId;
    String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
}

class Course {
    int courseId;
    String courseName;

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }
}

public class Studentgrade {
    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    static HashMap<Integer, HashMap<Integer, Double>> grades = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nStudent Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Assign Grade");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: addCourse(); break;
                case 3: assignGrade(); break;
                case 4: calculateGPA(); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid Choice! Try Again.");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter Student ID and Name: ");
        students.add(new Student(sc.nextInt(), sc.next()));
        System.out.println("Student Added!");
    }

    static void addCourse() {
        System.out.print("Enter Course ID and Course Name: ");
        courses.add(new Course(sc.nextInt(), sc.next()));
        System.out.println("Course Added!");
    }

    static void assignGrade() {
        System.out.print("Enter Student ID, Course ID, and Grade: ");
        int studentId = sc.nextInt();
        int courseId = sc.nextInt();
        double grade = sc.nextDouble();

        grades.putIfAbsent(studentId, new HashMap<>());
        grades.get(studentId).put(courseId, grade);
        System.out.println("Grade Assigned!");
    }

    static void calculateGPA() {
        System.out.print("Enter Student ID to Calculate GPA: ");
        int studentId = sc.nextInt();

        if (!grades.containsKey(studentId)) {
            System.out.println("No grades found for this student!");
            return;
        }

        HashMap<Integer, Double> studentGrades = grades.get(studentId);
        double total = 0;
        for (double grade : studentGrades.values()) {
            total += grade;
        }
        double gpa = total / studentGrades.size();
        System.out.printf("GPA for Student ID %d: %.2f\n", studentId, gpa);
    }
}

