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

    @Test
    public void testAverages() {
        Course course = new Course("CS", 2340, "Objects and Design");
        Class parentClass = new Class(course, "Summer 2013");
        Section section = new Section("A", parentClass);
        Student newStudent = new Student("Brittany Wood");
        GradebookCategory gradebookCategory = new GradebookCategory("Test", 1);
        newStudent.addGradebookItem(new GradebookItem("Test 1", 
            gradebookCategory, 100));
        newStudent.addGradebookItem(new GradebookItem("Test 2", 
            gradebookCategory, 20));
        section.addStudent(newStudent);
        int averageScore = section.calculateAverageScore(
             new DropLowestGrade());
        assertEquals("AverageScore calculation failed.", 100, averageScore);
        String letterGrade = section.calculateLetterGrade(
            new DropLowestGrade());
        assertEquals("LetterGrade calculation failed.","A", letterGrade);
        Student newStudent2 = new Student("Geoff Fountain");
        newStudent2.addGradebookItem(new GradebookItem("Test 1",
            gradebookCategory, 85));
        newStudent2.addGradebookItem(new GradebookItem("Test 2",
            gradebookCategory, 90));
        int geoffAverage = newStudent2.calculateScore(new DropLowestGrade());
        assertEquals("Geoff's calculation failed.", 90, geoffAverage);
        section.addStudent(newStudent2);
        assertEquals(90, section.getStudents().get(0).calculateScore(new DropLowestGrade()));
        averageScore = section.calculateAverageScore(new DropLowestGrade());
        assertEquals("Test", 2, section.getStudents().size());
        assertEquals("Two student averageScore calculation failed.", 95, 
            averageScore);
    }
}
