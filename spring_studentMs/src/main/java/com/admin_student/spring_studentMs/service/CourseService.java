package com.admin_student.spring_studentMs.service;

import com.admin_student.spring_studentMs.dto.CourseDto;
import com.admin_student.spring_studentMs.entity.Course;
import com.admin_student.spring_studentMs.errorAndException.CourseNotFoundException;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Optional<CourseDto> getCourseById(Long courseId) throws CourseNotFoundException;

    Course save(Course course);

    void deleteCourseById(Long courseId);

    List<Course> getAllCourses();

    CourseDto updateCourseById(Long courseId, CourseDto updatedCourseDto) throws CourseNotFoundException;
}
