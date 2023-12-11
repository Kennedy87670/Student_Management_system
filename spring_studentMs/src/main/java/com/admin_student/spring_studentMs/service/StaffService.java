package com.admin_student.spring_studentMs.service;

import com.admin_student.spring_studentMs.dto.StaffDto;
import com.admin_student.spring_studentMs.entity.Staff;
import com.admin_student.spring_studentMs.errorAndException.StaffNotFoundException;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    public Optional<StaffDto> getAdminById(Long adminId) throws StaffNotFoundException;

   public Staff save(Staff staff);

    void deleteAdminById(Long adminId);

    public List<Staff> getAllAdmins();

    public StaffDto updateAdminById(Long adminId, StaffDto staffDto) throws StaffNotFoundException;
}
