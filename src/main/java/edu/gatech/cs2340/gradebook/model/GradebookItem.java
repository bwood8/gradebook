package main.java.edu.gatech.cs2340.gradebook.model;

/**
 * A class to represent gradebook items which have a name, GradebookCategory,
 * and a score.
 *
 * @author Brittany Wood
 */

public class GradebookItem {
    private String name;
    private GradebookCategory gradebookCategory;
    private int score;

    public GradebookItem(String aName, GradebookCategory aGradebookCategory,
             int aScore) {
        name = aName;
        gradebookCategory = aGradebookCategory;
        score = aScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public GradebookCategory getGradebookCategory() {
        return gradebookCategory;
    }

    public void setGradebookCategory(GradebookCategory aGradebookCategory) {
        gradebookCategory = aGradebookCategory;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int aScore) {
        score = aScore;
    }
}
