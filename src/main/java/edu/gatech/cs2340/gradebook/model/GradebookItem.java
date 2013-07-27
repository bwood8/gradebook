package main.java.edu.gatech.cs2340.gradebook.model;

public class GradebookItem {
    private String name;
    private GradebookCategory gradebookCategory;

    public GradebookItem (String name, GradebookCategory gradebookCategory) {
        this.name = name;
        this.gradebookCategory = gradebookCategory;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GradebookCategory getGradebookCategory() {
        return gradebookCategory;
    }

    public void setGradebookCategory(GradebookCategory gradebookCategory) {
        this.gradebookCategory = gradebookCategory;
    }

}
