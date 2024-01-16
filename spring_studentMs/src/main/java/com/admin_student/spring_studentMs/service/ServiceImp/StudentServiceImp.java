package com.admin_student.spring_studentMs.service.ServiceImp;

import com.admin_student.spring_studentMs.dto.StudentDto;
import com.admin_student.spring_studentMs.entity.Students;
import com.admin_student.spring_studentMs.errorAndException.StudentNotFoundException;
import com.admin_student.spring_studentMs.mapper.StudentMapper;
import com.admin_student.spring_studentMs.repository.StudentsRepository;
import com.admin_student.spring_studentMs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentServiceImp implements StudentService {

    private final StudentsRepository studentsRepository;

    @Override
    public Optional<StudentDto> getStudentById(Long studentId) throws StudentNotFoundException {
        return studentsRepository.findById(studentId)
                .map(StudentMapper::maptToStudentDto);
    }


    @Override
    public Students save(Students students) {
        return studentsRepository.save(students);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentsRepository.deleteById(studentId);
    }

    @Override
    public List<Students> getAllStudents() {

        return studentsRepository.findAll();
    }

    @Override
    public StudentDto updateStudentById(Long studentId, StudentDto studentDto) throws StudentNotFoundException {
        Optional<Students> optionalStudent = studentsRepository.findById(studentId);

        if (optionalStudent.isPresent()) {
            Students student = optionalStudent.get();

            student.setFirstName(studentDto.getFirstName());
            student.setLastName(studentDto.getLastName());
            student.setUserName(studentDto.getUserName());
            student.setEmail(studentDto.getEmail());
            student.setGrade(studentDto.getGrade());


            // Save the updated student
            studentsRepository.save(student);

            return StudentMapper.maptToStudentDto(student);

        } else {
            throw new StudentNotFoundException("Student not found with id: " + studentId);
        }
    }


}

