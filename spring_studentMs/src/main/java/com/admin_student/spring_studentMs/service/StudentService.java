package com.admin_student.spring_studentMs.service;

import com.admin_student.spring_studentMs.dto.StudentDto;
import com.admin_student.spring_studentMs.entity.Students;
import com.admin_student.spring_studentMs.errorAndException.StudentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StudentService {



    public Optional<StudentDto> getStudentById(Long StudentId) throws StudentNotFoundException;

   public Students save(Students students);

  public void deleteStudentById(Long studentId);

   public List<Students> getAllStudents();

    StudentDto updateStudentById(Long studentId, StudentDto studentDto) throws StudentNotFoundException;

//    public StudentDto updateStudentById(Long studentId, StudentDto studentDto) throws StudentNotFoundException;
//    public StudentDto updateStudentById(Long studentId, StudentDto studentDto) throws StudentNotFoundException;

}
