package com.admin_student.spring_studentMs.controller;

import com.admin_student.spring_studentMs.dto.CourseDto;
import com.admin_student.spring_studentMs.entity.Course;
import com.admin_student.spring_studentMs.errorAndException.CourseNotFoundException;
import com.admin_student.spring_studentMs.mapper.CourseMapper;
import com.admin_student.spring_studentMs.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;


    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable("id") Long courseId) throws CourseNotFoundException {
        Optional<CourseDto> course = courseService.getCourseById(courseId);
        if (course.isPresent()) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK);
        } else {
            throw new CourseNotFoundException("Course not found with id" + courseId);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<CourseDto> saveCourse(@RequestBody CourseDto courseDto) {
        Course savedCourse = courseService.save(CourseMapper.mapToCourse(courseDto));
        return new ResponseEntity<>(CourseMapper.mapToCourseDto(savedCourse), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable("id") Long courseId) {
        courseService.deleteCourseById(courseId);
        return new ResponseEntity<>("Course successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getCoursesList() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourseById(@PathVariable("id") Long courseId,
                                                      @RequestBody CourseDto updatedCourseDto) throws CourseNotFoundException {
        CourseDto updatedCourse = courseService.updateCourseById(courseId, updatedCourseDto);
        return ResponseEntity.ok(updatedCourse);
    }

}