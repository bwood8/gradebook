package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.java.edu.gatech.cs2340.gradebook.model.Class;
import main.java.edu.gatech.cs2340.gradebook.model.*;

/**
 * Test for Class class methods.
 *
 * @author Brittany Wood
 */

@RunWith(JUnit4.class)
public class ClassTest {
    Course course = new Course("CS", 2340, "Objects and Design");
    Class classAsClass = new Class(course, "Summer 2013");
    Course classAsCourse = new Class(course, "Summer 2013");
    Section section = new Section("A", classAsClass);
    GradebookCategory gradebookCategory = new GradebookCategory("Test", 1);
    Student newStudent = new Student("Brittany Wood");
    Student newStudent2 = new Student("Geoff Fountain");
    Student newStudent3 = new Student("Kathryn Black");
    Section section2 = new Section("B", classAsClass);
    Student newStudent4 = new Student("Ana Terron");
    Student newStudent5 = new Student("Lianne Lewis");

    @Test
    public void testCreate() {
        assertNotNull("Class as class failed", classAsClass);
        assertNotNull("Class as course failed", classAsCourse);
    }

    @Test
    public void testGetAndSet() {
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
       classAsClass.addSection(section);
       ArrayList<Section> sections = classAsClass.getSections();
       assertTrue("Section test failed.", sections.contains(section));
    }

    @Test
    public void testAverages() {
        newStudent.addGradebookItem(new GradebookItem("Test 1",
             gradebookCategory, 100));
        newStudent.addGradebookItem(new GradebookItem("Test 2",
             gradebookCategory, 20));
        newStudent2.addGradebookItem(new GradebookItem("Test 1",
             gradebookCategory, 85));
        newStudent2.addGradebookItem(new GradebookItem("Test 2",
             gradebookCategory, 90));
        newStudent3.addGradebookItem(new GradebookItem("Test 1",
             gradebookCategory, 90));
        newStudent3.addGradebookItem(new GradebookItem("Test 2",
             gradebookCategory, 85));
        section.addStudent(newStudent);
        section.addStudent(newStudent2);
        section.addStudent(newStudent3);
        newStudent4.addGradebookItem(new GradebookItem("Test 1",
             gradebookCategory, 85));
        newStudent4.addGradebookItem(new GradebookItem("Test 2",
             gradebookCategory, 85));
        newStudent5.addGradebookItem(new GradebookItem("Test 1",
             gradebookCategory, 85));
        newStudent5.addGradebookItem(new GradebookItem("Test 2",
             gradebookCategory, 75));
        section2.addStudent(newStudent4);
        section2.addStudent(newStudent5);
        classAsClass.addSection(section);
        classAsClass.addSection(section2);
        assertEquals(2, classAsClass.getSections().size());
        GradingScheme standard = new StandardGrading();
        double averageScore = classAsClass.calculateAverageScore(standard);
        assertEquals(80.41, averageScore, 0.00);
        String letterGrade = classAsClass.calculateLetterGrade(standard);
        assertEquals("LetterGrade calculation failed.","B", letterGrade);

    }
}
