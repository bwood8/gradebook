package main.java.edu.gatech.cs2340.gradebook.model;

public class GradebookCategory {
    private String name;
    private int percentWeight;

    public GradebookCategory(String name, int percentWeight) {
        this.name = name;
        this.percentWeight = percentWeight;
    }

    public String getName() {
        return name;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public int getPercentWeight() {
        return percentWeight;
    }

    public void setPercentWeight(int percentWeight) {
        this.percentWeight = percentWeight;
    }
}
