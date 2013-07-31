package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import java.text.DecimalFormat;
/**
 * Provides ability to calculate average score and letter grade using standard
 * calculation methods.
 *
 * @author Brittany Wood
 */

public class StandardGrading implements GradingScheme {

    private ArrayList<GradebookItem> gradebookItems;
    private double finalScore;
    private String letterGrade;

    public void addGradebookItems(ArrayList<GradebookItem> aGradebookItems) {
        gradebookItems = aGradebookItems;
    }

    public double calculateScore() {
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
        finalScore =
            Double.parseDouble(new DecimalFormat("#.##").format(score));
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

    public double getCategoryAverage(GradebookCategory category) {
        GradebookItem currentItem;
        GradebookCategory currentCategory = category;
        double runningTotal = 0;
        double counter = 0;
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
