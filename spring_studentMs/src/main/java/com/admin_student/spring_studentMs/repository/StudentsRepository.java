package com.admin_student.spring_studentMs.repository;

import com.admin_student.spring_studentMs.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students,Long> {

}
