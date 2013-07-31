package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

/**
 * Interface for GradingSchemes which will allow for calcuation of
 * scores and letter grades.
 *
 * @author Brittany Wood
 */

public interface GradingScheme {
    double A_CUTOFF = 90.0;
    double B_CUTOFF = 80.0;
    double C_CUTOFF = 70.0;
    double D_CUTOFF = 60.0;

    void addGradebookItems(ArrayList<GradebookItem> gradebookItems);

    double calculateScore();

    String calculateLetterGrade(double score);
}
