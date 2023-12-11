package com.admin_student.spring_studentMs.service.ServiceImp;

import com.admin_student.spring_studentMs.entity.Grades;
import com.admin_student.spring_studentMs.entity.Score;
import com.admin_student.spring_studentMs.errorAndException.ScoreNotFoundException;
import com.admin_student.spring_studentMs.repository.ScoreRepository;
import com.admin_student.spring_studentMs.service.GradeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class GradeServiceImpl implements GradeService {

    private final ScoreRepository scoreRepository;
    private final Score

    @Override
    public String computeGrade(Double score) {
        scoreRepository.(scoreId).orElseThrow(() -> new ScoreNotFoundException("Score not found"));

        double actualScore =
        Grades[] values = Grades.values();

        for (Grades grade : values) {
            String[] scoreArr = grade.getScores().split("-");
            double minScore = Double.parseDouble(scoreArr[0]);
            double maxScore = Double.parseDouble(scoreArr[1]);
            if (score >= minScore && score <= maxScore) {
                return "Your Grade is : " + grade.name() +
                        " which is " + grade.getDescription();
            }
        }

        return "Invalid score";
    }


    public enum Grades {
        A_PLUS("90-100", "Excellent"), A("80-89", "Very Good"), B("65-79", "Good"),
        C("56-64", "Credit"), D("50-55", "Pass"), E("40-49", "Fair"),
        F("0-39", "Failed");

        private final String scores;
        private final String description;

        Grades(String s, String d) {
            scores = s;
            description = d;
        }

        public String getScores() {
            return scores;
        }

        public String getDescription() {
            return description;
        }
    }
}