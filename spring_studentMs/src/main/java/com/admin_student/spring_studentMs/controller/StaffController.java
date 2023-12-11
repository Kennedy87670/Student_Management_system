package com.admin_student.spring_studentMs.controller;

import com.admin_student.spring_studentMs.dto.StaffDto;
import com.admin_student.spring_studentMs.dto.ParentsDto;
import com.admin_student.spring_studentMs.dto.StudentDto;
import com.admin_student.spring_studentMs.entity.Parents;
import com.admin_student.spring_studentMs.entity.Staff;
import com.admin_student.spring_studentMs.entity.Students;
import com.admin_student.spring_studentMs.errorAndException.StaffNotFoundException;
import com.admin_student.spring_studentMs.errorAndException.ParentNotFoundException;
import com.admin_student.spring_studentMs.errorAndException.StudentNotFoundException;
import com.admin_student.spring_studentMs.mapper.StaffMapper;
import com.admin_student.spring_studentMs.mapper.ParentMapper;
import com.admin_student.spring_studentMs.mapper.StudentMapper;
import com.admin_student.spring_studentMs.service.StaffService;
import com.admin_student.spring_studentMs.service.ParentService;
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
@RequestMapping("/staff")
public class StaffController {
    private final StaffService staffService;
    private final StudentService studentService;
    private final ParentService parentService;

    @GetMapping("/{id}")
    public ResponseEntity<StaffDto> getAdminById(@PathVariable("id") Long adminId) throws StaffNotFoundException {
        Optional<StaffDto> admin = staffService.getAdminById(adminId);
        if (admin.isPresent()) {
            return new ResponseEntity<>(admin.get(), HttpStatus.OK);
        } else {
            throw new StaffNotFoundException("Staff not found with id: " + adminId);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<StaffDto> saveAdmin(@Valid @RequestBody StaffDto staffDto) {
        Staff savedStaff = staffService.save(StaffMapper.mapToAdmin(staffDto));
        return new ResponseEntity<>(StaffMapper.mapToAdminDto(savedStaff), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdminById(@PathVariable("id") Long adminId) {
        staffService.deleteAdminById(adminId);
        return new ResponseEntity<>("Staff successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Staff>> getAdminsList() {
        List<Staff> staff = staffService.getAllAdmins();
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StaffDto> updateAdminById(@PathVariable("id") Long adminId,
                                                    @RequestBody StaffDto updatedStaffDto) throws StaffNotFoundException {
        StaffDto updatedAdmin = staffService.updateAdminById(adminId, updatedStaffDto);
        return ResponseEntity.ok(updatedAdmin);
    }

    // admin controller for student

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId) throws StudentNotFoundException {
        Optional<StudentDto> students = studentService.getStudentById(studentId);
        if (students.isPresent()) {
            return new ResponseEntity<>(students.get(), HttpStatus.OK);
        } else {
            throw new StudentNotFoundException("Student not found with id: " + studentId);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        Students savedStudent = studentService.save(StudentMapper.mapToStudent(studentDto));
        return new ResponseEntity<>(StudentMapper.maptToStudentDto(savedStudent), HttpStatus.CREATED);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long studentId) {
        studentService.deleteStudentById(studentId);
        return new ResponseEntity<>("Student successfully deleted", HttpStatus.OK);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable("id") Long studentId,
                                                        @RequestBody StudentDto updatedStudentDto) throws StudentNotFoundException {
        StudentDto updatedStudent = studentService.updateStudentById(studentId, updatedStudentDto);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("/student/all")
    public ResponseEntity<List<Students>> getStudentsList() {

        List<Students> students = studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);

    }

    // admin controller for parent


    @GetMapping("/parents/{id}")
    public ResponseEntity<ParentsDto> getParentById(@PathVariable("id") Long parentId) throws ParentNotFoundException {
        Optional<ParentsDto> parents = parentService.getParentById(parentId);
        if (parents.isPresent()){
            return  new ResponseEntity<>(parents.get(), HttpStatus.OK);
        }else {
            throw new ParentNotFoundException("Parent not found with id" + parentId);
        }
    }

    @PostMapping("/parents/save")
    public ResponseEntity<ParentsDto> saveStudent(@RequestBody ParentsDto parentsDto){
        Parents saveParent = parentService.save(ParentMapper.mapToParent(parentsDto));
        return  new ResponseEntity<>(ParentMapper.mapToParentDto(saveParent), HttpStatus.CREATED);
    }

    @DeleteMapping("parents/id")
    public ResponseEntity<String> deleteParentById(@PathVariable("id") Long parentId){
        parentService.deleteParentById(parentId);
        return new ResponseEntity<>("Parent successsfully deleted", HttpStatus.OK);
    }

    @GetMapping("/parents/all")
    public ResponseEntity<List<Parents>> getParentsList() {
        List<Parents> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);

    }

    @PutMapping("/parents/{id}")
    public ResponseEntity<ParentsDto> updateParentById(@PathVariable("id") Long parentId,
                                                       @RequestBody ParentsDto updatedParentDto) throws ParentNotFoundException {
        ParentsDto updatedParent = parentService.updateParentById(parentId, updatedParentDto);
        return ResponseEntity.ok(updatedParent);
    }


}
