package com.admin_student.spring_studentMs.repository;


import com.admin_student.spring_studentMs.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}