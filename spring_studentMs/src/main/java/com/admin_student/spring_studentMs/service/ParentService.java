package com.admin_student.spring_studentMs.service;

import com.admin_student.spring_studentMs.dto.ParentsDto;
import com.admin_student.spring_studentMs.entity.Parents;
import com.admin_student.spring_studentMs.errorAndException.ParentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface ParentService {
 public Optional<ParentsDto> getParentById(Long parentId) throws ParentNotFoundException;

   public Parents save(Parents parents);

    void deleteParentById(Long parentId);

    public List<Parents> getAllParents();


    ParentsDto updateParentById(Long parentId, ParentsDto updatedParentDto) throws ParentNotFoundException;
}
