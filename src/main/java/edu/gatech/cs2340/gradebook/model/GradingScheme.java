package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

/**
 * Interface for GradingSchemes which will allow for calcuation of
 * scores and letter grades.
 *
 * @author Brittany Wood
 */

public interface GradingScheme {

    void addGradebookItems(ArrayList<GradebookItem> gradebookItems);

    int calculateScore();

    String calculateLetterGrade();
}
