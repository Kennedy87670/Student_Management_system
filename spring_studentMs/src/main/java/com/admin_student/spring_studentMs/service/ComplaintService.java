package com.admin_student.spring_studentMs.service;

import com.admin_student.spring_studentMs.dto.ComplaintDto;
import com.admin_student.spring_studentMs.entity.Complaint;

import java.util.List;
import java.util.Optional;

public interface ComplaintService {
    Optional<ComplaintDto> getComplaintById(Long complaintId);

    Complaint save(Complaint complaint);

    void deleteComplaintById(Long complaintId);

    List<Complaint> getAllComplaints();

    ComplaintDto updateComplaintById(Long complaintId, ComplaintDto updatedComplaintDto);
}
