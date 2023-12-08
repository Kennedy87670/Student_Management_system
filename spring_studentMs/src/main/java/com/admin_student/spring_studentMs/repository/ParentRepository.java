package com.admin_student.spring_studentMs.repository;


import com.admin_student.spring_studentMs.entity.Parents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parents, Long> {
}

