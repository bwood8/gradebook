package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.java.edu.gatech.cs2340.gradebook.model.Class;
import main.java.edu.gatech.cs2340.gradebook.model.Course;
import main.java.edu.gatech.cs2340.gradebook.model.Section;
import main.java.edu.gatech.cs2340.gradebook.model.Student;

/**
 * Test for Section class methods.
 *
 * @author Brittany Wood
 */

@RunWith(JUnit4.class)
public class SectionTest {

    @Test
    public void testCreate() {
        Course course = new Course("CS", 2340, "Objects and Design");
        Class parentClass = new Class(course, "Summer 2013");
        Section section = new Section("A", parentClass);
        assertNotNull("Section creation failed.", section);
    }

    @Test
    public void testAddAndGetStudents() {
        Course course = new Course("CS", 2340, "Objects and Design");
        Class parentClass = new Class(course, "Summer 2013");
        Section section = new Section("A", parentClass);
        Student newStudent = new Student("Brittany Wood");
        section.addStudent(newStudent);
        ArrayList<Student> students = section.getStudents();
        assertTrue("Add and Get students failed.",
            students.contains(newStudent));
    }
}
