package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * A Course has a subject, course number, name, and prerequisite courses.
 *
 * @author Brittany Wood
 */

public class Course {
    private String subject;
    private int courseNumber;
    private String courseName;
    private ArrayList<Course> prerequisites;
    private boolean scoreCalculated = false;
    private String letterGrade;
    private double averageScore;
    private ArrayList<Class> classes = new ArrayList<Class>();

    public Course(String subject, int courseNumber, String courseName) {
        this.subject = subject;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
    }

    public Course(String subject, int courseNumber, String courseName,
            ArrayList<Course> prerequisites) {
        this.subject = subject;
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.prerequisites = prerequisites;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public ArrayList<Course> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(ArrayList<Course> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public void addClass(Class newClass) {
        classes.add(newClass);
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public double calculateAverageScore(GradingScheme gradingScheme) {
        double sum = 0;
        for (int i = 0; i < classes.size(); i++) {
            sum += classes.get(i).calculateAverageScore(gradingScheme);
        }
        averageScore = sum / classes.size();
        averageScore = Double.parseDouble(
            new DecimalFormat("#.##").format(averageScore));
        scoreCalculated = true;
        return averageScore;
    }

    public String calculateLetterGrade(GradingScheme gradingScheme) {
         if (scoreCalculated) {
             letterGrade = gradingScheme.calculateLetterGrade(averageScore);
         } else {
             averageScore = calculateAverageScore(gradingScheme);
             letterGrade = gradingScheme.calculateLetterGrade(averageScore);
         }
         return letterGrade;
    }
}
