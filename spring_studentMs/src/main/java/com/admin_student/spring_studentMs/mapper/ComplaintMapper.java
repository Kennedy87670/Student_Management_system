package com.admin_student.spring_studentMs.mapper;

import com.admin_student.spring_studentMs.dto.ComplaintDto;
import com.admin_student.spring_studentMs.entity.Complaint;


public class ComplaintMapper {
    public static ComplaintDto mapToComplaintDto(Complaint complaint){
        ComplaintDto complaintDto = new ComplaintDto(
                complaint.getId(),
                complaint.getDescription()
        )      ;
        return  complaintDto;
    }



    public static Complaint mapToComplaint(ComplaintDto complaintDto){
      Complaint complaint  = new Complaint(
              complaintDto.getId(),
              complaintDto.getDescription()

      ) ;
      return complaint;
    }
}
