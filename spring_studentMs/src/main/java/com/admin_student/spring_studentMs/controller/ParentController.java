package com.admin_student.spring_studentMs.controller;

import com.admin_student.spring_studentMs.dto.ParentsDto;
import com.admin_student.spring_studentMs.dto.StudentDto;
import com.admin_student.spring_studentMs.entity.Parents;
import com.admin_student.spring_studentMs.entity.Students;
import com.admin_student.spring_studentMs.errorAndException.ParentNotFoundException;
import com.admin_student.spring_studentMs.errorAndException.StudentNotFoundException;
import com.admin_student.spring_studentMs.mapper.ParentMapper;
import com.admin_student.spring_studentMs.mapper.StudentMapper;
import com.admin_student.spring_studentMs.service.ParentService;
import com.admin_student.spring_studentMs.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parents")
public class ParentController {

    @Autowired
    private final ParentService parentService;

    private final StudentService studentService;


    @GetMapping("/{id}")
    public ResponseEntity<ParentsDto> getParentById(@PathVariable("id") Long parentId) throws ParentNotFoundException {
        Optional<ParentsDto> parents = parentService.getParentById(parentId);
        if (parents.isPresent()){
            return  new ResponseEntity<>(parents.get(), HttpStatus.OK);
        }else {
            throw new ParentNotFoundException("Parent not found with id" + parentId);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ParentsDto> saveStudent(@RequestBody ParentsDto parentsDto){
        Parents saveParent = parentService.save(ParentMapper.mapToParent(parentsDto));
        return  new ResponseEntity<>(ParentMapper.mapToParentDto(saveParent), HttpStatus.CREATED);
    }

    @DeleteMapping("id")
    public ResponseEntity<String> deleteParentById(@PathVariable("id") Long parentId){
        parentService.deleteParentById(parentId);
        return new ResponseEntity<>("Parent successsfully deleted", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Parents>> getParentsList() {
        List<Parents> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ParentsDto> updateParentById(@PathVariable("id") Long parentId,
                                                      @RequestBody ParentsDto updatedParentDto) throws ParentNotFoundException {
        ParentsDto updatedParent = parentService.updateParentById(parentId, updatedParentDto);
        return ResponseEntity.ok(updatedParent);
    }

//     parent create student

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        Students savedStudent = studentService.save(StudentMapper.mapToStudent(studentDto));
        return new ResponseEntity<>(StudentMapper.maptToStudentDto(savedStudent), HttpStatus.CREATED);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId) throws StudentNotFoundException {
        Optional<StudentDto> students = studentService.getStudentById(studentId);
        if (students.isPresent()) {
            return new ResponseEntity<>(students.get(), HttpStatus.OK);
        } else {
            throw new StudentNotFoundException("Student not found with id: " + studentId);
        }
    }

    @PostMapping("/students/save")
    public ResponseEntity<StudentDto> saveStudent(@Valid @RequestBody StudentDto studentDto) {
        Students savedStudent = studentService.save(StudentMapper.mapToStudent(studentDto));
        return new ResponseEntity<>(StudentMapper.maptToStudentDto(savedStudent), HttpStatus.CREATED);
    }

}
