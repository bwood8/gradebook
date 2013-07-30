package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

/**
 * A Student has a name and is given GradebookItem scores. The class reports
 * a score and letter grade based on a GradingScheme.
 *
 * @author Brittany Wood
 */
public class Student {
    private String name;
    private ArrayList<GradebookItem> gradebookItems =
        new ArrayList<GradebookItem>();
    private int score;
    private String letterGrade;
    private boolean scoreCalculated = false;

    public Student(String aName) {
        name = aName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<GradebookItem> getGradebookItems() {
        return gradebookItems;
    }

    public void addGradebookItem(GradebookItem gradebookItem) {
        gradebookItems.add(gradebookItem);
    }

    public int calculateScore(GradingScheme gradingScheme) {
         gradingScheme.addGradebookItems(gradebookItems);
         score = gradingScheme.calculateScore();
         scoreCalculated = true;
         return score;
    }

    public String calculateLetterGrade(GradingScheme gradingScheme) {
         if (scoreCalculated) {
             letterGrade = gradingScheme.calculateLetterGrade(score);
         } else {
             score = calculateScore(gradingScheme);
             letterGrade = gradingScheme.calculateLetterGrade(score);
         }
         return letterGrade;
    }
}
