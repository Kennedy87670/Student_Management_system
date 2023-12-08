package com.admin_student.spring_studentMs.controller;

import com.admin_student.spring_studentMs.dto.StudentDto;
import com.admin_student.spring_studentMs.entity.Students;
import com.admin_student.spring_studentMs.errorAndException.StudentNotFoundException;
import com.admin_student.spring_studentMs.mapper.StudentMapper;
import com.admin_student.spring_studentMs.service.StudentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId) throws StudentNotFoundException {
        Optional<StudentDto> students = studentService.getStudentById(studentId);
        if (students.isPresent()) {
            return new ResponseEntity<>(students.get(), HttpStatus.OK);
        } else {
            throw new StudentNotFoundException("Student not found with id: " + studentId);
        }
    }


    @PostMapping("/save")
    public ResponseEntity<StudentDto> saveStudent(@Valid @RequestBody StudentDto studentDto) {
        Students savedStudent = studentService.save(StudentMapper.mapToStudent(studentDto));
        return new ResponseEntity<>(StudentMapper.maptToStudentDto(savedStudent), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>("Student successfully deleted", HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Students>> getStudentsList() {

        List<Students> students = studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable("id") Long studentId,
                                                        @RequestBody StudentDto updatedStudentDto) throws StudentNotFoundException {
        StudentDto updatedStudent = studentService.updateStudentById(studentId, updatedStudentDto);
        return ResponseEntity.ok(updatedStudent);
    }



}
