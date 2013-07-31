package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.java.edu.gatech.cs2340.gradebook.model.Class;
import main.java.edu.gatech.cs2340.gradebook.model.*;

/**
 * Test for grade calculations.
 *
 * @author Brittany Wood
 */

@RunWith(JUnit4.class)
public class StandardGradingTest {
    Student student = new Student("Brittany Wood");
    GradebookCategory tests = new GradebookCategory("Tests", .51);
    GradebookCategory quizCategory = new GradebookCategory("Quizzes", .17);
    GradebookCategory finalExamCategory =
        new GradebookCategory("Final Exam", .32);
    GradebookItem test1 = new GradebookItem("Test 1", tests, 86.2);
    GradebookItem test2 = new GradebookItem("Test 2", tests, 72.23);
    GradebookItem test3 = new GradebookItem("Test 3", tests, 88);
    GradebookItem quizzes = new GradebookItem("Quizzes", quizCategory, 84.6);
    GradebookItem finalExam = new GradebookItem("Final Exam",
        finalExamCategory, 70);
    StandardGrading standard = new StandardGrading();
    ArrayList<GradebookItem> gradebookItems = new ArrayList<GradebookItem>();

    @Test
    public void testCreate() {
         assertNotNull("Grading creation failed.", standard);
    }

    @Test
    public void testScoreCalculation() {
         gradebookItems.add(test1);
         gradebookItems.add(test2);
         gradebookItems.add(test3);
         gradebookItems.add(quizzes);
         gradebookItems.add(finalExam);
         standard.addGradebookItems(gradebookItems);
         double score = standard.calculateScore();
         assertEquals(78.68, score, 0.00);
    }
}         
