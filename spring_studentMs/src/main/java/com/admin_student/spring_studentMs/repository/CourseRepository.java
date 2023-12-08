package com.admin_student.spring_studentMs.repository;

import com.admin_student.spring_studentMs.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Long> {
}
