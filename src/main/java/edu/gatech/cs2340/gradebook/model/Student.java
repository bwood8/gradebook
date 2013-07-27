package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

/*
 * A Student has a name and is given GradebookItem scores. The class reports 
 * a score and letter grade based on a GradingScheme.
 *
 * @author Brittany Wood
 */

public class Student {
    private String name;
    private ArrayList<GradebookItem> gradebookItems = 
        new ArrayList<GradebookItem>();

    public Student(String name) {
        this.name = name;
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
}
