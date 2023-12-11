package com.admin_student.spring_studentMs.repository;


import com.admin_student.spring_studentMs.entity.Grades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grades, Long> {
}
