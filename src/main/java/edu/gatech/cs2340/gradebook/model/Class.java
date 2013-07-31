package main.java.edu.gatech.cs2340.gradebook.model;

import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 * A Class contains sections and reports the average score and letter grade
 * for the course.
 *
 * @author Brittany Wood
 */

public class Class extends Course {
    private String semester;
    private final Course course;
    private ArrayList<Section> sections = new ArrayList<Section>();
    private boolean scoreCalculated;
    private String letterGrade;
    private double averageScore;

    public Class(Course course, String semester) {
        super(course.getSubject(), course.getCourseNumber(),
            course.getCourseName(), course.getPrerequisites());
        this.course = course;
        this.semester = semester;
    }

    public Course getCourse() {
        return course;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void addSection(Section section) {
        sections.add(section);
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public double calculateAverageScore(GradingScheme gradingScheme) {
        double sum = 0;
        for (int i = 0; i < sections.size(); i++) {
            sum += sections.get(i).calculateAverageScore(gradingScheme);
        }
        averageScore = sum / sections.size();
        averageScore = Double.parseDouble(
            new DecimalFormat("#.##").format(averageScore));
        return averageScore;
    }

    public String calculateLetterGrade(GradingScheme gradingScheme) {
         if (scoreCalculated) {
             letterGrade = gradingScheme.calculateLetterGrade(averageScore);
         } else {
             averageScore = calculateAverageScore(gradingScheme);
             letterGrade = gradingScheme.calculateLetterGrade(averageScore);
         }
         return letterGrade;
    }
}
