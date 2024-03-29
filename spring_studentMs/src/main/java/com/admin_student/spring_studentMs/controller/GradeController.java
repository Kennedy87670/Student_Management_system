package com.admin_student.spring_studentMs.controller;


import com.admin_student.spring_studentMs.service.GradeService;
import lombok.AllArgsConstructor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/grade")
public class GradeController {
    private final GradeService gradeService;

    @GetMapping("/compute")
    public ResponseEntity<String> computeGrade(@RequestParam Double score) {
        String result = gradeService.computeGrade(score);
        return ResponseEntity.ok(result);
    }

    
//    GradeService gradeService;
//
//    @GetMapping("/student/{studentId}/course/{courseId}")
//    public ResponseEntity<Grade> getGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
//        return new ResponseEntity<>(gradeService.getGrade(studentId, courseId), HttpStatus.OK);
//    }
//
//    @PostMapping("/student/{studentId}/course/{courseId}")
//    public ResponseEntity<Grade> saveGrade(@Valid @RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {
//        return new ResponseEntity<>(gradeService.saveGrade(grade, studentId, courseId), HttpStatus.CREATED);
//    }
//
//
//    @PutMapping("/student/{studentId}/course/{courseId}")
//    public ResponseEntity<Grade> updateGrade(@Valid @RequestBody Grade grade, @PathVariable Long studentId, @PathVariable Long courseId) {
//        return new ResponseEntity<>(gradeService.updateGrade(grade.getScore(), studentId, courseId), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/student/{studentId}/course/{courseId}")
//    public ResponseEntity<HttpStatus> deleteGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
//        gradeService.deleteGrade(studentId, courseId);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @GetMapping("/student/{studentId}")
//    public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable Long studentId) {
//        return new ResponseEntity<>(gradeService.getStudentGrades(studentId), HttpStatus.OK);
//    }
//
//    @GetMapping("/course/{courseId}")
//    public ResponseEntity<List<Grade>> getCourseGrades(@PathVariable Long courseId) {
//        return new ResponseEntity<>(gradeService.getCourseGrades(courseId), HttpStatus.OK);
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<List<Grade>> getGrades() {
//        return new ResponseEntity<>(gradeService.getAllGrades(), HttpStatus.OK);
//    }

}
