package com.admin_student.spring_studentMs.mapper;

import com.admin_student.spring_studentMs.auth.RegisterRequest;
import com.admin_student.spring_studentMs.dto.AdminDto;
import com.admin_student.spring_studentMs.entity.Admin;


public class AdminMapper {

    public static AdminDto mapToAdminDto(Admin admin){
        AdminDto adminDto = new AdminDto(
                admin.getId(),
                admin.getFirstName(),
                admin.getLastName(),
                admin.getEmail(),
                admin.getUserName()
        );
        return adminDto;
    }
    public static Admin mapToAdmin(AdminDto adminDto){
       Admin admin = new Admin(
               adminDto.getId(),
               adminDto.getFirstName(),
               adminDto.getLastName(),
               adminDto.getEmail(),
               adminDto.getUserName()
       );
       return admin;
    }
    public static Admin mapToAdmin(RegisterRequest request) {
        return Admin.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .userName(request.getUserName())
                .build();
    }
}
