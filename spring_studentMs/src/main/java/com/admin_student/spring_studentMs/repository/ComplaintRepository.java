package com.admin_student.spring_studentMs.repository;

import com.admin_student.spring_studentMs.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
