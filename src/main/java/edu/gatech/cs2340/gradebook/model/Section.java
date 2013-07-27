package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;

public class Section extends Class {
    String sectionName;
    Class parentClass;
    ArrayList<Student> students = new ArrayList<Student>();

    public Section (String sectionName, Class parentClass) {
        super(parentClass.getCourse(), parentClass.getSemester());
        this.sectionName = sectionName;
        this.parentClass = parentClass;
    }

    public String getSectionName() {
        return sectionName;
    }

    public Class getParentClass() {
        return parentClass;
    }
    
    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student newStudent) {
        students.add(newStudent);
    }
}
