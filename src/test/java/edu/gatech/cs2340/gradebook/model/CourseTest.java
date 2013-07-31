package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.java.edu.gatech.cs2340.gradebook.model.Class;
import main.java.edu.gatech.cs2340.gradebook.model.*;

/**
 * Test for Course class methods.
 *
 * @author Brittany Wood
 */

@RunWith(JUnit4.class)
public class CourseTest {
    ArrayList<Course> prerequisites = new ArrayList<Course>();
    Course course = new Course("CS", 2340, "Objects and Design",
        prerequisites);
    Class classOne = new Class(course, "Summer 2013");
    Class classTwo = new Class(course, "Summer 2013");
    Section section = new Section("A", classOne);
    Section section2 = new Section("B", classTwo);
    GradebookCategory gradebookCategory = new GradebookCategory("Test", 1);
    Student newStudent = new Student("Brittany Wood");
    Student newStudent2 = new Student("Geoff Fountain");
    Student newStudent3 = new Student("Kathryn Black");
    Student newStudent4 = new Student("Ana Terron");
    Student newStudent5 = new Student("Lianne Lewis");

    @Test
    public void testGetAndCreate() {
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
        newStudent4.addGradebookItem(new GradebookItem("Test 1",
             gradebookCategory, 85));
        newStudent4.addGradebookItem(new GradebookItem("Test 2",
             gradebookCategory, 85));
        newStudent5.addGradebookItem(new GradebookItem("Test 1",
             gradebookCategory, 85));
        newStudent5.addGradebookItem(new GradebookItem("Test 2",
             gradebookCategory, 75));
        section.addStudent(newStudent);
        section.addStudent(newStudent2);
        section.addStudent(newStudent3);
        section2.addStudent(newStudent4);
        section2.addStudent(newStudent5);
        classOne.addSection(section);
        classTwo.addSection(section2);
        course.addClass(classOne);
        course.addClass(classTwo);
        GradingScheme standard = new StandardGrading();
        String letterGrade = course.calculateLetterGrade(standard);
        assertEquals("LetterGrade calculation failed.", "B", letterGrade);
        double averageScore = course.calculateAverageScore(standard);
        assertEquals(80.41, averageScore, 0.00);
    }
}
