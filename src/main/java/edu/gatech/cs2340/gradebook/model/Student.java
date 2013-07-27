package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

public class Student {
    String name;
    ArrayList<GradebookItem> gradebookItems = new ArrayList<GradebookItem>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public ArrayList<GradebookItem> getGradebookItems() {
        return gradebookItems;
    }

    public void addGradebookItem(GradebookItem newGrade) {
        gradebookItems.add(newGrade);
    }

}
