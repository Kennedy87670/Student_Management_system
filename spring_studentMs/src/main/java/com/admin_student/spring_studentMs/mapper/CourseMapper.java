package com.admin_student.spring_studentMs.mapper;

import com.admin_student.spring_studentMs.dto.CourseDto;
import com.admin_student.spring_studentMs.entity.Course;


public class CourseMapper {

    public static CourseDto mapToCourseDto(Course course){
        CourseDto courseDto = new CourseDto(
                course.getId(),
                course.getSubject(),
                course.getCode(),
                course.getDescription()
        );
        return courseDto;
    }

    public static Course mapToCourse(CourseDto courseDto){
        Course course = new Course(
                courseDto.getId(),
                courseDto.getSubject(),
                courseDto.getCode(),
                courseDto.getDescription()
        );
        return course;
    }
}
