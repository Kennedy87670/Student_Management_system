package com.admin_student.spring_studentMs.entity;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@Getter
@Table(name = "grades")
public enum Grades {
    A_PLUS("90-100", "Excellent"), A("80-89", "Very Good"), B("65-79", "Good"),
    C("56-64", "Credit"), D("50-55", "Pass"), E("40-49", "Fair"),
    F("0-39", "Failed");

    Grades(String s, String d) {
        scores = s;
        description = d;
    }

    private String scores;
    private String description;

    public void setScores(String scores) {
        this.scores = scores;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static String gradeCompute(double val) {
        for (Grades grade : Grades.values()) {
            String[] scoreArr = grade.scores.split("-");
            double minScore = Double.parseDouble(scoreArr[0]);
            double maxScore = Double.parseDouble(scoreArr[1]);
            if (val >= minScore && val <= maxScore) {
                System.out.println("Your Grade is : " + grade
                        + " which is " + grade.description + "\n\n");
            }
        }

        return null;
    }

}
