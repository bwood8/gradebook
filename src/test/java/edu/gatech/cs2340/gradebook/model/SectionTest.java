package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.java.edu.gatech.cs2340.gradebook.model.Class;
import main.java.edu.gatech.cs2340.gradebook.model.*;

/**
 * Test for Section class methods.
 *
 * @author Brittany Wood
 */

@RunWith(JUnit4.class)
public class SectionTest {
    Course course = new Course("CS", 2340, "Objects and Design");
    Class parentClass = new Class(course, "Summer 2013");
    Section section = new Section("A", parentClass);
    Student newStudent = new Student("Brittany Wood");
    GradebookCategory gradebookCategory = new GradebookCategory("Test", 1);
    Student newStudent2 = new Student("Geoff Fountain");
    Student newStudent3 = new Student("Kathryn Black");

    @Test
    public void testCreate() {
        assertNotNull("Section creation failed.", section);
    }

    @Test
    public void testAddAndGetStudents() {
        section.addStudent(newStudent);
        ArrayList<Student> students = section.getStudents();
        assertTrue("Add and Get students failed.",
            students.contains(newStudent));
    }

    @Test
    public void testAverages() {
        GradingScheme standard = new StandardGrading();
        newStudent.addGradebookItem(new GradebookItem("Test 1", 
            gradebookCategory, 100));
        newStudent.addGradebookItem(new GradebookItem("Test 2", 
            gradebookCategory, 20));
        section.addStudent(newStudent);
        String letterGrade = section.calculateLetterGrade(standard);
        assertEquals("LetterGrade calculation failed.","D", letterGrade);
        newStudent2.addGradebookItem(new GradebookItem("Test 1",
            gradebookCategory, 85));
        newStudent2.addGradebookItem(new GradebookItem("Test 2",
            gradebookCategory, 90));
        section.addStudent(newStudent2);
        newStudent3.addGradebookItem(new GradebookItem("Test 1",
            gradebookCategory, 90));
        newStudent3.addGradebookItem(new GradebookItem("Test 2",
            gradebookCategory, 85));
        section.addStudent(newStudent3);
        double averageScore = section.calculateAverageScore(standard);
        assertEquals(78.33, averageScore, 0.00);
    }
}
