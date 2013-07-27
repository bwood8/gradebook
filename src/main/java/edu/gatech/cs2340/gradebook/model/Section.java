package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

/* 
 * A Section belongs to a Class and contains Students. It reports the 
 * average score a letter grade for the section.
 *
 * @author Brittany Wood
 */

public class Section extends Class {
    private String sectionName;
    private Class parentClass;
    private ArrayList<Student> students = new ArrayList<Student>();

    public Section (String sectionName, Class parentClass) {
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
}
