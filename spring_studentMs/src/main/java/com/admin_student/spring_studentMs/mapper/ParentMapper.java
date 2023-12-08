package com.admin_student.spring_studentMs.mapper;

import com.admin_student.spring_studentMs.auth.RegisterRequest;
import com.admin_student.spring_studentMs.dto.ParentsDto;
import com.admin_student.spring_studentMs.entity.Parents;

public class ParentMapper {

    public static ParentsDto mapToParentDto(Parents parents){
        ParentsDto parentsDto = new ParentsDto(
                parents.getId(),
                parents.getFirstName(),
                parents.getLastName(),
                parents.getEmail(),
                parents.getUserName()
        );

        return parentsDto;
    }

    public static Parents mapToParent(ParentsDto parentsDto){
        Parents parents = new Parents(
                parentsDto.getId(),
                parentsDto.getFirstName(),
                parentsDto.getLastName(),
                parentsDto.getEmail(),
                parentsDto.getUserName()
        );
        return parents;
    }

    public static Parents mapToParent(RegisterRequest request) {
        return Parents.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .userName(request.getUserName())
                .build();
    }

}
