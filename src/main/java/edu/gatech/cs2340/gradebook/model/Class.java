package main.java.edu.gatech.cs2340.gradebook.model;

/*
 * A Class contains sections and reports the average score and letter grade
 * for the course.
 *
 * @author Brittany Wood
 */

public class Class extends Course {
    private String semester;
    private final Course course;

    public Class(Course course, String semester) {
        super(course.getSubject(), course.getCourseNumber(),
            course.getCourseName(), course.getPrerequisites());
        this.course = course;
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
