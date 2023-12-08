package com.admin_student.spring_studentMs.controller;

import com.admin_student.spring_studentMs.dto.AdminDto;
import com.admin_student.spring_studentMs.dto.ParentsDto;
import com.admin_student.spring_studentMs.dto.StudentDto;
import com.admin_student.spring_studentMs.entity.Admin;
import com.admin_student.spring_studentMs.entity.Parents;
import com.admin_student.spring_studentMs.entity.Students;
import com.admin_student.spring_studentMs.errorAndException.AdminNotFoundException;
import com.admin_student.spring_studentMs.errorAndException.ParentNotFoundException;
import com.admin_student.spring_studentMs.errorAndException.StudentNotFoundException;
import com.admin_student.spring_studentMs.mapper.AdminMapper;
import com.admin_student.spring_studentMs.mapper.ParentMapper;
import com.admin_student.spring_studentMs.mapper.StudentMapper;
import com.admin_student.spring_studentMs.repository.StudentsRepository;
import com.admin_student.spring_studentMs.service.AdminService;
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
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;
    private final StudentService studentService;
    private final ParentService parentService;

    @GetMapping("/{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable("id") Long adminId) throws AdminNotFoundException {
        Optional<AdminDto> admin = adminService.getAdminById(adminId);
        if (admin.isPresent()) {
            return new ResponseEntity<>(admin.get(), HttpStatus.OK);
        } else {
            throw new AdminNotFoundException("Admin not found with id: " + adminId);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<AdminDto> saveAdmin(@Valid @RequestBody AdminDto adminDto) {
        Admin savedAdmin = adminService.save(AdminMapper.mapToAdmin(adminDto));
        return new ResponseEntity<>(AdminMapper.mapToAdminDto(savedAdmin), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdminById(@PathVariable("id") Long adminId) {
        adminService.deleteAdminById(adminId);
        return new ResponseEntity<>("Admin successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAdminsList() {
        List<Admin> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminDto> updateAdminById(@PathVariable("id") Long adminId,
                                                    @RequestBody AdminDto updatedAdminDto) throws AdminNotFoundException {
        AdminDto updatedAdmin = adminService.updateAdminById(adminId, updatedAdminDto);
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
