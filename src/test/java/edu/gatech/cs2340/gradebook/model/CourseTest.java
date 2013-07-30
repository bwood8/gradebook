package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.java.edu.gatech.cs2340.gradebook.model.Course;

/**
 * Test for Course class methods.
 *
 * @author Brittany Wood
 */

@RunWith(JUnit4.class)
public class CourseTest {

    @Test
    public void testGetAndCreate() {
        ArrayList<Course> prerequisites = new ArrayList<Course>();
        Course course = new Course("CS", 2340, "Objects and Design",
            prerequisites);
        assertNotNull("Course creation test failed.", course);
        String subject = course.getSubject();
        int courseNumber = course.getCourseNumber();
        String courseName = course.getCourseName();
        ArrayList<Course> retreievedPrereqs = course.getPrerequisites();
        assertEquals("CS", subject);
        assertEquals(2340, courseNumber);
        assertEquals("Objects and Design", courseName);
        assertSame(prerequisites, retreievedPrereqs);
    }

    @Test
    public void testSetters() {
        ArrayList<Course> prerequisites = new ArrayList<Course>();
        Course course = new Course("CS", 2340, "Objects and Design",                        prerequisites);
        course.setSubject("ISYE");
        course.setCourseNumber(3044);
        course.setCourseName("Simulation");
        prerequisites.add(new Course("ISYE", 2027, "Probability"));
        course.setPrerequisites(prerequisites);
        String subject = course.getSubject();
        int courseNumber = course.getCourseNumber();
        String courseName = course.getCourseName();
        ArrayList<Course> retreievedPrereqs = course.getPrerequisites();
        assertEquals("setSubject test failed.", "ISYE", subject);
        assertEquals("setCourseNumber test failed.", 3044, courseNumber);
        assertEquals("setCouseName test failed.","Simulation", courseName);
        assertSame("setPrerequisites test failed.", prerequisites, retreievedPrereqs);
    }
}
