package edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import main.java.edu.gatech.cs2340.gradebook.model.Class;
import main.java.edu.gatech.cs2340.gradebook.model.*;

/**
 * Test for grade calculations with lowest grade dropped.
 *
 * @author Brittany Wood
 */

@RunWith(JUnit4.class)
public class DropLowestGradeTest {
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
    DropLowestGrade dropLowestGrade = new DropLowestGrade();
    ArrayList<GradebookItem> gradebookItems = new ArrayList<GradebookItem>();

    @Test
    public void testCreate() {
         assertNotNull("Grading creation failed.", dropLowestGrade);
    }

    @Test
    public void testScoreCalculation() {
         gradebookItems.add(test1);
         gradebookItems.add(test2);
         gradebookItems.add(test3);
         gradebookItems.add(quizzes);
         gradebookItems.add(finalExam);
         dropLowestGrade.addGradebookItems(gradebookItems);
         double score = dropLowestGrade.calculateScore();
         assertEquals(81.2, score, 0.00);
    }
}


