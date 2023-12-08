package com.admin_student.spring_studentMs.repository;


import com.admin_student.spring_studentMs.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}