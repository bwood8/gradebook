package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.java.edu.gatech.cs2340.gradebook.model.Class;
import main.java.edu.gatech.cs2340.gradebook.model.Course;
import main.java.edu.gatech.cs2340.gradebook.model.Section;

/**
 * Test for Class class methods.
 *
 * @author Brittany Wood
 */

@RunWith(JUnit4.class)
public class ClassTest {

    @Test
    public void testCreate() {
        Course course = new Course("CS", 2340, "Objects and Design");
        Class classAsClass = new Class(course, "Summer 2013");
        Course classAsCourse = new Class(course, "Summer 2013");
        assertNotNull("Class as class failed", classAsClass);
        assertNotNull("Class as course failed", classAsCourse);
    }

    @Test
    public void testGetAndSet() {
        Course course = new Course("CS", 2340, "Objects and Design");
        Class classAsClass = new Class(course, "Summer 2013");
        String subject = classAsClass.getSubject();
        int courseNumber = classAsClass.getCourseNumber();
        String courseName = classAsClass.getCourseName();
        String semester = classAsClass.getSemester();
        assertEquals("getSubject test failed.", "CS", subject);
        assertEquals("getCourseNumber test failed.", 2340, courseNumber);
        assertEquals("getCourseName test failed.", "Objects and Design",
            courseName);
        assertEquals("getSemester test failed.", "Summer 2013", semester);
    }

    @Test
    public void testAddAndGetSection() {
       Course course = new Course("CS", 2340, "Objects and Design");
       Class classAsClass = new Class(course, "Summer 2013");
       Section section = new Section("A", classAsClass);
       classAsClass.addSection(section);
       ArrayList<Section> sections = classAsClass.getSections();
       assertTrue("Section test failed.", sections.contains(section));
    }
}
