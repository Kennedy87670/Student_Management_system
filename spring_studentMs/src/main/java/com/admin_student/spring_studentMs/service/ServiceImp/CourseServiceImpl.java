package com.admin_student.spring_studentMs.service.ServiceImp;

import com.admin_student.spring_studentMs.dto.CourseDto;
import com.admin_student.spring_studentMs.entity.Course;
import com.admin_student.spring_studentMs.errorAndException.CourseNotFoundException;
import com.admin_student.spring_studentMs.mapper.CourseMapper;
import com.admin_student.spring_studentMs.repository.CourseRepository;
import com.admin_student.spring_studentMs.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public Optional<CourseDto> getCourseById(Long courseId) throws CourseNotFoundException {
        return courseRepository.findById(courseId)
                .map(CourseMapper::mapToCourseDto);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public CourseDto updateCourseById(Long courseId, CourseDto courseDto) throws CourseNotFoundException {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();

            course.setSubject(courseDto.getSubject());
            course.setCode(courseDto.getCode());
            course.setDescription(courseDto.getDescription());


            // Save the updated course
            courseRepository.save(course);

            return CourseMapper.mapToCourseDto(course);

        } else {
            throw new CourseNotFoundException("Course not found with id: " + courseId);
        }
    }
}
