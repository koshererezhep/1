package models;

import java.util.*;
public class Student extends Person {
    private static int idCounter = 1;
    private int studentID;
    private List<Integer> grades;
    public Student(String name, String surname, int age, boolean gender, List<Integer> grades) {
        super(name, surname, age, gender);
        this.studentID = idCounter++;
        this.grades = new ArrayList<>(grades);
    }
    public void addGrade(int grade) {
        grades.add(grade);
    }
    public double calculateGPA() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double totalPoints = 0.0;
        for (Integer grade : grades) {
            if (grade >= 90) {
                totalPoints += 4.0;
            } else if (grade >= 80) {
                totalPoints += 3.0;
            } else if (grade >= 70) {
                totalPoints += 2.0;
            } else if (grade >= 60) {
                totalPoints += 1.0;
            } else {
                totalPoints += 0.0;
            }
        }
        double gpa = totalPoints / grades.size();
        return gpa;
    }
    @Override
    public String toString() {
        return super.toString() + " I am a student with ID " + studentID + " .GPA: " + calculateGPA();
    }
}