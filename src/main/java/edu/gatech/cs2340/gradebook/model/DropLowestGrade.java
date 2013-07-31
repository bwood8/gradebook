package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

/**
 * Provides ability to calculate average score and letter grade which drops
 * the lowest grade, given there is at least one category with more than
 * one grade in it.
 *
 * @author Brittany Wood
 */

public class DropLowestGrade extends StandardGrading implements GradingScheme {

    private ArrayList<GradebookItem> gradebookItems;
    private double finalScore;
    private String letterGrade;
    private boolean haveNotDropped = true;

    public void addGradebookItems(ArrayList<GradebookItem> aGradebookItems) {
        gradebookItems = aGradebookItems;
    }

    public void dropLowestGrade() {
        if (gradebookItems.size() > 1) {
            int lowestGradeIndex = 0;
            for (int i = 1; i < gradebookItems.size(); i++) {
                GradebookCategory currentCategory =
                    gradebookItems.get(i).getGradebookCategory();
                if (checkIfDropEligible(currentCategory)) {
                    if (gradebookItems.get(i).getScore()
                           < gradebookItems.get(lowestGradeIndex).getScore()) {
                        lowestGradeIndex = i;
                    }
                }
            }
            gradebookItems.remove(lowestGradeIndex);
        }
    }

    public double calculateScore() {
        if (haveNotDropped) {
            dropLowestGrade();
            haveNotDropped = false;
        }
        super.addGradebookItems(gradebookItems);
        finalScore = super.calculateScore();
        return finalScore;
    }

    public String calculateLetterGrade(double score) {
        if (score >= GradingScheme.A_CUTOFF) {
             letterGrade = "A";
        } else if (score >= GradingScheme.B_CUTOFF) {
            letterGrade = "B";
        } else if (score >= GradingScheme.C_CUTOFF) {
            letterGrade = "C";
        } else if (score >= GradingScheme.D_CUTOFF) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }
        return letterGrade;
    }

    public boolean checkIfDropEligible(GradebookCategory gradebookCategory) {
        int counter = 0;
        boolean result = false;
        for (int i = 0; i < gradebookItems.size(); i++) {
            if (gradebookItems.get(i).getGradebookCategory()
                    == gradebookCategory) {
                counter++;
                if (counter > 1) {
                    result = true;
                }
            }
        }
        return result;
    }
}
