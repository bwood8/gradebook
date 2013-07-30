package main.java.edu.gatech.cs2340.gradebook.model;

/**
 * Class representing GradebookCategories
 *
 * @author Brittany Wood
 */

public class GradebookCategory {
    private String name;
    private double percentWeight;

    public GradebookCategory(String aName, double aPercentWeight) {
        name = aName;
        percentWeight = aPercentWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public double getPercentWeight() {
        return percentWeight;
    }

    public void setPercentWeight(double aPercentWeight) {
        percentWeight = aPercentWeight;
    }
}
