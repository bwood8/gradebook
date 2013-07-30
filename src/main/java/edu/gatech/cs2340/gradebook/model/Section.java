package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

/**
 * A Section belongs to a Class and contains Students.
 *
 * @author Brittany Wood
 */

public class Section extends Class {
    private String sectionName;
    private Class parentClass;
    private ArrayList<Student> students = new ArrayList<Student>();
    private int averageScore;
    private String averageLetterGrade;

    public Section(String sectionName, Class parentClass) {
        super(parentClass.getCourse(), parentClass.getSemester());
        this.sectionName = sectionName;
        this.parentClass = parentClass;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public Class getParentClass() {
        return parentClass;
    }

    public void setParentClass(Class parentClass) {
        this.parentClass = parentClass;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }

    public int calculateAverageScore(GradingScheme gradingScheme) {
        double sum = 0;
        for (int i = 0; i < students.size(); i++) {
            sum += students.get(i).calculateScore(gradingScheme);
        }
        double finalScore = sum / students.size();
        averageScore = (int) finalScore;
        return averageScore;
    }

}
