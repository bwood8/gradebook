package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

/**
 * Provides ability to calculate average score and letter grade which drops
 * the lowest grade
 *
 * @author Brittany Wood
 */

public class DropLowestGrade implements GradingScheme {

    private ArrayList<GradebookItem> gradebookItems;
    private int finalScore;
    private String letterGrade;
    private boolean haveNotDropped = true;

    public void addGradebookItems(ArrayList<GradebookItem> aGradebookItems) {
        gradebookItems = aGradebookItems;
    }

    public void dropLowestGrade() {
        int lowestGradeIndex = 0;
        for (int i = 1; i < gradebookItems.size(); i++) {
            if (gradebookItems.get(i).getScore()
                    < gradebookItems.get(lowestGradeIndex).getScore()) {
                lowestGradeIndex = i;
            }
        }
        gradebookItems.remove(lowestGradeIndex);
    }

    public int calculateScore() {
        if (haveNotDropped) {
            dropLowestGrade();
            haveNotDropped = false;
        }
        ArrayList<GradebookCategory> categoriesCalculated =
            new ArrayList<GradebookCategory>();
        double score = 0;
        double categoryScore;
        double categoryWeight;
        GradebookCategory currentCategory;
        GradebookItem currentItem;
        for (int i = 0; i < gradebookItems.size(); i++) {
            currentItem = gradebookItems.get(i);
            currentCategory = currentItem.getGradebookCategory();
            if (!categoriesCalculated.contains(currentCategory)) {
                categoryScore = getCategoryAverage(currentCategory);
                categoryWeight = currentCategory.getPercentWeight();
                score += (categoryScore * categoryWeight);
                categoriesCalculated.add(currentCategory);
            }
        }
        finalScore = (int) Math.round(score);
        return finalScore;
    }

    public String calculateLetterGrade(int score) {
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

    public double getCategoryAverage(GradebookCategory category) {
        GradebookItem currentItem;
        GradebookCategory currentCategory = category;
        int runningTotal = 0;
        int counter = 0;
        for (int i = 0; i < gradebookItems.size(); i++) {
            currentItem = gradebookItems.get(i);
            if (currentItem.getGradebookCategory() == currentCategory) {
                runningTotal += currentItem.getScore();
                counter++;
            }
        }
        return runningTotal / counter;
    }
}
