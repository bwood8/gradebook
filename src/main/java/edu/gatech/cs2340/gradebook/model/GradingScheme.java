package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

/**
 * Interface for GradingSchemes which will allow for calcuation of
 * scores and letter grades.
 *
 * @author Brittany Wood
 */

public interface GradingScheme {
    int A_CUTOFF = 90;
    int B_CUTOFF = 80;
    int C_CUTOFF = 70;
    int D_CUTOFF = 60;

    void addGradebookItems(ArrayList<GradebookItem> gradebookItems);

    int calculateScore();

    String calculateLetterGrade(int score);
}
