package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

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

    public Course (String subject, int courseNumber, String courseName, 
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
}
