package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

/*
 * Interface for GradingSchemes which will allow for calcuation of
 * scores and letter grades.
 *
 * @author Brittany Wood
 */

public interface GradingScheme {

    public void addGradebookItems(ArrayList<GradebookItem> gradebookItems);

    public int calculateScore();

    public String calculateLetterGrade();


}
