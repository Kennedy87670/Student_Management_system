package com.admin_student.spring_studentMs.service.ServiceImp;

import com.admin_student.spring_studentMs.repository.ScoreRepository;
import com.admin_student.spring_studentMs.service.ScoreService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ScoreServiceImpl implements ScoreService {

    private final ScoreRepository scoreRepository;
    @Override
    public String computeGrade(Double score) {
        return null;
    }
}
