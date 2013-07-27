package main.java.edu.gatech.cs2340.gradebook.model;

public class Class extends Course {
    String semester;
    Course course;

    public Class (Course course, String semester) {
        super(course.getSubject(), course.getCourseNumber(), course.getCourseName(), course.getPrerequisites());
        this.course = course;
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }
    
    public String getSemester() {
        return semester;
    }
}
