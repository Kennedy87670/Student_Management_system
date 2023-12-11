package com.admin_student.spring_studentMs.mapper;

import com.admin_student.spring_studentMs.auth.RegisterRequest;
import com.admin_student.spring_studentMs.dto.StaffDto;
import com.admin_student.spring_studentMs.entity.Staff;


public class StaffMapper {

    public static StaffDto mapToAdminDto(Staff staff){
        StaffDto staffDto = new StaffDto(
                staff.getId(),
                staff.getFirstName(),
                staff.getLastName(),
                staff.getEmail(),
                staff.getUserName()
        );
        return staffDto;
    }
    public static Staff mapToAdmin(StaffDto staffDto){
       Staff staff = new Staff(
               staffDto.getId(),
               staffDto.getFirstName(),
               staffDto.getLastName(),
               staffDto.getEmail(),
               staffDto.getUserName()
       );
       return staff;
    }
    public static Staff mapToAdmin(RegisterRequest request) {
        return com.admin_student.spring_studentMs.entity.Staff.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .userName(request.getUserName())
                .build();
    }
}
