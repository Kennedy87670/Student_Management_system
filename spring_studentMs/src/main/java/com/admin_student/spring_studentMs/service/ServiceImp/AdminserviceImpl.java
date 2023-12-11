package com.admin_student.spring_studentMs.service.ServiceImp;

import com.admin_student.spring_studentMs.dto.StaffDto;
import com.admin_student.spring_studentMs.entity.Staff;
import com.admin_student.spring_studentMs.errorAndException.StaffNotFoundException;
import com.admin_student.spring_studentMs.mapper.StaffMapper;
import com.admin_student.spring_studentMs.repository.StaffRepository;
import com.admin_student.spring_studentMs.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminserviceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Override
    public Optional<StaffDto> getAdminById(Long adminId) throws StaffNotFoundException {
        return staffRepository.findById(adminId)
                .map(StaffMapper::mapToAdminDto);
    }

    @Override
    public Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public void deleteAdminById(Long adminId) {
        staffRepository.deleteById(adminId);
    }

    @Override
    public List<Staff> getAllAdmins() {
        return staffRepository.findAll();
    }

    @Override
    public StaffDto updateAdminById(Long adminId, StaffDto staffDto) throws StaffNotFoundException {
        Optional<Staff> optionalAdmin = staffRepository.findById(adminId);

        if (optionalAdmin.isPresent()) {
            Staff staff = optionalAdmin.get();

            staff.setFirstName(staffDto.getFirstName());
            staff.setLastName(staffDto.getLastName());
            staff.setUserName(staffDto.getUserName());
            staff.setEmail(staffDto.getEmail());

            // Save the updated staff
            staffRepository.save(staff);

            return StaffMapper.mapToAdminDto(staff);

        } else {
            throw new StaffNotFoundException("Staff not found with id: " + adminId);
        }
    }
}
