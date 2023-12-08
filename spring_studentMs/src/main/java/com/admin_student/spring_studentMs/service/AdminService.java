package com.admin_student.spring_studentMs.service;

import com.admin_student.spring_studentMs.dto.AdminDto;
import com.admin_student.spring_studentMs.entity.Admin;
import com.admin_student.spring_studentMs.errorAndException.AdminNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    public Optional<AdminDto> getAdminById(Long adminId) throws AdminNotFoundException;

   public Admin save(Admin admin);

    void deleteAdminById(Long adminId);

    public List<Admin> getAllAdmins();

    public AdminDto updateAdminById(Long adminId, AdminDto adminDto) throws AdminNotFoundException;
}
