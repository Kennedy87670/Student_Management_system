package com.admin_student.spring_studentMs.service.ServiceImp;

import com.admin_student.spring_studentMs.dto.AdminDto;
import com.admin_student.spring_studentMs.entity.Admin;
import com.admin_student.spring_studentMs.errorAndException.AdminNotFoundException;
import com.admin_student.spring_studentMs.mapper.AdminMapper;
import com.admin_student.spring_studentMs.repository.AdminRepository;
import com.admin_student.spring_studentMs.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminserviceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public Optional<AdminDto> getAdminById(Long adminId) throws AdminNotFoundException {
        return adminRepository.findById(adminId)
                .map(AdminMapper::mapToAdminDto);
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdminById(Long adminId) {
        adminRepository.deleteById(adminId);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public AdminDto updateAdminById(Long adminId, AdminDto adminDto) throws AdminNotFoundException {
        Optional<Admin> optionalAdmin = adminRepository.findById(adminId);

        if (optionalAdmin.isPresent()) {
            Admin admin = optionalAdmin.get();

            admin.setFirstName(adminDto.getFirstName());
            admin.setLastName(adminDto.getLastName());
            admin.setUserName(adminDto.getUserName());
            admin.setEmail(adminDto.getEmail());

            // Save the updated admin
            adminRepository.save(admin);

            return AdminMapper.mapToAdminDto(admin);

        } else {
            throw new AdminNotFoundException("Admin not found with id: " + adminId);
        }
    }
}
