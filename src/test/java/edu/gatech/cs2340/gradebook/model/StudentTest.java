package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.java.edu.gatech.cs2340.gradebook.model.Class;
import main.java.edu.gatech.cs2340.gradebook.model.*;

/**
 * Tests for Student methods.
 *
 * @author Brittany Wood
 */

@RunWith(JUnit4.class)
public class StudentTest {
    private Student student = new Student("Brittany Wood");
    private Student student2 = new Student("Geoff Fountain");
    private GradebookCategory gradebookCategory = 
        new GradebookCategory("HW", 1);
    private GradebookItem gradebookItem = new GradebookItem("HW 1",
        gradebookCategory, 92);
    private GradebookItem gradebookItem2 = new GradebookItem("HW 2",
        gradebookCategory, 87);

    @Test
    public void testCreate() {
        assertNotNull("Create student failed.", student);
        assertNotNull("Create student 2 failed.", student2);
    }

    @Test
    public void testGetAndSet() {
        assertEquals("Brittany Wood", student.getName());
        student2.setName("Kathryn Black");
        assertEquals("Kathryn Black", student2.getName());
    }

    @Test
    public void testGradebookItems() {
        student.addGradebookItem(gradebookItem);
        assertNotNull("add or getGradebookItems failed.",
            student.getGradebookItems());
    }

    @Test
    public void testAverageCalculations() {
        student.addGradebookItem(gradebookItem);
        student.addGradebookItem(gradebookItem2);
        double studentScore = student.calculateScore(new StandardGrading());
        assertEquals(89.5, studentScore, 0.00);
    }
}        
